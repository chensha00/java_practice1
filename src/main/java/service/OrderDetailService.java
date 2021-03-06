package service;/**
 * Created by Roger_yu on 2018/1/20.
 */

import domain.GoodsOrder;
import domain.OrderDetail;

import java.util.List;

/**
 * @author yuweiyang
 * @InterfaceName OrderDetailService
 * @Description 订单详情service接口
 * @date 2018/1/20
 */
public interface OrderDetailService {
    /**
     * @Title: saveOrderDetail
     * @Description: 新增订单详情信息
     * @author yuweiyang
     * @date 2018-01-21
     * @throw SQLException
     * @param: people 人员信息
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement
     * @return: 受影响行数
     */
    public OrderDetail findOrderDetailById(Long id);

    /**
     * @Title: saveOrderDetail
     * @Description: 新增订单详情信息
     * @author yuweiyang
     * @date 2018-01-21
     * @throw SQLException
     * @param: people 人员信息
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement
     * @return: 受影响行数
     */
    public Integer saveOrderDetail(OrderDetail orderDetail);


    /**
     * @Title: updateOrderDetailById
     * @Description: 更新指定订单详情的信息
     * @author yuweiyang
     * @date 2018-01-21
     * @param: id 指定人员id
     * @param: orderDetail 指定订单详情
     * @param: connection 连接对象
     * @param: prepareStatement 预编译 Statement对象
     * @return: 受影响行数
     */
    public Integer updateOrderDetailById(Long id, OrderDetail orderDetail);

    /**
     * @Title: getGoodsDetailListByOrderId
     * @Description: 获取指定订单id 的订单详情
     * @author yuweiyang
     * @date 2018-01-28
     * @param: orderId 指定订单id
     * @return: 订单详情集合
     */
    public List<OrderDetail> findOrderDetailListByOrderId(Long orderId);

    /**
     * @Title: findOrderDetailByPeopleId
     * @Description: 通过商铺id查找订单详情
     * @author yuweiyang
     * @date 2018-01-31
     * @param: peopleId 指定人员id
     * @return: 订单详情集合
     */
    public List<OrderDetail> findOrderDetailByStoreId(Long storeId);

    /**
     * @Title: findOrderDetailByPeopleId
     * @Description: 通过人员id查找订单详情
     * @author yuweiyang
     * @date 2018-01-31
     * @param: peopleId 指定人员id
     * @return: 订单详情集合
     */
    public List<OrderDetail> findOrderDetailByPeopleId(Long peopleId);

    /**
     * @Title: showOrderDetailMessage
     * @Description: 订单详情查看
     * @author yuweiyang
     * @date 2018-01-31
     * @param: orderDetail 订单详情对象
     */

    public void showOrderDetailMessage(OrderDetail orderDetail);

    /**
     * @Title: findOrderDetailByOrderList
     * @Description: 查找指定List<GoodsOrder>的订单详情集合
     * @author yanyong
     * @date 2018-03-12
     * @param: goodsOrderList 指定List<GoodsOrder>
     * @return:  List<OrderDetail>
     */
    public List<OrderDetail> findOrderDetailByOrderList(List<GoodsOrder> goodsOrderList);
}