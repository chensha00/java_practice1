package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author liukang
 * @date 2018/1/25 16:59
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import Entity.MainPage;
import domain.Goods;
import domain.Invertory;
import domain.Store;
import tools.GoodsException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author liukang
 * @InterfaceName InvertoryService
 * @Description 库存 操作 接口
 * @date 2018/1/25
 */

public interface InvertoryService {


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
    public Invertory findInvertoryById(Long id);


    /**
     * @Title: deleteInvertoryById
     * @Description: 删除库存信息 通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 受影响行数
     */
    public Integer deleteInvertoryById(Long id);

    /**
     * @Title: updateInvertorById
     * @Description: 更新库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @param: invertory 库存对象
     * @return: 受影响行数
     */


    public Integer updateInvertorById(Long id, Invertory invertory);

    /**
     * @Title: changeGoodsNumberById
     * @Description: 修改指定id的商品数量
     * @author yanyong
     * @date 2018-01-22
     * @param: id 指定id
     * @param: number 商品数量
     * @return: 修改行数
     */
    public Integer changeGoodsNumberById(Long id, Double number);

    /**
     * @Title: stock
     * @Description: 商品进货
     * @author yanyong
     * @date 2018-01-22
     * @param: store 指定商铺
     * @param: goods 进货的商品
     * @param: addNum 进货的数量
     * @param: price 进货后设定卖价
     * @return: 受影响行数
     */
    public Integer stock(Store store, Goods goods, Double addNum, Double price);

    /**
     * @Title: sale
     * @Description: 出售商品
     * @author yanyong
     * @date 2018-01-22
     * @param: id 对指定id的商品出售
     * @param: saleNum 出售数量
     * @return: 受影响行数
     */
    public Integer sale(Long id, Double saleNum) throws GoodsException;

    /**
     * @Title: judgeNumberIsEnough
     * @Description: 判断数量是否足够
     * @author yanyong
     * @date 2018-01-23
     * @param: id 指定id
     * @param: needNumber 需要数量
     * @return: 数量是否足够，false--否，true--是
     */
    public Boolean judgeNumberIsEnough(Long id, Double needNumber);

    /**
     * @Title: calculationMoney
     * @Description: 计算商品金额
     * @author yanyong
     * @date 2018-01-22
     * @param: goods 商品
     * @param: num 数量
     * @return: 计算金额
     */
    public Double calculationMoney(Invertory invertory, Double num);

    /**
     * @Title: showInvertory
     * @Description: 查看库存信息
     * @author yanyong
     * @date 2018-01-26
     * @throw YnCorpSysException
     * @param: 库存对象
     */
    public void showInvertory(Invertory invertory);

    /**
     * @param storeId:商铺id
     * @param goodsId：商铺id
     * @Title: findInvertoryByStoreIdAndGoodId
     * @Description: 根据商铺id和商铺id查找库存信息
     * @author hzq
     * @date 2018-01-26
     * @throw RuntimeException
     */
    public Invertory findInvertoryByStoreIdAndGoodsId(Long storeId, Long goodsId) throws SQLException;


    /**
     * @param map 条件和值对应key和value
     * @Title: findMainPageInvertory
     * @Title: findInvertoryByUnSureCondition
     * @Description: 通过商铺id查找库存信息
     * @author hzq
     * @date 2018/01/30
     * @throw SQLException
     */
    public List<Invertory> findInvertoryByUnSureCondition(List<Map<String, Object>> map) throws SQLException;


    /**
     * @Title: findMainPageInvertory
     * @Description: 查询所有订单的价格，数量，以及商品的ID
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageInvertory(Long start,Long end);

    /**
     * @Title: findMainPageCondition
     * @Description: 根据条件查询主页面的显示
     * @author kang
     * @date 2018-03-06
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageCondition(String condition);
    /**
     * @Title: findMainPageByStoreId
     * @Description: 根据条件查询主页面的显示
     * @author kang
     * @date 2018-03-06
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageByStoreId(Long storeId);

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
     * @Title: limitMainPage
     * @Description: 分页页数
     * @author kang
     * @date 2018-03-08
     * @throw YnCorpSysException
     */
    public Integer limitMainPage();

}