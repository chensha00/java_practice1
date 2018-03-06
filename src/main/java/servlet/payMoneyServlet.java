package servlet;/********************************************************************
 /**
 * @Project: bigstar_online_mall
 * @Package servlet
 * @author yanyong
 * @date 2018/1/31 0031 17:32
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import dao.InvertoryDao;
import domain.GoodsOrder;
import domain.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import service.*;
import tools.GoodsException;
import tools.GoodsOrderException;
import tools.PeopleException;
import tools.StringToArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author yanyong
 * @ClassName payMoneyServlet
 * @Description 类描述
 * @date 2018/1/31 0031
 */
public class payMoneyServlet extends HttpServlet {

    StringToArray stringToArray = new StringToArray();

    @Autowired
    private InvertoryDao invertoryDao;

    @Autowired
    private PeopleService peopleService;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//          http://localhost:8080/pay/pay.htm?peopeoId=1&&orderNum=OD&&isPay=true
//        获取购物车的传值
        String idName = req.getParameter("idName");
        String numberName = req.getParameter("number");
//        把字符串转换为数组
        List<Long> idList = stringToArray.toArrayLong(idName);
        List<Double> number = stringToArray.toArrayDouble(numberName);
        Long peopleId = Long.valueOf(req.getParameter("peopleId"));
//        生成订单
        try {
            peopleService.buyGoods(peopleId, idList, number);
        } catch (PeopleException e) {
            e.printStackTrace();
        } catch (GoodsException e) {
            e.printStackTrace();
        }
        //获取支付人id，支付订单编号，是否支付
        String orderNum = req.getParameter("orderNum");
        Boolean isPay = Boolean.valueOf(req.getParameter("isPay"));
        System.out.println(peopleId + " " + orderNum + " " + isPay);
        //定义订单信息操作对象，订单详情操作对象
        GoodsOrderService goodsOrderService = new GoodsOrderServiceImpl();
        OrderDetailService orderDetailService = new OrderDetailServiceImpl();
        PeopleService peopleService = new PeopleServiceImpl();
        HttpSession session = req.getSession();
        //获取订单信息
        GoodsOrder goodsOrderPay = goodsOrderService.findGoodsOrderByNum(orderNum);
        if (goodsOrderPay == null) {
            System.out.println("该订单不存在");
        }
        if (isPay == true) {
            try {
                peopleService.payGoodsMoneyByOrderId(peopleId, goodsOrderPay.getId());
                goodsOrderPay = goodsOrderService.findGoodsOrderById(goodsOrderPay.getId());
            } catch (GoodsException e) {
                e.printStackTrace();
            } catch (GoodsOrderException e) {
                e.printStackTrace();
            }
        }
        //获取需支付订单的订单详情
        List<OrderDetail> orderDetailListPay = orderDetailService.getOrderDetailListByOrderId(goodsOrderPay.getId());
        goodsOrderService.showGoodsOrder(goodsOrderPay);
        System.out.println(orderDetailListPay.size());
        for (int i = 0; i < orderDetailListPay.size(); i++) {
            orderDetailService.showOrderDetailMessage(orderDetailListPay.get(i));
        }
        session.removeAttribute("goodsOrderPay");
        session.removeAttribute("orderDetailListPay");
        session.setAttribute("goodsOrderPay", goodsOrderPay);
        session.setAttribute("orderDetailListPay", orderDetailListPay);
        resp.sendRedirect("../pay_money_jsp.jsp");
    }
}