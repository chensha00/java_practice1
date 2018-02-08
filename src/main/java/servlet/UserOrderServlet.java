package servlet;/********************************************************************
 /**
 * @Project: bigstar_online_mall
 * @Package servlet
 * @author yanyong
 * @date 2018/1/30 0030 17:37
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.GoodsOrder;
import domain.OrderDetail;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author yanyong
 * @ClassName UserOrderServlet
 * @Description 类描述
 * @date 2018/1/30 0030
 */
public class UserOrderServlet extends HttpServlet {


    /**
     * @Title: doGet
     * @Description: get请求
     * @author yanyong
     * @date 2018-01-30
     * @throw ServletException, IOException
     * @param: req request对象
     * @param: resp response对象
     */

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        this.doPost(req,resp);
        //req.getRequestDispatcher("../user_order_message.jsp").forward(req,resp);
        //System.out.println(req.getParameter("way")+"11");
    }
    /**
     * @Title: doPost
     * @Description: gpost请求处理
     * @author yanyong
     * @date 2018-01-30
     * @throw ServletException, IOException
     * @param: req request对象
     * @param: resp response对象
     */

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取查询范围
        String way=req.getParameter("way").toString();
        //获取需要查询的人员id
        Long peopleId=Long.valueOf(req.getParameter("peopleId"));
        System.out.println(way+" "+peopleId);
        GoodsOrderService goodsOrderService=new GoodsOrderServiceImpl();
        OrderDetailService orderDetailService=new OrderDetailServiceImpl();
        //获取订单集合
        List<GoodsOrder> goodsOrderList=goodsOrderService.findGoodsOrderByPeopleId(peopleId);
        System.out.println(goodsOrderList.size());
        //获取订单详情集合
        List<OrderDetail> orderDetailList=orderDetailService.findOrderDetailByPeopleId(peopleId);
        System.out.println(orderDetailList.size());
        System.out.println(way.equals("not_payment"));
        System.out.println(way.equals("not_delivery"));
        System.out.println(way.equals("not_delivery"));
        System.out.println("not_payment");
        //判断是否需要未付款的数据，
        if (way.equals("not_payment")){
//            for (int i=0;i<goodsOrderList.size();i++){
//                if (goodsOrderList.get(i).getOrderStatus()!=(byte)1){
//                    goodsOrderList.remove(i);
//                }
//                System.out.println(goodsOrderList.get(i).getOrderStatus());
//            }
//            System.out.println("not_payment");
            System.out.println(orderDetailList.size());
            for (int j=orderDetailList.size()-1;j>=0;j--){
                Byte detailStatus=orderDetailList.get(j).getOrderStatus();
                System.out.println("订单状态："+detailStatus);
                if (detailStatus !=(byte)0 &&detailStatus!=(byte)2){
                    goodsOrderList.remove(orderDetailList.get(j).getGoodsOrder());
                    orderDetailList.remove(j);
                }
                System.out.println(detailStatus);
            }
            //判断是否需要未发货数据
        }else if (way.equals("not_delivery")){
//            for (int i=0;i<goodsOrderList.size();i++){
//                if (goodsOrderList.get(i).getOrderStatus()!=(byte)1){
//                    goodsOrderList.remove(i);
//                }
//            }
            System.out.println(orderDetailList.size());
            for (int j=orderDetailList.size()-1;j>0;j--){
                Byte detailStatus=orderDetailList.get(j).getOrderStatus();
                System.out.println("订单状态："+detailStatus);
                System.out.println(detailStatus);
                if (detailStatus!=1){
                    goodsOrderList.remove(orderDetailList.get(j).getGoodsOrder());
                    orderDetailList.remove(j);
                }
            }
            //判断是否需要未收货数据
        }else if(way.equals("not_receive")){
//            for (int i=0;i<goodsOrderList.size();i++){
//                if (goodsOrderList.get(i).getOrderStatus()!=(byte)1){
//                    goodsOrderList.remove(i);
//                }
//            }
            System.out.println(orderDetailList.size());
            for (int j=orderDetailList.size()-1;j>0;j--){
                Byte detailStatus=orderDetailList.get(j).getOrderStatus();
                System.out.println("订单状态："+detailStatus);
                if ( detailStatus !=(byte)3){
//                    orderDetailList.remove(j);
////                    orderDetailList.re
//                    System.out.println(orderDetailList.remove(j));
                    goodsOrderList.remove(orderDetailList.get(j).getGoodsOrder());
                    orderDetailList.remove(j);
                }
            }
        }

        System.out.println(goodsOrderList.size());
        System.out.println(orderDetailList.size());
        for (int i=0;i<orderDetailList.size();i++){
            orderDetailService.showOrderDetailMessage(orderDetailList.get(i));
        }
        HttpSession session=req.getSession();
        session.removeAttribute("goodsOrderList");
        session.removeAttribute("orderDetailList");
        //获取session
        if (orderDetailList==null|| goodsOrderList==null||(orderDetailList.size()!= 0 && goodsOrderList.size()!=0)){
            //保存订单集合和订单详情集合到session中
            session.setAttribute("goodsOrderList",goodsOrderList);
            session.setAttribute("orderDetailList",orderDetailList);
            resp.sendRedirect("../user_order_message.jsp");
        }else {
            resp.sendRedirect("../user_order_message.jsp");
        }



//        System.out.println(req.getParameter("way")+"22");
    }
}