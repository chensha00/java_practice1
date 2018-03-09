package dao;/**
 * Created by Roger_yu on 2018/1/20.
 */

import domain.OrderDetail;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yuweiyang
 * @InterfaceName OrderDetailDao
 * @Description 订单详情数据库接口
 * @date 2018/1/20
 */
public interface OrderDetailDao {
    /**
     * @Title: findOrderDetailById
     * @Description: 通过指定Id查找相应订单详情
     * @author yuweiyang
     * @date 2018-01-21
     * @throws: SQLException
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     * @return: 订单详情对象
     */
    public OrderDetail findOrderDetailById(Long id) throws SQLException;


    /**
     * @Title: addOrderDetail
     * @Description: 新增订单详情信息
     * @author yuweiyang
     * @date 2018-01-21
     * @throw SQLException
     * @param: people 人员信息
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement
     * @return: 受影响行数
     */
    public Integer saveOrderDetail(OrderDetail orderDetail) throws SQLException;


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
    public Integer updateOrderDetailById(Long id, OrderDetail orderDetail) throws SQLException;

    /**
     * @Title: findOrderDetailById
     * @Description: 通过指定订单编号查找相应订单详情ID
     * @author yuweiyang
     * @date 2018-01-21
     * @throws: SQLException
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     * @return: 订单详情
     */
    public List<OrderDetail> findOrderDetailIdByOrderNum(String orderNum) throws SQLException;

    /**
     * @Title: getGoodsDetailListByOrderId
     * @Description: 获取指定订单id 的订单详情
     * @author yanyong
     * @date 2018-01-28
     * @param: orderId 指定订单id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     * @return: 订单详情集合
     */
    public List<OrderDetail> findOrderDetailListByOrderId(Long goodsOrderId);

    /**
     * @Title: findOrderDetailByPeopleId
     * @Description: 通过商铺id查找订单详情
     * @author yanyong
     * @date 2018-01-31
     * @param: peopleId 指定商铺id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     * @return: 订单详情集合
     * @throws: SQLException
     */
    public List<OrderDetail> findOrderDetailByStoreId(Long storeId) throws SQLException;

    /**
     * @Title: findOrderDetailByPeopleId
     * @Description: 通过人员id查找订单详情
     * @author yanyong
     * @date 2018-01-31
     * @param: peopleId 指定人员id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     * @return: 订单详情集合
     * @throws: SQLException
     */
    public List<OrderDetail> findOrderDetailByPeopleId(Long peopleId) throws SQLException;
}
