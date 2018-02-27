package dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package dao
 * @author liukang
 * @date 2018/1/25 16:57
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.Invertory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * @author liukang
 * @InterfaceName InvertoryDap
 * @Description 库存数据库操作接口
 * @date 2018/1/25
 */
public interface InvertoryDao {
    /**
     * @Title: saveInvertory
     * @Description: 保存库存信息
     * @author yanyong
     * @date 2018-01-25
     * @param: invertory 库存对象
     * @return: 受影响行数
     */
    public Integer saveInvertory(Invertory invertory);

    /**
     * @Title: findInvertoryById
     * @Description: 查找库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 库存对象
     */
    public List<Invertory> findInvertoryById(Long id);

    /**
     * @Title: findInvertoryById
     * @Description: 查找库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 库存对象
     */
    public List<Invertory> findInvertoryAll();


    /**
     * @Title: deleteInvertoryById
     * @Description: 删除库存信息 通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 受影响行数
     */
    public Integer deleteInvertoryById(Long id) throws SQLException;

    /**
     * @Title: updateInvertorById
     * @Description: 更新库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @param: invertory 库存对象
     * @return: 受影响行数
     */


    public Integer updateInvertorById(Long id, Invertory invertory)
            throws SQLException;

    /**
     * @param storeId:商铺id
     * @param goodsId：商铺id
     * @Title: findInvertoryByStoreIdAndGoodId
     * @Description: 根据商铺id和商品id查找库存信息
     * @author hzq
     * @date 2018-01-26
     * @throw RuntimeException
     */
    public Invertory findInvertoryByStoreIdAndGoodsId(Long storeId, Long goodsId)
            throws SQLException;

    /**
     * @param map 条件和值对应key和value
     * @Title: findInvertoryByUnSureCondition
     * @Description: 通过商铺id查找库存信息
     * @author hzq
     * @date 2018/01/30
     * @throw SQLException
     */
    public List<Invertory> findInvertoryByUnSureCondition(List<Map<String, Object>> map)
            throws SQLException;


    /**
     * @Title: findMainPageInvertory
     * @Description: 查询所有订单的价格，数量，以及商品的ID
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<javabean.MainPage> findMainPageInvertory() throws SQLException;

}