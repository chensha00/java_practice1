package controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package controller.action
 * @author yanyong
 * @date 2018/3/8 0008 9:52
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.base.BaseAction;
import domain.GoodsOrder;
import domain.OrderDetail;
import domain.People;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import service.GoodsOrderService;
import service.OrderDetailService;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author yanyong
 * @ClassName UserOrderAction
 * @Description 类描述
 * @date 2018/3/8 0008
 */
@Action(value = "userOrderAction")
@Results({
        @Result(name = "success",location = "/user_order_message.jsp")
})
@AllowedMethods({"findOrderAll","findNotPayOrder","findNotDeliveryOrder","findNotReceiveOrder"})
public class UserOrderAction extends BaseAction {

    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private OrderDetailService orderDetailService;

    private List<GoodsOrder> goodsOrderList;

    private List<OrderDetail> orderDetailList;

    private HttpSession session;

    private void initData(){
        //设置编码方式
        try {
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //获取订单信息和订单详情

//        People person=req.getParameter("person");
        session=req.getSession();
        People person= (People) session.getAttribute("person");
//        String strId=req.getParameter("peopleId");
        Long peopleId=person.getId();
        goodsOrderList=goodsOrderService.findGoodsOrderByPeopleId(peopleId);
        System.out.println(goodsOrderList.size());
        //获取订单详情集合
        orderDetailList=orderDetailService.findOrderDetailByOrderList(goodsOrderList);
        System.out.println(orderDetailList.size());
    }

    /**
     * @Title: findOrderAll
     * @Description: 查看所有订单信息
     * @author yanyong
     * @date 2018-03-08
     * @return: String
     */
    public String findOrderAll(){

        this.initData();

//        //查看订单详情
//        for (int i=0;i<orderDetailList.size();i++){
//            orderDetailService.showOrderDetailMessage(orderDetailList.get(i));
//        }
        //修改session中的订单信息和订单详情

        session.removeAttribute("goodsOrderList");
        session.removeAttribute("orderDetailList");

        if (orderDetailList==null|| goodsOrderList==null||(orderDetailList.size()!= 0 && goodsOrderList.size()!=0)){
            //保存订单集合和订单详情集合到session中
            session.setAttribute("goodsOrderList",goodsOrderList);
            session.setAttribute("orderDetailList",orderDetailList);
        }
        return SUCCESS;
    }

    /**
     * @Title: findNotPayOrder
     * @Description: 查询未支付的订单信息
     * @author yanyong
     * @date 2018-03-08
     * @return: SUCCESS
     */

    public String findNotPayOrder(){
       this.initData();
        //删除已支付的订单
        for(int i=goodsOrderList.size()-1;i>=0;i--){
            Byte orderStatus=goodsOrderList.get(i).getOrderStatus();
            Long orderId=goodsOrderList.get(i).getId();
            if (orderStatus==1){
                goodsOrderList.remove(i);
                for (int j=orderDetailList.size()-1;j>=0;j--){
                    Long detailOrderId=orderDetailList.get(j).getGoodsOrderId();
                    if (orderId==detailOrderId){
                        orderDetailList.remove(j);
                    }
                }
            }
        }
        //替换session数据
        session.removeAttribute("goodsOrderList");
        session.removeAttribute("orderDetailList");

        if (orderDetailList==null|| goodsOrderList==null||(orderDetailList.size()!= 0 && goodsOrderList.size()!=0)){
            //保存订单集合和订单详情集合到session中
            session.setAttribute("goodsOrderList",goodsOrderList);
            session.setAttribute("orderDetailList",orderDetailList);
        }
        return SUCCESS;
    }

    /**
     * @Title: findNotDeliveryOrder
     * @Description: 查询未发货的订单信心
     * @author yanyong
     * @date 2018-03-08
     * @return: SUCCESS
     */
    public String findNotDeliveryOrder(){
        this.initData();
        //删除已发货订单详情
        for(int i=goodsOrderList.size()-1;i>=0;i--){
            Byte orderStatus=goodsOrderList.get(i).getOrderStatus();
            Long orderId=goodsOrderList.get(i).getId();
            if (orderStatus!=1){
                goodsOrderList.remove(i);
                for (int j=orderDetailList.size()-1;j>=0;j--){
                    Long detailOrderId=orderDetailList.get(j).getGoodsOrderId();
                    Byte detailOrderStatus=orderDetailList.get(j).getOrderStatus();
                    if (orderId==detailOrderId || detailOrderStatus!=1){
                        orderDetailList.remove(j);
                    }
                }
            }
        }
        session.removeAttribute("goodsOrderList");
        session.removeAttribute("orderDetailList");

        if (orderDetailList==null|| goodsOrderList==null||(orderDetailList.size()!= 0 && goodsOrderList.size()!=0)){
            //保存订单集合和订单详情集合到session中
            session.setAttribute("goodsOrderList",goodsOrderList);
            session.setAttribute("orderDetailList",orderDetailList);
        }

        return SUCCESS;
    }

    /**
     * @Title: findNotReceiveOrder
     * @Description: 查看未收货订单信息
     * @author yanyong
     * @date 2018-03-08
     * @return: SUCCESS
     */

    public String findNotReceiveOrder(){

       this.initData();
        //删除未收货订单详情
        for(int i=goodsOrderList.size()-1;i>=0;i--){
            Byte orderStatus=goodsOrderList.get(i).getOrderStatus();
            Long orderId=goodsOrderList.get(i).getId();
            if (orderStatus!=1){
                goodsOrderList.remove(i);
                for (int j=orderDetailList.size()-1;j>=0;j--){
                    Long detailOrderId=orderDetailList.get(j).getGoodsOrderId();
                    Byte detailOrderStatus=orderDetailList.get(j).getOrderStatus();
                    if (orderId==detailOrderId || detailOrderStatus!=3){
                        orderDetailList.remove(j);
                    }
                }
            }
        }
        session.removeAttribute("goodsOrderList");
        session.removeAttribute("orderDetailList");

        if (orderDetailList==null|| goodsOrderList==null||(orderDetailList.size()!= 0 && goodsOrderList.size()!=0)){
            //保存订单集合和订单详情集合到session中
            session.setAttribute("goodsOrderList",goodsOrderList);
            session.setAttribute("orderDetailList",orderDetailList);
        }

        return SUCCESS;
    }

    /**
     * @Title: deleteOrder
     * @Description: 删除订单
     * @author yanyong
     * @date 2018-03-09
     * @return:
     */

    public String deleteOrder(){

        //获取订单id
        String orderStrId=req.getParameter("orderId");
        Long orderId=Long.valueOf(orderStrId);
        //获取订单信息和订单详细
        GoodsOrder goodsOrder=goodsOrderService.findGoodsOrderById(orderId);
        List<OrderDetail> orderDetailList=orderDetailService.findOrderDetailListByOrderId(orderId);
        //将订单和订单详情设置为作废
        goodsOrder.setIsInvalid(false);
        goodsOrderService.updateGoodsOrder(goodsOrder);
        for (OrderDetail orderDetail:orderDetailList){
            orderDetail.setIsInvalid(false);
            orderDetailService.updateOrderDetailById(orderDetail.getId(),orderDetail);
        }
        return this.findOrderAll();
    }

    /**
     * @Title: cancelOrder
     * @Description: 取消订单
     * @author yanyong
     * @date 2018-03-09
     * @return: SUCCESS
     */
    public String cancelOrder(){
        return this.deleteOrder();
//        //获取订单id
//        String orderStrId=req.getParameter("orderId");
//        Long orderId=Long.valueOf(orderStrId);
//        //获取订单信息和订单详细
//        GoodsOrder goodsOrder=goodsOrderService.findGoodsOrderById(orderId);
//        List<OrderDetail> orderDetailList=orderDetailService.findOrderDetailListByOrderId(orderId);
//        //修改订单详情，将其失效，并写入数据库
//        for (int i=0;i<orderDetailList.size();i++){
//            OrderDetail orderDetail=orderDetailList.get(i);
//            orderDetail.setIsInvalid(false);
//            orderDetailService.updateOrderDetailById(orderDetail.getId(),orderDetail);
//        }
//        //修改订单信息
//        goodsOrder.setIsInvalid(false);
//        goodsOrderService.updateGoodsOrder(goodsOrder);
//
//        return this.findOrderAll();
    }
    /**
     * @Title: recevieGoods
     * @Description: 收货
     * @author yanyong
     * @date 2018-03-09
     * @return: SUCCESS
     */
    public String recevieGoods(){
        //获取指定订单详情信息
        String detailStrId=req.getParameter("detailId");
        Long detailId=Long.valueOf(detailStrId);
        OrderDetail orderDetail=orderDetailService.findOrderDetailById(detailId);
        //将订单详情状态设置为4
        if (orderDetail.getOrderStatus()==3){
            orderDetail.setOrderStatus((byte) 4);
        }
        return this.findOrderAll();
    }

}