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

import common.util.base.BaseDaoImpl;
import domain.GoodsOrder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zuorui
 * @ClassName GoodsOrderImpl
 * @Description 类描述
 * @date 2018/02/26
 */
@Repository("goodsOrderDao")
public class GoodsOrderDaoImpl extends BaseDaoImpl<GoodsOrder> implements GoodsOrderDao {

    /**
     * @throws java.sql.SQLException
     * @Title: findGoodsOrderById
     * @Description: 通过id查询订单详情
     * @author zuorui
     * @date 2018-02-26
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     */
    @Override
    public GoodsOrder findGoodsOrderById(Long id, Connection connection, PreparedStatement preparedStatement) throws SQLException {
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"findGoodsOrderById",id);
    }
    /**
     * @throws java.sql.SQLException
     * @Title: addGoodsOrderById
     * @Description: 通过id添加订单详情
     * @author zuorui
     * @date 2018-02-26
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     */
    @Override
    public Integer addGoodsOrderById(GoodsOrder goodsOrder, Connection connection, PreparedStatement preparedStatement) throws SQLException {
        return this.sqlSessionTemplate.insert(getMybaitsNameSpace()+"addGoodsOrderById",goodsOrder);
    }
    /**
     * @throws java.sql.SQLException
     * @Title: updateGoodsOrderById
     * @Description: 通过id修改订单详情
     * @author zuorui
     * @date 2018-02-26
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     */
    @Override
    public Integer updateGoodsOrderById(Long id, GoodsOrder goodsOrder, Connection connection, PreparedStatement preparedStatement) throws SQLException {
        return this.sqlSessionTemplate.update(getMybaitsNameSpace()+"updateGoodsOrderById",id);
    }
    /**
     * @throws java.sql.SQLException
     * @Title: findGoodsOrderByNum
     * @Description: 通过Num查询订单详情
     * @author zuorui
     * @date 2018-02-26
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     */
    @Override
    public GoodsOrder findGoodsOrderByNum(String goodsNum, Connection connection, PreparedStatement preparedStatement) throws SQLException {
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace() + "findGoodsOrderByNum",goodsNum);
    }
    /**
     * @throws java.sql.SQLException
     * @Title: findGoodsOrderByPeopleId
     * @Description: 通过peopleId查询订单详情
     * @author zuorui
     * @date 2018-02-26
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement对象
     */
    @Override
    public List<GoodsOrder> findGoodsOrderByPeopleId(Long peopleId, Connection connection, PreparedStatement preparedStatement) throws SQLException {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"findGoodsOrderByPeopleId",peopleId);
    }
}
//@Repository("goodsOrderDao")
//public class GoodsOrderDaoImpl implements GoodsOrderDao {
//    /**
//     * @throws java.sql.SQLException
//     * @Title: findGoodsOrderById
//     * @Description: 通过id查询订单详情
//     * @author zuorui
//     * @date 2018-01-22
//     * @param: id 指定id
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement对象
//     */
//    @Override
//    public GoodsOrder findGoodsOrderById(Long id, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        //定义订单对象
//        GoodsOrder goodsOrder = new GoodsOrder();
//        //定义结果集合
//        ResultSet resultSet = null;
//        //sql语句
//        String findSql = "SELECT ID,ORDER_NUM ,PEOPLE_ID ,TOTAL_MONEY ,ADD_TIME ,SUCCESS_TIME ,ORDER_STATUS ,IS_INVALID FROM goods_order WHERE ID=?;";
//        //获取预编译Statement对象
//        preparedStatement = connection.prepareStatement(findSql);
//        preparedStatement.setLong(1, id);
//        //执行查询
//        resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            Long id1 = resultSet.getLong(1);
//            goodsOrder.setId(id1);
//            goodsOrder.setOrderNum(resultSet.getString(2));
//            goodsOrder.setPeopleId(resultSet.getLong(3));
//            goodsOrder.setTotalMoney(resultSet.getDouble(4));
//            goodsOrder.setAddTime(resultSet.getDate(5));
//            goodsOrder.setSuccessTime(resultSet.getDate(6));
//            goodsOrder.setOrderStatus(resultSet.getByte(7));
//            goodsOrder.setIsInvalid(resultSet.getBoolean(8));
//        }
//        preparedStatement.close();
//        resultSet.close();
//        return goodsOrder;
//    }
//
//
//    /**
//     * @Title: addGoodsOrderById
//     * @Description: 添加订单信息
//     * @author zuorui
//     * @date 2018-01-22
//     * @throws: SQLException
//     * @param: id 制定id
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer addGoodsOrderById(GoodsOrder goodsOrder, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        Integer number = 0;
//        String addSql = "INSERT INTO goods_order(ID,ORDER_NUM ,PEOPLE_ID,TOTAL_MONEY,ADD_TIME,SUCCESS_TIME,ORDER_STATUS,IS_INVALID)" +
//                " VALUES(DEFAULT,?,?,?,?,?,?,?);";
//        String addSql2 = "INSERT INTO goods_order(ID,ORDER_NUM ,PEOPLE_ID,TOTAL_MONEY,ADD_TIME,ORDER_STATUS,IS_INVALID)" +
//                " VALUES(DEFAULT,?,?,?,?,?,?);";
//        if (goodsOrder.getSuccessTime() != null) {
//            preparedStatement = connection.prepareStatement(addSql);
//            preparedStatement.setString(1, goodsOrder.getOrderNum());
//            preparedStatement.setLong(2, goodsOrder.getPeopleId());
//            preparedStatement.setDouble(3, goodsOrder.getTotalMoney());
//            preparedStatement.setDate(4, new Date(goodsOrder.getAddTime().getTime()));
//            preparedStatement.setDate(5, new Date(goodsOrder.getSuccessTime().getTime()));
//            preparedStatement.setByte(6, goodsOrder.getOrderStatus());
//            preparedStatement.setBoolean(7, goodsOrder.getIsInvalid());
//        } else {
//            preparedStatement = connection.prepareStatement(addSql2);
//            preparedStatement.setString(1, goodsOrder.getOrderNum());
//            preparedStatement.setLong(2, goodsOrder.getPeopleId());
//            preparedStatement.setDouble(3, goodsOrder.getTotalMoney());
//            preparedStatement.setDate(4, new Date(goodsOrder.getAddTime().getTime()));
//            preparedStatement.setByte(5, goodsOrder.getOrderStatus());
//            preparedStatement.setBoolean(6, goodsOrder.getIsInvalid());
//        }
//        number = preparedStatement.executeUpdate();
//        connection.commit();
//        preparedStatement.close();
//        return number;
//    }
//
//    /**
//     * @Title: updateGoodsOrderById
//     * @Description: 更改订单信息
//     * @author zuorui
//     * @date 2018-01-22
//     * @throws: SQLException
//     * @param: id 制定id
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer updateGoodsOrderById(Long id, GoodsOrder goodsOrder, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        Integer number = 0;
//        String updateSql = "UPDATE goods_order SET ORDER_NUM=? ,PEOPLE_ID=? ,TOTAL_MONEY=? ,ADD_TIME=? ,SUCCESS_TIME=? ,ORDER_STATUS=? ,IS_INVALID=?" + " WHERE ID=?;";
//        preparedStatement = connection.prepareStatement(updateSql);
//        preparedStatement.setString(1, goodsOrder.getOrderNum());
//        preparedStatement.setLong(2, goodsOrder.getPeopleId());
//        preparedStatement.setDouble(3, goodsOrder.getTotalMoney());
//        preparedStatement.setDate(4, new Date(goodsOrder.getAddTime().getTime()));
//        preparedStatement.setDate(5, new Date(goodsOrder.getSuccessTime().getTime()));
//        preparedStatement.setByte(6, goodsOrder.getOrderStatus());
//        preparedStatement.setBoolean(7, goodsOrder.getIsInvalid());
//        preparedStatement.setLong(8, id);
//        number = preparedStatement.executeUpdate();
//        connection.commit();
//        preparedStatement.close();
//        return number;
//    }
//
//    /**
//     * @Title: findGoodsOrderByNum
//     * @Description: 查过订单编号查询订单
//     * @author yanyong
//     * @date 2018-01-26
//     * @param: goodsNum 商品编号
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement对象
//     */
//    @Override
//    public GoodsOrder findGoodsOrderByNum(String goodsNum, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        //定义订单对象
//        GoodsOrder goodsOrder = new GoodsOrder();
//        //定义结果集合
//        ResultSet resultSet = null;
//        //sql语句
//        String findSql = "SELECT ID,ORDER_NUM ,PEOPLE_ID ,TOTAL_MONEY ,ADD_TIME ,SUCCESS_TIME ,ORDER_STATUS ,IS_INVALID FROM goods_order WHERE ORDER_NUM=?;";
//        //获取预编译Statement对象
//        preparedStatement = connection.prepareStatement(findSql);
//        preparedStatement.setString(1, goodsNum);
//        //执行查询
//        resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            Long id1 = resultSet.getLong(1);
//            goodsOrder.setId(id1);
//            goodsOrder.setOrderNum(resultSet.getString(2));
//            goodsOrder.setPeopleId(resultSet.getLong(3));
//            goodsOrder.setTotalMoney(resultSet.getDouble(4));
//            goodsOrder.setAddTime(resultSet.getDate(5));
//            goodsOrder.setSuccessTime(resultSet.getDate(6));
//            goodsOrder.setOrderStatus(resultSet.getByte(7));
//            goodsOrder.setIsInvalid(resultSet.getBoolean(8));
//        }
//        preparedStatement.close();
//        resultSet.close();
//        return goodsOrder;
//    }
//    /**
//     * @Title: findGoodsOrderByPeopleId
//     * @Description: 获取订单信息通过人员id
//     * @author yanyong
//     * @date 2018-01-31
//     * @param: peopleId指定人员id
//     * @param: goodsNum 商品编号
//     * @param: connection 连接对象
//     * @return: 订单信息集合
//     * @throws: SQLException
//     */
//    @Override
//    public List<GoodsOrder> findGoodsOrderByPeopleId(Long peopleId, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        return null;
//    }
//    public List<GoodsOrder> findGoodsOrderByPeopleId(Long peopleId, Connection connection, PreparedStatement preparedStatement) throws SQLException{
//        //定义订单对象集合
//        List<GoodsOrder> goodsOrderList = new ArrayList<GoodsOrder>();
//        //定义结果集合
//        ResultSet resultSet = null;
//        //sql语句
//        String findSql = "SELECT ID,ORDER_NUM ,PEOPLE_ID ,TOTAL_MONEY ,ADD_TIME ,SUCCESS_TIME ,ORDER_STATUS ,IS_INVALID FROM goods_order WHERE PEOPLE_ID=?;";
//        //获取预编译Statement对象
//        preparedStatement = connection.prepareStatement(findSql);
//        preparedStatement.setLong(1, peopleId);
//        //执行查询
//        resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            Long id1 = resultSet.getLong(1);
//            GoodsOrder goodsOrder=new GoodsOrder();
//            goodsOrder.setId(id1);
//            goodsOrder.setOrderNum(resultSet.getString(2));
//            goodsOrder.setPeopleId(resultSet.getLong(3));
//            goodsOrder.setTotalMoney(resultSet.getDouble(4));
//            goodsOrder.setAddTime(resultSet.getDate(5));
//            goodsOrder.setSuccessTime(resultSet.getDate(6));
//            goodsOrder.setOrderStatus(resultSet.getByte(7));
//            goodsOrder.setIsInvalid(resultSet.getBoolean(8));
//            goodsOrderList.add(goodsOrder);
//        }
//        preparedStatement.close();
//        resultSet.close();
//        return goodsOrderList;
//    }
//}