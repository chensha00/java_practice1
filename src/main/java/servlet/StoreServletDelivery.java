package servlet;/**
 * Created by Roger_yu on 2018/2/1.
 */

import common.util.SpringContextUtil;
import domain.Goods;
import domain.OrderDetail;
import domain.Store;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuweiyang
 * @ClassName StoreServletDelivery
 * @Description 订单详情发货按钮实现servlet
 * @date 2018/2/1
 */
public class StoreServletDelivery extends HttpServlet {
    public void init() throws ServletException {

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    //实现doPost方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义session对象
        HttpSession session = request.getSession();
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        //得到输出字符输出流
        PrintWriter out = response.getWriter();
        //获取输入内容
        String orderDId=request.getParameter("odId");
        Long id=Long.parseLong(orderDId);//获取orderDetailId

        StoreService storeService= (StoreService) SpringContextUtil.getBean("storeService");
        storeService.delivery(id);
        out.println("您已经成功发货");


        out.close();//关闭输出流
    }
}