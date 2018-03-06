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
            return goodsOrderDao.findGoodsOrderById(id);

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
            return goodsOrderDao.addGoodsOrderById(goodsOrder);
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
    public Integer updateGoodsOrder(GoodsOrder goodsOrder) {
            return goodsOrderDao.updateGoodsOrder(goodsOrder);
    }

    /**
     * @Title: showGoodsOrder
     * @Description: 查看订单信息
     * @author yanyong
     * @date 2018-01-26
     * @param: goodsOrder 订单实体
     */
@Override
public void showGoodsOrder(GoodsOrder goodsOrder){

        System.out.print("主键ID：" + goodsOrder.getId() + " ");
        System.out.print("订单编号：" + goodsOrder.getOrderNum() + " ");
        System.out.print("人员外键：" + goodsOrder.getPeopleId() + " ");
        System.out.print("添加添加时间：" + new TimeFormat(goodsOrder.getAddTime()).format() + " ");

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
@Override
    public GoodsOrder findGoodsOrderByNum(String goodsNum) {
            return goodsOrderDao.findGoodsOrderByNum(goodsNum);

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
            return goodsOrderDao.findGoodsOrderByPeopleId(peopleId);

    }
}
