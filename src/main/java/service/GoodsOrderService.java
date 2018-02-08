package service;/**
 * Created by Kaiser on 2018/1/20.
 */
/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author zuorui
 * @date 2018/1/20 17:25
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.GoodsOrder;

import java.util.List;

/**
 * @author zuorui
 * @InterfaceName GoodsOrderService
 * @Description 接口描述
 * @date 2018/1/20
 */
public interface GoodsOrderService {
    /**
     * @Title: findGoodsOrderById
     * @Description: 方法描述
     * @author zuorui
     * @date 2018-01-22
     * @param: id 指定id
     */
    public GoodsOrder findGoodsOrderById(Long id);

    /**
     * @return 受影响的行
     * @Title addGoodsOrderById
     * @Description 根据ID增加订单信息
     * @author zuorui
     * @date 2018-01-22
     * @param: id 指定id
     * @param: connection 连接对象
     */
    public Integer addGoodsOrderById(GoodsOrder goodsOrder);

    /**
     * @return 受影响的行
     * @Title 修改订单信息
     * @Description
     * @author zuorui
     * @date 2018-01-22
     * @param: id 指定id
     * @param: goodsOrder 订单信息
     */
    public Integer updateGoodsOrderById(Long id, GoodsOrder goodsOrder);

    /**
     * @Title: showGoodsOrder
     * @Description: 查看订单信息
     * @author yanyong
     * @date 2018-01-26
     * @param: goodsOrder 订单实体
     */
    public void showGoodsOrder(GoodsOrder goodsOrder);

    /**
     * @Title: findGoodsOrderByNum
     * @Description: 查过订单编号查询订单
     * @author yanyong
     * @date 2018-01-26
     * @param: goodsNum 商品编号
     * @return:
     */

    public GoodsOrder findGoodsOrderByNum(String goodsNum);

    /**
     * @Title: findGoodsOrderByPeopleId
     * @Description: 获取订单信息通过人员id
     * @author yanyong
     * @date 2018-01-31
     * @param: peopleId指定人员id
     * @return: 订单信息集合
     */
    public List<GoodsOrder> findGoodsOrderByPeopleId(Long peopleId);
}
