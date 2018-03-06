package dao;/**
 * Created by Kaiser on 2018/1/20.
 */
/********************************************************************
 /**
 * @Project: java_practice
 * @Package dao
 * @author zuorui
 * @date 2018/1/20 17:24
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.GoodsOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zuorui
 * @InterfaceName GoodsOrderDao
 * @Description 接口描述
 * @date 2018/1/20
 */
public interface GoodsOrderDao {

    /**
     * @throws java.sql.SQLException
     * @Title: findGoodsOrderById
     * @Description: 根据ID查询
     * @author zuorui
     * @date 2018-01-22
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     * @throws: SQLException
     */
    public GoodsOrder findGoodsOrderById(Long id);

    /**
     * @return 受影响的行
     * @throws java.sql.SQLException
     * @Title addGoodsOrderById
     * @Description 根据ID增加订单信息
     * @author zuorui
     * @date 2018-01-22
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     */
    public Integer addGoodsOrderById(GoodsOrder goodsOrder);

    /**
     * @return 受影响的行
     * @Title 修改订单信息
     * @Description updateGoodsOrder
     * @author zuorui
     * @date 2018-01-22
     * @param: goodsOrde 订单对象
     */
    public Integer updateGoodsOrder(GoodsOrder goodsOrde);

    /**
     * @Title: findGoodsOrderByNum
     * @Description: 查过订单编号查询订单
     * @author yanyong
     * @date 2018-01-26
     * @param: goodsNum 商品编号
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     * @throws: SQLException
     */

    public GoodsOrder findGoodsOrderByNum(String goodsNum);

    /**
     * @Title: findGoodsOrderByPeopleId
     * @Description:  通过人员id  获取订单信息
     * @author yanyong
     * @date 2018-01-31
     * @param: peopleId指定人员id
     * @param: goodsNum 商品编号
     * @param: connection 连接对象
     * @return: 订单信息集合
     * @throws: SQLException
     */
    public List<GoodsOrder> findGoodsOrderByPeopleId(Long peopleId);


}
