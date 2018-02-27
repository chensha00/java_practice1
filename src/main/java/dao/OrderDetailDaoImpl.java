package dao;/**
 * Created by Roger_yu on 2018/1/20.
 */

import common.util.AddConditionUtils;
import common.util.base.BaseDaoImpl;
import domain.OrderDetail;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import service.OrderDetailService;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuweiyang
 * @ClassName OrderDetailDaoImpl
 * @Description 订单详情数据库接口实现
 * @date 2018/1/20
 */
@Repository("orderDetailDao")
public class OrderDetailDaoImpl extends BaseDaoImpl<OrderDetail> implements OrderDetailDao {

    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;
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
    @Override
    public OrderDetail findOrderDetailById(Long id) throws SQLException {
        List<OrderDetail> orderDetailList=this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findOrderDetailById", id);
        return orderDetailList.get(0);
    }

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
    @Override
    public Integer addOrderDetail(OrderDetail orderDetail) throws SQLException {
        return this.sqlSessionTemplate.insert(getMybaitsNameSpace() + "addOrderDetail", orderDetail);
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
    public Integer updateOrderDetailById(Long id, OrderDetail orderDetail) throws SQLException {
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        map1.put("orderDetail", orderDetail);
        map2.put("id", id);
        return this.sqlSessionTemplate.update(getMybaitsNameSpace() + "updateOrderDetailById", map);
    }

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
    @Override
    public List<OrderDetail> findOrderDetailIdByOrderNum(String orderNum) throws SQLException {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findOrderDetailIdByOrderNum", orderNum);
    }

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
    @Override
    public List<OrderDetail> getOrderDetailListByOrderId(Long goodsOrderId) throws SQLException {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "getOrderDetailListByOrderId", goodsOrderId);
    }

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
    @Override
    public List<OrderDetail> findOrderDetailByPeopleId(Long peopleId) throws SQLException {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findOrderDetailByPeopleId", peopleId);
    }
}



