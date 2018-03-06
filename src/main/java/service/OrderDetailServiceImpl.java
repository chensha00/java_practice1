package service;/**
 * Created by Roger_yu on 2018/1/20.
 */

import dao.OrderDetailDao;
import domain.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuweiyang
 * @ClassName OrderDetailServiceImpl
 * @Description 订单详情service接口实现
 * @date 2018/1/20
 */


@Service("orderDetailService")
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

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
    public OrderDetail findOrderDetailById(Long id) {
        OrderDetail orderDetail = null;
        try {
            orderDetail = orderDetailDao.findOrderDetailById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetail;
//        return null;
    }

    ;

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
    @Override
    public Integer saveOrderDetail(OrderDetail orderDetail) {
        Integer integer = null;
        try {
            integer = orderDetailDao.saveOrderDetail(orderDetail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return integer;
    }

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
    @Override
    public Integer updateOrderDetailById(Long id, OrderDetail orderDetail) {
        Integer integer = null;
        try {
            integer = orderDetailDao.updateOrderDetailById(id, orderDetail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return integer;
    }

    /**
     * @Title: getGoodsDetailListByOrderId
     * @Description: 获取指定订单id 的订单详情
     * @author yanyong
     * @date 2018-01-28
     * @param: orderId 指定订单id
     * @return: 订单详情集合
     */
    public List<OrderDetail> findOrderDetailListByOrderId(Long orderId) {
        List<OrderDetail> orders = orderDetailDao.findOrderDetailListByOrderId(orderId);
        return orders;
    }

    /**
     * @Title: findOrderDetailByPeopleId
     * @Description: 通过人员id查找订单详情
     * @author yanyong
     * @date 2018-01-31
     * @param: peopleId 指定人员id
     * @return: 订单详情集合
     */
    public List<OrderDetail> findOrderDetailByPeopleId(Long peopleId) {
        List<OrderDetail> orders = new ArrayList<OrderDetail>();
        try {
            orders = orderDetailDao.findOrderDetailByPeopleId(peopleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * @Title: showOrderDetailMessage
     * @Description: 订单详情查看
     * @author yanyong
     * @date 2018-01-31
     * @param: orderDetail 订单详情对象
     */

    public void showOrderDetailMessage(OrderDetail orderDetail) {
        System.out.print("id:" + orderDetail.getId() + " ");
        System.out.print("编号:" + orderDetail.getOrderNum() + " ");
        System.out.print("人员id:" + orderDetail.getPeopleId() + " ");
        System.out.print("商铺id：" + orderDetail.getStoreId() + " ");
        System.out.print("商品id：" + orderDetail.getGoodsId() + " ");
        System.out.print("数量：" + orderDetail.getNumber() + " ");
        System.out.print("价格：" + orderDetail.getGoodsPrice() + " ");
        System.out.print("添加时间：" + orderDetail.getAddTime() + " ");
        System.out.print("支付成功时间：" + orderDetail.getSuccessTime() + " ");
        System.out.print("发货时间：" + orderDetail.getDeliveryTime() + " ");
        System.out.print("订单状态：" + orderDetail.getOrderStatus() + " ");
        System.out.print("是否作废:" + orderDetail.getIsInvalid() + " ");
        System.out.println();

    }
}
