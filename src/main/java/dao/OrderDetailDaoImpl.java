package dao;/**
 * Created by Roger_yu on 2018/1/20.
 */

import common.util.base.BaseDaoImpl;
import domain.OrderDetail;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
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
    private SqlSessionTemplate sqlSessionTemplate;
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
        List<OrderDetail> orderDetailList=new ArrayList<OrderDetail>();
        orderDetailList=this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findOrderDetailById", id);
        return orderDetailList.get(0);
//        return null;
    }

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
    public Integer saveOrderDetail(OrderDetail orderDetail) throws SQLException {
        return this.sqlSessionTemplate.insert(getMybaitsNameSpace() + "saveOrderDetail", orderDetail);
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
//        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
//        Map map1 = new HashMap();
//        Map map2 = new HashMap();
        Map map=new HashMap();
        map.put("orderDetail", orderDetail);
        map.put("id", id);
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
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "getOrderDetailListByOrderId", orderNum);
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
    public List<OrderDetail> findOrderDetailListByOrderId(Long goodsOrderId) {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findOrderDetailListByOrderId", goodsOrderId);
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