//@Repository("orderDetailDao")
//public class OrderDetailDaoImpl implements OrderDetailDao {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    /**
//     * @Title: findOrderDetailById
//     * @Description: 通过指定Id查找相应订单详情
//     * @author yuweiyang
//     * @date 2018-01-21
//     * @throws: SQLException
//     * @param: id 指定id
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement对象
//     * @return: 订单详情对象
//     */
//    @Override
//    public OrderDetail findOrderDetailById(Long id, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        //定义员对象
//        OrderDetail orderDetail = new OrderDetail();
//        //定义结果集合
//        ResultSet resultSet = null;
//        //查询sql语句
//        String findSql = "SELECT ID,ORDER_NUM,PEOPLE_ID,STORE_ID,GOODS_ID,GOODS_ORDER_ID,NUMBER,GOODS_PRICE,GOODS_AMOUNT,ADD_TIME,SUCCESS_TIME,DELIVERY_TIME,ORDER_STATUS,IS_INVALID FROM ORDER_DETAIL WHERE ID=?;";
//        //获取查询数据库的 Statement对象
//        preparedStatement = connection.prepareStatement(findSql);
//        //设置 id的值
//        preparedStatement.setLong(1, id);
//        //获取结果集合
//        resultSet = preparedStatement.executeQuery();
//        //获取人员对象信息
//        while (resultSet.next()) {
//            orderDetail.setId(resultSet.getLong(1));
//            orderDetail.setOrderNum(resultSet.getString(2));
//            orderDetail.setPeopleId(resultSet.getLong(3));
//            orderDetail.setStoreId(resultSet.getLong(4));
//            orderDetail.setGoodsId(resultSet.getLong(5));
//            orderDetail.setGoodsOrderId(resultSet.getLong(6));
//            orderDetail.setNumber(resultSet.getDouble(7));
//            orderDetail.setGoodsPrice(resultSet.getDouble(8));
//            orderDetail.setGoodsAmount(resultSet.getDouble(9));
//            orderDetail.setAddTime(resultSet.getDate(10));
//            orderDetail.setSuccessTime(resultSet.getDate(11));
//            orderDetail.setDeliveryTime(resultSet.getDate(12));
//            orderDetail.setOrderStatus(resultSet.getByte(13));
//            orderDetail.setIsInvalid(resultSet.getBoolean(14));
//        }
////        connection.commit();
//        //关闭预编译Statement对象
//        preparedStatement.close();
//        //返回人员对象
//        return orderDetail;
//    }
//
//    /**
//     * @Title: addOrderDetail
//     * @Description: 新增订单详情信息
//     * @author yuweiyang
//     * @date 2018-01-21
//     * @throw SQLException
//     * @param: people 人员信息
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer addOrderDetail(OrderDetail orderDetail, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        Integer number = 0;
//        String addSqlAll = "INSERT INTO ORDER_DETAIL(ID,ORDER_NUM,PEOPLE_ID,STORE_ID,GOODS_ID,GOODS_ORDER_ID,NUMBER,GOODS_PRICE,GOODS_AMOUNT,ADD_TIME,ORDER_STATUS,IS_INVALID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
//        String addSqlDefault = "INSERT INTO ORDER_DETAIL(ID,ORDER_NUM,PEOPLE_ID,STORE_ID,GOODS_ID,GOODS_ORDER_ID,NUMBER,GOODS_PRICE,GOODS_AMOUNT,ADD_TIME,ORDER_STATUS,IS_INVALID) VALUES(DEFAULT,?,?,?,?,?,?,?,?,?,?,?);";
//        if (orderDetail.getId() == null) {
//            preparedStatement = connection.prepareStatement(addSqlDefault);
//            preparedStatement.setString(1, orderDetail.getOrderNum());
//            preparedStatement.setLong(2, orderDetail.getPeopleId());
//            preparedStatement.setLong(3, orderDetail.getStoreId());
//            preparedStatement.setLong(4, orderDetail.getGoodsId());
//            preparedStatement.setLong(5, orderDetail.getGoodsOrderId());
//            preparedStatement.setDouble(6, orderDetail.getNumber());
//            preparedStatement.setDouble(7, orderDetail.getGoodsPrice());
//            preparedStatement.setDouble(8, orderDetail.getGoodsAmount());
//            preparedStatement.setDate(9, new Date(orderDetail.getAddTime().getTime()));
//            preparedStatement.setByte(10, orderDetail.getOrderStatus());
//            preparedStatement.setBoolean(11, orderDetail.getIsInvalid());
//        } else {
//            preparedStatement = connection.prepareStatement(addSqlAll);
//            preparedStatement.setLong(1, orderDetail.getId());
//            preparedStatement.setString(2, orderDetail.getOrderNum());
//            preparedStatement.setLong(3, orderDetail.getPeopleId());
//            preparedStatement.setLong(4, orderDetail.getStoreId());
//            preparedStatement.setLong(5, orderDetail.getGoodsId());
//            preparedStatement.setLong(6, orderDetail.getGoodsOrderId());
//            preparedStatement.setDouble(7, orderDetail.getNumber());
//            preparedStatement.setDouble(8, orderDetail.getGoodsPrice());
//            preparedStatement.setDouble(9, orderDetail.getGoodsAmount());
//            preparedStatement.setDate(10, new Date(orderDetail.getAddTime().getTime()));
//            preparedStatement.setByte(11, orderDetail.getOrderStatus());
//            preparedStatement.setBoolean(12, orderDetail.getIsInvalid());
//        }
//        number = preparedStatement.executeUpdate();
//        connection.commit();
//        preparedStatement.close();
//        return number;
//    }
//
//
//    /**
//     * @Title: updateOrderDetailById
//     * @Description: 更新指定订单详情的信息
//     * @author yuweiyang
//     * @date 2018-01-21
//     * @param: id 指定人员id
//     * @param: orderDetail 指定订单详情
//     * @param: connection 连接对象
//     * @param: prepareStatement 预编译 Statement对象
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer updateOrderDetailById(Long id, OrderDetail orderDetail, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        Integer number = 0;
//        String updateSql = "UPDATE ORDER_DETAIL SET ORDER_NUM=?,PEOPLE_ID=?,STORE_ID=?,GOODS_ID=?,GOODS_ORDER_ID=?,NUMBER=?,GOODS_PRICE=?,GOODS_AMOUNT=?,ADD_TIME=?,SUCCESS_TIME=?,DELIVERY_TIME=?,ORDER_STATUS=?,IS_INVALID=? WHERE ID=?;";
//        String updateSql2 = "UPDATE ORDER_DETAIL SET ORDER_NUM=?,PEOPLE_ID=?,STORE_ID=?,GOODS_ID=?,GOODS_ORDER_ID=?,NUMBER=?,GOODS_PRICE=?,GOODS_AMOUNT=?,ADD_TIME=?,SUCCESS_TIME=?,ORDER_STATUS=?,IS_INVALID=? WHERE ID=?;";
//        String updateSql3 = "UPDATE ORDER_DETAIL SET ORDER_NUM=?,PEOPLE_ID=?,STORE_ID=?,GOODS_ID=?,GOODS_ORDER_ID=?,NUMBER=?,GOODS_PRICE=?,GOODS_AMOUNT=?,ADD_TIME=?,ORDER_STATUS=?,IS_INVALID=? WHERE ID=?;";
//        if (orderDetail.getSuccessTime() != null && orderDetail.getDeliveryTime() != null) {
//            preparedStatement = connection.prepareStatement(updateSql);
//            preparedStatement.setString(1, orderDetail.getOrderNum());
//            preparedStatement.setLong(2, orderDetail.getPeopleId());
//            preparedStatement.setLong(3, orderDetail.getStoreId());
//            preparedStatement.setLong(4, orderDetail.getGoodsId());
//            preparedStatement.setLong(5, orderDetail.getGoodsOrderId());
//            preparedStatement.setDouble(6, orderDetail.getNumber());
//            preparedStatement.setDouble(7, orderDetail.getGoodsPrice());
//            preparedStatement.setDouble(8, orderDetail.getGoodsAmount());
//            preparedStatement.setDate(9, new Date(orderDetail.getAddTime().getTime()));
//            preparedStatement.setDate(10, new Date(orderDetail.getSuccessTime().getTime()));
//            preparedStatement.setDate(11, new Date(orderDetail.getDeliveryTime().getTime()));
//            preparedStatement.setByte(12, orderDetail.getOrderStatus());
//            preparedStatement.setBoolean(13, orderDetail.getIsInvalid());
//            preparedStatement.setLong(14, id);
//        } else if (orderDetail.getSuccessTime() != null && orderDetail.getDeliveryTime() == null) {
//            preparedStatement = connection.prepareStatement(updateSql2);
//            preparedStatement.setString(1, orderDetail.getOrderNum());
//            preparedStatement.setLong(2, orderDetail.getPeopleId());
//            preparedStatement.setLong(3, orderDetail.getStoreId());
//            preparedStatement.setLong(4, orderDetail.getGoodsId());
//            preparedStatement.setLong(5, orderDetail.getGoodsOrderId());
//            preparedStatement.setDouble(6, orderDetail.getNumber());
//            preparedStatement.setDouble(7, orderDetail.getGoodsPrice());
//            preparedStatement.setDouble(8, orderDetail.getGoodsAmount());
//            preparedStatement.setDate(9, new Date(orderDetail.getAddTime().getTime()));
//            preparedStatement.setDate(10, new Date(orderDetail.getSuccessTime().getTime()));
//            preparedStatement.setByte(11, orderDetail.getOrderStatus());
//            preparedStatement.setBoolean(12, orderDetail.getIsInvalid());
//            preparedStatement.setLong(13, id);
//        } else {
//            preparedStatement = connection.prepareStatement(updateSql3);
//            preparedStatement.setString(1, orderDetail.getOrderNum());
//            preparedStatement.setLong(2, orderDetail.getPeopleId());
//            preparedStatement.setLong(3, orderDetail.getStoreId());
//            preparedStatement.setLong(4, orderDetail.getGoodsId());
//            preparedStatement.setLong(5, orderDetail.getGoodsOrderId());
//            preparedStatement.setDouble(6, orderDetail.getNumber());
//            preparedStatement.setDouble(7, orderDetail.getGoodsPrice());
//            preparedStatement.setDouble(8, orderDetail.getGoodsAmount());
//            preparedStatement.setDate(9, new Date(orderDetail.getAddTime().getTime()));
//            preparedStatement.setByte(10, orderDetail.getOrderStatus());
//            preparedStatement.setBoolean(11, orderDetail.getIsInvalid());
//            preparedStatement.setLong(12, id);
//        }
//        number = preparedStatement.executeUpdate();
//        connection.commit();
//        preparedStatement.close();
//        return number;
//    }
//
//
//    /**
//     * @Title: findOrderDetailById
//     * @Description: 通过指定订单编号查找相应订单详情ID
//     * @author yuweiyang
//     * @date 2018-01-21
//     * @throws: SQLException
//     * @param: id 指定id
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement对象
//     * @return: 订单详情ID
//     */
//
//    @Override
//    public Long findOrderDetailIdByOrderNum(String orderNum, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        //定义return接收变量
//        Long orderDetailId = null;
//        //定义员对象
//        OrderDetail orderDetail = new OrderDetail();
//        //定义结果集合
//        ResultSet resultSet = null;
//        //查询sql语句
//        String findSql = "SELECT ID FROM ORDER_DETAIL WHERE ORDER_NUM=?;";
//        //获取查询数据库的 Statement对象
//        preparedStatement = connection.prepareStatement(findSql);
//        //设置 id的值
//        preparedStatement.setString(1, orderNum);
//        //获取结果集合
//        resultSet = preparedStatement.executeQuery();
//        //获取人员对象
//
//        orderDetailId = resultSet.getLong(1);
//
////        connection.commit();
//        //关闭预编译Statement对象
//        preparedStatement.close();
//        //返回人员对象
//        return orderDetailId;
//    }
//
//    /**
//     * @Title: getGoodsDetailListByOrderId
//     * @Description: 获取指定订单id 的订单详情
//     * @author yanyong
//     * @date 2018-01-28
//     * @param: orderId 指定订单id
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement对象
//     * @return: 订单详情集合
//     */
//    @Override
//    public List<OrderDetail> getOrderDetailListByOrderId(Long orderId, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        //定义订单详情集合对象
//        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
//        //定义结果集合
//        ResultSet resultSet = null;
//        //查询sql语句
//        String findSql = "SELECT ID,ORDER_NUM,PEOPLE_ID,STORE_ID,GOODS_ID,GOODS_ORDER_ID,NUMBER,GOODS_PRICE,GOODS_AMOUNT,ADD_TIME,SUCCESS_TIME,DELIVERY_TIME,ORDER_STATUS,IS_INVALID FROM ORDER_DETAIL WHERE GOODS_ORDER_ID=?;";
//        //获取查询数据库的 Statement对象
//        preparedStatement = connection.prepareStatement(findSql);
//        //设置 id的值
//        preparedStatement.setLong(1, orderId);
//        //获取结果集合
//        resultSet = preparedStatement.executeQuery();
//        //获取人员对象信息
//        while (resultSet.next()) {
//            OrderDetail orderDetail = new OrderDetail();
//            orderDetail.setId(resultSet.getLong(1));
//            orderDetail.setOrderNum(resultSet.getString(2));
//            orderDetail.setPeopleId(resultSet.getLong(3));
//            orderDetail.setStoreId(resultSet.getLong(4));
//            orderDetail.setGoodsId(resultSet.getLong(5));
//            orderDetail.setGoodsOrderId(resultSet.getLong(6));
//            orderDetail.setNumber(resultSet.getDouble(7));
//            orderDetail.setGoodsPrice(resultSet.getDouble(8));
//            orderDetail.setGoodsAmount(resultSet.getDouble(9));
//            orderDetail.setAddTime(resultSet.getDate(10));
//            orderDetail.setSuccessTime(resultSet.getDate(11));
//            orderDetail.setDeliveryTime(resultSet.getDate(12));
//            orderDetail.setOrderStatus(resultSet.getByte(13));
//            orderDetail.setIsInvalid(resultSet.getBoolean(14));
//            orderDetailList.add(orderDetail);
//        }
////        connection.commit();
//        //关闭预编译Statement对象
//        preparedStatement.close();
//        //返回人员对象
//        return orderDetailList;
//    }
//
//
//    /**
//     * @Title: findOrderDetailByPeopleId
//     * @Description: 通过人员id查找订单详情
//     * @author yanyong
//     * @date 2018-01-31
//     * @param: peopleId 指定人员id
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement对象
//     * @return: 订单详情集合
//     * @throws: SQLException
//     */
//    public List<OrderDetail> findOrderDetailByPeopleId(Long peopleId,Connection connection, PreparedStatement preparedStatement) throws SQLException{
//        //定义订单详情集合对象
//        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
//        //定义结果集合
//        ResultSet resultSet = null;
//        //查询sql语句
//        String findSql = "SELECT ID,ORDER_NUM,PEOPLE_ID,STORE_ID,GOODS_ID,GOODS_ORDER_ID,NUMBER,GOODS_PRICE,GOODS_AMOUNT,ADD_TIME,SUCCESS_TIME,DELIVERY_TIME,ORDER_STATUS,IS_INVALID FROM ORDER_DETAIL WHERE PEOPLE_ID=?;";
//        //获取查询数据库的 Statement对象
//        preparedStatement = connection.prepareStatement(findSql);
//        //设置 id的值
//        preparedStatement.setLong(1, peopleId);
//        //获取结果集合
//        resultSet = preparedStatement.executeQuery();
//        //获取人员对象信息
//        while (resultSet.next()) {
//            OrderDetail orderDetail = new OrderDetail();
//            orderDetail.setId(resultSet.getLong(1));
//            orderDetail.setOrderNum(resultSet.getString(2));
//            orderDetail.setPeopleId(resultSet.getLong(3));
//            orderDetail.setStoreId(resultSet.getLong(4));
//            orderDetail.setGoodsId(resultSet.getLong(5));
//            orderDetail.setGoodsOrderId(resultSet.getLong(6));
//            orderDetail.setNumber(resultSet.getDouble(7));
//            orderDetail.setGoodsPrice(resultSet.getDouble(8));
//            orderDetail.setGoodsAmount(resultSet.getDouble(9));
//            orderDetail.setAddTime(resultSet.getDate(10));
//            orderDetail.setSuccessTime(resultSet.getDate(11));
//            orderDetail.setDeliveryTime(resultSet.getDate(12));
//            orderDetail.setOrderStatus(resultSet.getByte(13));
//            orderDetail.setIsInvalid(resultSet.getBoolean(14));
//            orderDetailList.add(orderDetail);
//        }
////        connection.commit();
//        //关闭预编译Statement对象
//        preparedStatement.close();
//        //返回人员对象
//        return orderDetailList;
//    }
//}