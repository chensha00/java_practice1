package dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package dao
 * @author liukang
 * @date 2018/1/25 16:57
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.base.BaseDaoImpl;
import domain.Invertory;
import javabean.MainPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import service.GoodsService;
import service.InvertoryService;
import service.StoreService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liukang
 * @ClassName InvertoryDaoImpl
 * @Description 库存数据库操作类实现InvertoryDao
 * @date 2018/1/25
 */
@Repository("invertoryDao")
public class InvertoryDaoImpl extends BaseDaoImpl<Invertory> implements InvertoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private InvertoryService invertoryService;

    /**
     * @Title: saveInvertory
     * @Description: 保存库存信息
     * @author yanyong
     * @date 2018-01-25
     * @param: invertory 库存对象
     * @return: 受影响行数
     */
    @Override
    public Integer saveInvertory(Invertory invertory) {
        return this.sqlSessionTemplate.insert(getMybaitsNameSpace() + "save", invertory);
    }

    /**
     * @Title: findInvertoryById
     * @Description: 查找库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 库存对象
     */
    @Override
    public List<Invertory> findInvertoryById(Long id) {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "getAll");
    }


    /**
     * @Title: deleteInvertoryById
     * @Description: 删除库存信息 通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 受影响行数
     */
    @Override
    public Integer deleteInvertoryById(Long id) throws SQLException {
        return this.sqlSessionTemplate.delete(getMybaitsNameSpace() + "deleteById", id);
    }

    /**
     * @Title: updateInvertorById
     * @Description: 更新库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @param: invertory 库存对象
     * @return: 受影响行数
     */
    @Override
    public Integer updateInvertorById(Long id, Invertory invertory) throws SQLException {
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        map1.put("invertory", invertory);
        map2.put("id", id);
        return this.sqlSessionTemplate.update(getMybaitsNameSpace() + "updateStoreById", map);
    }

    /**
     * @param storeId:商铺id
     * @param goodsId：商品id
     * @Title: findInvertoryByStoreIdAndGoodId
     * @Description: 根据商铺id和商品id查找库存信息
     * @author hzq
     * @date 2018-01-26
     * @throw RuntimeException
     */
    @Override
    public Invertory findInvertoryByStoreIdAndGoodsId(Long storeId, Long goodsId)
            throws SQLException {
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"storeAndGoods");
    }

    /**
     * @param map 条件和值对应key和value
     * @Title: findInvertoryByUnSureCondition
     * @Description: 通过商铺id查找库存信息
     * @author hzq
     * @date 2018/01/30
     * @throw SQLException
     */
    public List<Invertory> findInvertoryByUnSureCondition(List<Map<String, Object>> map)
            throws SQLException {
        //通过拼接sql语句来实现动态的不确定条件查询
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ID,STORE_ID,GOODS_ID,PRICE,NUMBER FROM invertory WHERE 1 =1 ");
        if (map != null && map.size() > 0) {
            for (int i = 0; i < map.size(); i++) {
                //将条件拼接到sql中
                Map<String, Object> condition = map.get(i);
                sql.append(" and " + condition.get("name") + " " + condition.get("rela") + " " + condition.get("value") + " ");
            }
        }
        //输出sql语句并执行sql语句
        System.out.println(sql.toString());
        List<Invertory> invertories = jdbcTemplate.query(sql.toString(), new ResultSetExtractor<List<Invertory>>() {
            @Override
            public List<Invertory> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Invertory> invertories = new ArrayList<Invertory>();
                //将结果放入list中返回
                while (resultSet.next()) {
                    Invertory invertory = new Invertory();
                    invertory.setId(resultSet.getLong(1));
                    invertory.setStoreId(resultSet.getLong(2));
                    invertory.setGoodsId(resultSet.getLong(3));
                    invertory.setPrice(resultSet.getDouble(4));
                    invertory.setNumber(resultSet.getDouble(5));
                    invertories.add(invertory);
                }
                return invertories;
            }

        });
        return invertories;
    }


    /**
     * @Title: findMainPageInvertory
     * @Description: 查询所有订单的价格，数量，以及商品的ID
     * @author liukang
     * @date
     * @throw SQLException
     */
    @Override
    public List<javabean.MainPage> findMainPageInvertory() throws SQLException {
        String selectSQL = "SELECT STORE_ID,GOODS_ID,PRICE,NUMBER FROM INVERTORY ORDER BY ID LIMIT 0,100; ";
        System.out.println(selectSQL.toString());
        List<MainPage> mainPages = jdbcTemplate.query(selectSQL.toString(), new ResultSetExtractor<List<MainPage>>() {
            @Override
            public List<MainPage> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<MainPage> mainPages = new ArrayList<MainPage>();
                if (resultSet != null) {
                    while (resultSet.next()) {
                        javabean.MainPage mainPage = new javabean.MainPage();
                        mainPage.setStoreName(storeService.findStoreById(resultSet.getLong(1)).getStoreName());
                        mainPage.setName((goodsService.findGoodsById(resultSet.getLong(2))).getName());
                        mainPage.setPrice(resultSet.getDouble(3));
                        mainPage.setNumber(resultSet.getDouble(4));
                        mainPages.add(mainPage);
                    }
                }
                return mainPages;
            }

        });
        return mainPages;
    }
}
