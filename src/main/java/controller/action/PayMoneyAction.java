package controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package controller.action
 * @author yanyong
 * @date 2018/3/9 0009 11:58
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.base.BaseAction;
import domain.Goods;
import domain.GoodsOrder;
import domain.OrderDetail;
import domain.People;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import service.GoodsOrderService;
import service.OrderDetailService;
import service.PeopleService;
import tools.GoodsException;
import tools.GoodsOrderException;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yanyong
 * @ClassName PayMoneyAction
 * @Description 类描述
 * @date 2018/3/9 0009
 */
@Action(value = "payMoneyAction")
@Results({
        @Result(name = "payMoney",location = "/pay_money_jsp.jsp"),
//        @Result(name = "userOrder",location = "/action/userOrderAction!findOrderAll.do"),
        @Result(name = "payFail",location = "/pay_money_jsp.jsp")
})

public class PayMoneyAction extends BaseAction{

    @Autowired
    private PeopleService peopleService;
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * @Title: PayGoodsOrderShow
     * @Description: 查询支付信息到支付页面显示
     * @author yanyong
     * @date 2018-03-09
     * @return: String
     */
    public String PayGoodsOrderShow(){
        //获取订单编号
        String orderNum=req.getParameter("orderNum");
        GoodsOrder goodsOrder=goodsOrderService.findGoodsOrderByNum(orderNum);
        if (goodsOrder==null){
            //保存订单信息集合到session中
            HttpSession session=req.getSession();
            People person= (People) session.getAttribute("person");
            Long peopleId=person.getId();
            List<GoodsOrder> goodsOrderList=goodsOrderService.findGoodsOrderByPeopleId(peopleId);
            System.out.println(goodsOrderList.size());
            //获取订单详情集合
            List<OrderDetail> orderDetailList=orderDetailService.findOrderDetailByPeopleId(peopleId);
            System.out.println(orderDetailList.size());
            session.removeAttribute("goodsOrderList");
            session.removeAttribute("orderDetailList");

            if (orderDetailList==null|| goodsOrderList==null||(orderDetailList.size()!= 0 && goodsOrderList.size()!=0)){
                //保存订单集合和订单详情集合到session中
                session.setAttribute("goodsOrderList",goodsOrderList);
                session.setAttribute("orderDetailList",orderDetailList);
            }
            return "userOrder";
        }
        //获取订单详情并保存到session中
        List<OrderDetail> orderDetailList= orderDetailService.findOrderDetailListByOrderId(goodsOrder.getId());
        HttpSession session=req.getSession();
        session.removeAttribute("goodsOrderPay");
        session.removeAttribute("orderDetailListPay");
        session.setAttribute("goodsOrderPay", goodsOrder);
        session.setAttribute("orderDetailListPay", orderDetailList);
        return "payMoney";
    }

    /**
     * @Title: PayGoodsOrderMoney
     * @Description: 确认支付订单金额
     * @author yanyong
     * @date 2018-03-09
     * @return:
     */
    public String PayGoodsOrderMoney(){
        //获取人员信息 订单信息
        HttpSession session=req.getSession();
        People person= (People) session.getAttribute("person");
        GoodsOrder goodsOrder= (GoodsOrder) session.getAttribute("goodsOrderPay");
//        if (person!)
        if (person==null||goodsOrder==null){
            return "payFail";
        }
        //支付订单
        Boolean isPaySuccess=false;
        try {
            isPaySuccess=peopleService.payGoodsMoneyByOrderId(person.getId(), goodsOrder.getId());
        } catch (GoodsException e) {
            e.printStackTrace();
        } catch (GoodsOrderException e) {
            e.printStackTrace();
        }
        if (isPaySuccess==true){
            Long peopleId=person.getId();
            List<GoodsOrder> goodsOrderList=goodsOrderService.findGoodsOrderByPeopleId(peopleId);
            System.out.println(goodsOrderList.size());
            //获取订单详情集合
            List<OrderDetail> orderDetailList=orderDetailService.findOrderDetailByPeopleId(peopleId);
            System.out.println(orderDetailList.size());
            session.removeAttribute("goodsOrderList");
            session.removeAttribute("orderDetailList");

            if (orderDetailList==null|| goodsOrderList==null||(orderDetailList.size()!= 0 && goodsOrderList.size()!=0)){
                //保存订单集合和订单详情集合到session中
                session.setAttribute("goodsOrderList",goodsOrderList);
                session.setAttribute("orderDetailList",orderDetailList);
            }
            return "userOrder";
        }else {
            return "payFail";
        }
    }
}