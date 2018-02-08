package dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package dao
 * @author 胡志强
 * @date 2018/1/20 17:08
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.base.BaseDaoImpl;
import domain.Store;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import service.StoreService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 胡志强
 * @ClassName StoreDaoImpl
 * @Description StoreDao接口的实现类
 * @date 2018/1/20
 */
@Repository("storeDao")
public class StoreDaoImpl extends BaseDaoImpl<Store> implements StoreDao {
    @Autowired
    private StoreService storeService;
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * @Title: findStoreById
     * @Description: 通过指定Id查找商铺
     * @author hzq
     * @date 2018-01-21
     * @throws: SQLException
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     * @return: Store对象
     */
    @Override
    public List<Store> findStoreById(Long id) throws SQLException {

        //查询所有的商品
        return  this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findStoreById",id);
    }

    /**
     * @Title: findStoreByStoreNum
     * @Description: 通过指定编号查找商铺
     * @author hzq
     * @date 2018-01-25
     * @throws: SQLException
     * @param: storeNum 指定编号
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     * @return: Store对象
     */
    public Store findStoreByStoreNum(String storeNum) throws SQLException {

        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace() + "findStoreByStoreNum",storeNum);
    }


    /**
     * @Title: saveStore
     * @Description: 保存商铺信息
     * @author hzq
     * @date 2018-01-21
     * @throw SQLException
     * @param: people 商铺信息
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement
     * @return: 插入的商品的id
     */
    @Override
    public Long saveStore(Store store) throws SQLException {
        //受影响的行数
        String saveSqlDefault = "INSERT INTO store(STORE_NUM,STORE_NAME,CREDIT,PEOPLE_ID) VALUES(?,?,?,?)";
        //设置参数
       jdbcTemplate.update(saveSqlDefault,store.getStoreNum(),store.getStoreName(),store.getCredit(),store.getPeopleId());
        Long storeId = storeService.findStoreByStoreNum(store.getStoreNum()).getId();
        return storeId;
    }

    /**
     * @Title: deleteStoreById
     * @Description: 删除指定id 的商铺信息
     * @author hzq
     * @date 2018-01-21
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: prepareStatement 预编译 Statement对象
     * @return: 受影响行数
     */
    @Override
    public Integer deleteStoreById(Long id) throws SQLException {
        Integer number = 0;
        String deleteSql = "DELETE FROM store WHERE ID=?;";
        number=jdbcTemplate.update(deleteSql,id);
        return number;
    }

    /**
     * @Title: updatePeopleById
     * @Description: 更新指定商铺的信息
     * @author hzq
     * @date 2018-01-21
     * @param: id 指定商铺id
     * @param: store 指定商铺信息
     * @param: connection 连接对象
     * @param: prepareStatement 预编译 Statement对象
     * @return: 受影响行数
     */
    @Override
    public Integer updateStoreById(Long id,Store store) throws SQLException {
        Integer number = 0;
        String updateSql = "UPDATE store SET STORE_NUM=?,STORE_NAME=?,CREDIT=?,PEOPLE_ID=? WHERE ID=?;";
        number=
                jdbcTemplate.update(updateSql,store.getStoreNum(),store.getStoreName(),store.getCredit(),store.getPeopleId());
        return number;
    }
    /**
     * @Title: findStoreByUnSureCondition
     * @Description: 商铺的不确定条件查询
     * @author hzq
     * @date 2018/01/30
     * @param map 条件和值对应key和value
     * @throw SQLException
     */
    public List<Store> findStoreByUnSureCondition(List<Map<String,Object>> map)
            throws SQLException {

        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findStoreByUnSureCondition", map);
    }
}