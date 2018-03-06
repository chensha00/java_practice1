package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author 胡志强
 * @date 2018/1/20 17:09
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.Goods;
import domain.Store;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 胡志强
 * @InterfaceName StoreService
 * @Description 店铺相关业务的接口
 * @date 2018/1/20
 */
public interface StoreService {
    /**
     * @Title: findStoreById
     * @Description: 通过指定Id查找商铺
     * @author hzq
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 商铺对象
     */
    public Store findStoreById(Long id) throws RuntimeException;

    /**
     * @Title: findStoreByStoreNum
     * @Description: 通过指定storeNum查找商铺
     * @author hzq
     * @date 2018-01-21
     * @param: id 指定storeNum
     * @return: 商铺对象
     */
    public Store findStoreByStoreNum(String storeNum) throws RuntimeException;

    /**
     * @Title: saveStore
     * @Description: 保存人员信息
     * @author hzq
     * @date 2018-01-21
     * @param: Store 人员对象
     * @return: 受影响行数
     */
    public Long saveStore(Store Store) throws RuntimeException;

    /**
     * @Title: showStore
     * @Description: 查看商铺信息
     * @author hzq
     * @date 2018-01-21
     * @param: store 商铺对象
     */
    public void showStore(Store store) throws RuntimeException;

    /**
     * @Title: deleteStoreById
     * @Description: 删除指定id 的商铺信息
     * @author hzq
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 受影响行数
     */
    public Integer deleteStoreById(Long id) throws RuntimeException;

    /**
     * @Title: updateStoreById
     * @Description: 更新指定商铺的信息
     * @author hzq
     * @date 2018-01-21
     * @param: id 指定商铺id
     * @param: store 指定的商铺的信息
     * @return: 受影响行
     */
    public Integer updateStoreById(Long id, Store store);

    /**
     * @param goods  要进的货
     * @param store  商铺信息
     * @param number 进货的数量
     * @param price
     * @Title: setStock
     * @Description: 商铺进货
     * @author hzq
     * @date 2018-01-21
     * @return: 是否成功
     */
    public boolean setStock(List<Goods> goods, Double[] number, Store store, Double[] price);

    /**
     * @param orderDetailId 订单详情
     * @Title: delivery
     * @Description: 商铺发货
     * @author hzq
     * @date 2018-01-21
     * @return: 是否成功
     */
    public Date delivery(Long orderDetailId) throws RuntimeException;
    /**
     * @Title: findStoreByUnSureCondition
     * @Description: 商铺的不确定条件查询
     * @author hzq
     * @date 2018/01/30
     * @param map 条件和值对应key和value
     * @throw SQLException
     */
    public List<Store> findStoreByUnSureCondition(List<Map<String,Object>> map)
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