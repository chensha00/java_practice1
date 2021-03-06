package servlet;/********************************************************************
 /**
 * @Project: bigstar_online_mall
 * @Package servlet
 * @author yanyong
 * @date 2018/1/31 0031 17:32
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.SpringContextUtil;
import dao.InventoryDao;
import domain.GoodsOrder;
import domain.OrderDetail;
import service.GoodsOrderService;
import service.OrderDetailService;
import service.PeopleService;
import tools.GoodsException;
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

    PeopleService peopleService = (PeopleService) SpringContextUtil.getBean("peopleService");
    GoodsOrderService goodsOrderService = (GoodsOrderService) SpringContextUtil.getBean("goodsOrderService");
    OrderDetailService orderDetailService = (OrderDetailService) SpringContextUtil.getBean("orderDetailService");
    InventoryDao inventoryDao = (InventoryDao) SpringContextUtil.getBean("inventoryDao");


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
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
        String peopleStr = req.getParameter("peopleId");
        if (peopleStr == null) {
            HttpSession session = req.getSession();
            session.setAttribute("LoginMessage", "error");
            resp.sendRedirect("../cart.jsp");
        } else {
//        获取购物车的传值
            Long peopleId = Long.valueOf(peopleStr);
            String idName = req.getParameter("idName");
            String numberName = req.getParameter("number");
//        把字符串转换为数组
            List<Long> idList = stringToArray.toArrayLong(idName);
            List<Double> number = stringToArray.toArrayDouble(numberName);

//        生成订单
            GoodsOrder goodsOrder = null;
            try {
                goodsOrder = peopleService.buyGoods(peopleId, idList, number);
            } catch (PeopleException e) {
                e.printStackTrace();
            } catch (GoodsException e) {
                e.printStackTrace();
            }
            //定义订单信息操作对象，订单详情操作对象
            HttpSession session = req.getSession();
            //获取需支付订单的订单详情
            List<OrderDetail> orderDetailListPay = orderDetailService.findOrderDetailListByOrderId(goodsOrder.getId());
            goodsOrderService.showGoodsOrder(goodsOrder);
            System.out.println(orderDetailListPay.size());
            for (int i = 0; i < orderDetailListPay.size(); i++) {
                orderDetailService.showOrderDetailMessage(orderDetailListPay.get(i));
            }
            session.removeAttribute("goodsOrderPay");
            session.removeAttribute("orderDetailListPay");
            session.setAttribute("goodsOrderPay", goodsOrder);
            session.setAttribute("orderDetailListPay", orderDetailListPay);
            resp.sendRedirect("../pay_money_jsp.jsp");
        }
    }
}