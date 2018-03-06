package dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package dao
 * @author 胡志强
 * @date 2018/1/20 17:07
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.Store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author 胡志强
 * @InterfaceName Store
 * @Description 操作店铺相关数据表的接口
 * @date 2018/1/20
 */
public interface StoreDao {
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
    public List<Store> findStoreById(Long id) throws SQLException;

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
    public Store findStoreByStoreNum(String storeNum) throws SQLException;

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
    public Long saveStore(Store store) throws SQLException;

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
    public Integer deleteStoreById(Long id) throws SQLException;

    /**
     * @Title: updatePeopleById
     * @Description: 更新指定商铺的信息
     * @author hzq
     * @date 2018-01-21
     * @param: id 指定商铺id
     * @param: people 指定商铺信息
     * @param: connection 连接对象
     * @param: prepareStatement 预编译 Statement对象
     * @return: 受影响行数
     */
    public Integer updateStoreById(Long id, Store store) throws SQLException;

    /**
     * @param map 条件和值对应key和value
     * @Title: findStoreByUnSureCondition
     * @Description: 商铺的不确定条件查询
     * @author hzq
     * @date 2018/01/30
     * @throw SQLException
     */
    public List<Store> findStoreByUnSureCondition(List<Map<String, Object>> map)
            throws SQLException;
    /**
     * @Title: findAllStore
     * @Description: 查询全部商铺信息
     * @author hzq
     * @date 2018/01/30
     * @throw SQLException
     */
    public List<Store> findAllStore()
            throws SQLException;
}