package servlet;/**
 * Created by Roger_yu on 2018/1/31.
 */

import domain.Goods;
import domain.OrderDetail;
import service.GoodsService;
import service.GoodsServiceImpl;
import service.OrderDetailService;
import service.OrderDetailServiceImpl;

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
 * @ClassName StoreOrderServletSelectGoods
 * @Description 进货页面查询按钮servlet
 * @date 2018/1/31
 */
public class StoreServletSelectGoods extends HttpServlet {
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
        String selectString=request.getParameter("selectGoods");
        //判断输入是否为空
        if(selectString==null||selectString==""){
            selectString="未输入任何数据";
            out.println(selectString);
        }else {
            GoodsService gs=new GoodsServiceImpl();
            Goods goods=gs.findGoodsById(Long.valueOf(selectString));
            session.setAttribute("goods",goods);
            request.getRequestDispatcher("store_set_stock.jsp").forward(request, response);
        }
        out.close();//关闭输出流
    }
}