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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import service.GoodsService;
import service.InvertoryService;
import service.StoreService;

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
        return this.sqlSessionTemplate.insert(getMybaitsNameSpace() + "saveInvertory", invertory);
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
    public Invertory findInvertoryById(Long id) {
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace() + "findInvertoryById",id);
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
    public List<Invertory> findInvertoryAll() {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findInvertoryAll");
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
        return this.sqlSessionTemplate.delete(getMybaitsNameSpace() + "deleteInvertoryById", id);
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
        return this.sqlSessionTemplate.update(getMybaitsNameSpace() + "updateInvertorById", map);
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
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace() + "findInvertoryByStoreIdAndGoodsId");
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
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findInvertoryByUnSureCondition",map);
    }

}
