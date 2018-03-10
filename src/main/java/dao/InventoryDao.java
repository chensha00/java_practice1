package dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package dao
 * @author liukang
 * @date 2018/1/25 16:57
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.Inventory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * @author liukang
 * @InterfaceName inventoryDap
 * @Description 库存数据库操作接口
 * @date 2018/1/25
 */
public interface InventoryDao {
    /**
     * @Title: saveInventory
     * @Description: 保存库存信息
     * @author yanyong
     * @date 2018-01-25
     * @param: inventory 库存对象
     * @return: 受影响行数
     */
    public Integer saveInventory(Inventory inventory);

    /**
     * @Title: findInventoryById
     * @Description: 查找库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 库存对象
     */
    public Inventory findInventoryById(Long id);

    /**
     * @Title: findInventoryById
     * @Description: 查找库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 库存对象
     */
    public List<Inventory> findInventoryAll();


    /**
     * @Title: deleteInventoryById
     * @Description: 删除库存信息 通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 受影响行数
     */
    public Integer deleteInventoryById(Long id) throws SQLException;

    /**
     * @Title: updateInvertorById
     * @Description: 更新库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @param: inventory 库存对象
     * @return: 受影响行数
     */


    public Integer updateInventorById(Long id, Inventory inventory)
            throws SQLException;

    /**
     * @param storeId:商铺id
     * @param goodsId：商铺id
     * @Title: findInventoryByStoreIdAndGoodId
     * @Description: 根据商铺id和商品id查找库存信息
     * @author hzq
     * @date 2018-01-26
     * @throw RuntimeException
     */
    public Inventory findInventoryByStoreIdAndGoodsId(Long storeId, Long goodsId);

    /**
     * @param map 条件和值对应key和value
     * @Title: findInventoryByUnSureCondition
     * @Description: 通过商铺id查找库存信息
     * @author hzq
     * @date 2018/01/30
     * @throw SQLException
     */
    public List<Inventory> findInventoryByUnSureCondition(List<Map<String, Object>> map)
            throws SQLException;

    /**
     * @Title: findMainPageNum
     * @Description: 查询库存条数
     * @author kang
     * @date 2018-03-08
     * @throw YnCorpSysException
     */

}