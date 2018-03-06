package servlet;/**
 * Created by Roger_yu on 2018/1/30.
 */

import common.util.SpringContextUtil;
import domain.OrderDetail;
import service.OrderDetailService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author yuweiyang
 * @ClassName StoreOrderServlet
 * @Description 根据ID查找订单详情的servlet
 * @date 2018/1/30
 */
public class StoreOrderServletSelect extends HttpServlet{

    public void init() throws ServletException {

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义session对象
        HttpSession session = request.getSession();
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        //得到输出字符输出流
        PrintWriter out = response.getWriter();
        //获取输入内容
        String selectString=request.getParameter("select");
        //判断输入是否为空
        if(selectString==null||selectString==""){
            selectString="未输入任何数据";
            out.println(selectString);
        }else {
            OrderDetailService orderDetailService = (OrderDetailService) SpringContextUtil.getBean("orderDetailService");
            List<OrderDetail> orderDetail=orderDetailService.findOrderDetailListByOrderId(Long.valueOf(selectString));
            session.setAttribute("orderDetail",orderDetail);
            request.getRequestDispatcher("store_order.jsp").forward(request, response);
        }
        out.close();//关闭输出流
    }
}