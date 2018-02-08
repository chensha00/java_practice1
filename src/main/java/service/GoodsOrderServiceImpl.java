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

import common.util.DataSourceUtils;
import common.util.JdbcUtils;
import dao.GoodsOrderDao;
import domain.GoodsOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.TimeFormat;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zuorui
 * @ClassName GoodsOrderServiceImpl
 * @Description 类描述
 * @date 2018/1/20
 */
@Service("goodsOrderService")
@Transactional
public class GoodsOrderServiceImpl implements GoodsOrderService {
//    public static GoodsOrderDao goodsOrderDao = new GoodsOrderDaoImpl();
@Autowired
private  GoodsOrderDao goodsOrderDao;
    
    /**
     * @Title: findGoodsOrderById
     * @Description: 方法描述
     * @author zuorui
     * @date 2018-01-22
     * @param: id 指定id
     */
    @Override
    public GoodsOrder findGoodsOrderById(Long id) {

        //定义商品订单对象
        GoodsOrder goodsOrder = null;
        //定义连接对象
        Connection connection = null;
        //定义预编译Statement对象
        PreparedStatement preparedStatement = null;
        // 1.创建自定义连接池对象
        DataSource dataSource = new DataSourceUtils();
        try {
            //获取连接对象
            connection = dataSource.getConnection();
            //关闭连接 自动提交
            connection.setAutoCommit(false);
            goodsOrder = goodsOrderDao.findGoodsOrderById(id, connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放连接资源
            JdbcUtils.release(connection, preparedStatement, null);
            //返回商品订单对象
            if (goodsOrder != null) {
                goodsOrder.setPeople(new PeopleServiceImpl().findPeopleById(goodsOrder.getPeopleId()));
            }
            return goodsOrder;
        }
    }

    /**
     * @return 受影响的行
     * @Title addGoodsOrderById
     * @Description 根据ID增加订单信息
     * @author zuorui
     * @date 2018-01-22
     * @param: id 指定id
     * @param: connection 连接对象
     */
    @Override
    public Integer addGoodsOrderById(GoodsOrder goodsOrder) {
        //定义受影响行数
        Integer number = 0;
        //定义连接对象
        Connection connection = null;
        //定义预编译Statement对象
        PreparedStatement preparedStatement = null;
        // 1.创建自定义连接池对象
        DataSource dataSource = new DataSourceUtils();
        try {
            //获取连接对象
            connection = dataSource.getConnection();
            //关闭连接 自动提交
            connection.setAutoCommit(false);
            number = goodsOrderDao.addGoodsOrderById(goodsOrder, connection, preparedStatement);
            System.out.println(number);
        } catch (SQLException e) {
            //回滚
            connection.rollback();
            e.printStackTrace();
        } finally {
            //释放连接资源
            JdbcUtils.release(connection, preparedStatement, null);
            //返回受影响行数
            return number;
        }
    }

    /**
     * @return 受影响的行
     * @Title 修改订单信息
     * @Description
     * @author zuorui
     * @date 2018-01-22
     * @param: id 指定id
     * @param: goodsOrder 订单信息
     */
    @Override
    public Integer updateGoodsOrderById(Long id, GoodsOrder goodsOrder) {
        //定义受影响行数
        Integer number = 0;
        //定义连接对象
        Connection connection = null;
        //定义预编译Statement对象
        PreparedStatement preparedStatement = null;
        GoodsOrder oldOrder = this.findGoodsOrderById(id);
        if (goodsOrder.getSuccessTime() != null) {
            oldOrder.setSuccessTime(goodsOrder.getSuccessTime());
        }
        if (goodsOrder.getOrderStatus() != null) {
            oldOrder.setOrderStatus(goodsOrder.getOrderStatus());
        }
        if (goodsOrder.getIsInvalid() != null) {
            oldOrder.setIsInvalid(goodsOrder.getIsInvalid());
        }
        // 1.创建自定义连接池对象
        DataSource dataSource = new DataSourceUtils();
        try {
            //获取连接对象
            connection = dataSource.getConnection();
            //关闭连接 自动提交
            connection.setAutoCommit(false);
            number = goodsOrderDao.updateGoodsOrderById(id, oldOrder, connection, preparedStatement);
        } catch (SQLException e) {
            //回滚
            connection.rollback();
            e.printStackTrace();
        } finally {
            //释放连接资源
            JdbcUtils.release(connection, preparedStatement, null);
            //返回受影响行数
            return number;
        }
    }

    /**
     * @Title: showGoodsOrder
     * @Description: 查看订单信息
     * @author yanyong
     * @date 2018-01-26
     * @param: goodsOrder 订单实体
     */

    public void showGoodsOrder(GoodsOrder goodsOrder) {
        System.out.print("主键ID：" + goodsOrder.getId() + " ");
        System.out.print("订单编号：" + goodsOrder.getOrderNum() + " ");
        System.out.print("人员外键：" + goodsOrder.getPeopleId() + " ");
        System.out.print("添加添加时间：" + new TimeFormat(goodsOrder.getAddTime()).format() + " ");
        ;
        System.out.print("交易成功时间：" + goodsOrder.getSuccessTime() + " ");
        System.out.print("总金额：" + goodsOrder.getTotalMoney() + " ");
        System.out.print("订单状态：" + goodsOrder.getOrderStatus() + " ");
        System.out.print("是否作废：" + goodsOrder.getIsInvalid() + " ");
        System.out.println();

    }

    /**
     * @Title: findGoodsOrderByNum
     * @Description: 查过订单编号查询订单
     * @author yanyong
     * @date 2018-01-26
     * @param: goodsNum 商品编号
     * @return:
     */

    public GoodsOrder findGoodsOrderByNum(String goodsNum) {
        //定义商品订单对象
        GoodsOrder goodsOrder = null;
        //定义连接对象
        Connection connection = null;
        //定义预编译Statement对象
        PreparedStatement preparedStatement = null;
        // 1.创建自定义连接池对象
        DataSource dataSource = new DataSourceUtils();
        try {
            //获取连接对象
            connection = dataSource.getConnection();
            //关闭连接 自动提交
            connection.setAutoCommit(false);
            goodsOrder = goodsOrderDao.findGoodsOrderByNum(goodsNum, connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放连接资源
            JdbcUtils.release(connection, preparedStatement, null);
            //返回商品订单对象
            if (goodsOrder != null) {
                goodsOrder.setPeople(new PeopleServiceImpl().findPeopleById(goodsOrder.getPeopleId()));
            }
            return goodsOrder;
        }
    }

    /**
     * @Title: findGoodsOrderByPeopleId
     * @Description: 获取订单信息通过人员id
     * @author yanyong
     * @date 2018-01-31
     * @param: peopleId指定人员id
     * @return: 订单信息集合
     */
    public List<GoodsOrder> findGoodsOrderByPeopleId(Long peopleId){
        //定义订单对象集合
        List<GoodsOrder> goodsOrderList = new ArrayList<GoodsOrder>();
        //定义连接对象
        Connection connection = null;
        //定义预编译Statement对象
        PreparedStatement preparedStatement = null;
        // 1.创建自定义连接池对象
        DataSource dataSource = new DataSourceUtils();
        try {
            //获取连接对象
            connection = dataSource.getConnection();
            //关闭连接 自动提交
            connection.setAutoCommit(false);
            goodsOrderList = goodsOrderDao.findGoodsOrderByPeopleId(peopleId, connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放连接资源
            JdbcUtils.release(connection, preparedStatement, null);
            //返回商品订单对象
            if (goodsOrderList != null) {
                for (int i=0;i<goodsOrderList.size();i++){
                    goodsOrderList.get(i).setPeople(new PeopleServiceImpl().findPeopleById(goodsOrderList.get(i).getPeopleId()));
                }
//                goodsOrder.setPeople(new PeopleServiceImpl().findPeopleById(goodsOrder.getPeopleId()));
            }
            return goodsOrderList;
        }
    }
}
