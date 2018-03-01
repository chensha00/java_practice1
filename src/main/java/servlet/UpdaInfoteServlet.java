package servlet;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package servlet
 * @author 胡志强
 * @date 2018/3/1 9:09
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.Goods;
import domain.Store;
import service.GoodsService;
import service.GoodsServiceImpl;
import service.StoreService;
import service.StoreServiceImpl;

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
 * @ClassName UpdaInfoteServlet
 * @Description 类描述
 * @author 胡志强
 * @date 2018/3/1
*/
public class UpdaInfoteServlet extends HttpServlet {
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
        String number = request.getParameter("number");//获取进货商品数量
        String storeId = request.getParameter("storeId");//获取进货店铺ID
        String goodsId = request.getParameter("goodsId");//获取进货商品ID
        String money = request.getParameter("money");//获取进货金额
        Double numbers[]={Double.parseDouble(number)};
        Double moneys[]={Double.parseDouble(money)};
        //判断输入是否为空
        if (number == null||number =="") {
            number = "未输入任何数据";
            out.println(number);
        } else {
            StoreService ss=new StoreServiceImpl();
            GoodsService gs=new GoodsServiceImpl();
            StoreService storeService=new StoreServiceImpl();
            List<Goods> goods=new ArrayList<Goods>();
            Goods good=gs.findGoodsById(Long.parseLong(goodsId));
            goods.add(good);//根据ID查找商品

            Store store=storeService.findStoreById(Long.valueOf(storeId));//根据ID查找店铺
            storeService.setStock(goods,numbers,store,moneys);
            out.println("您已经成功进货");
//            GoodsService gs = new GoodsServiceImpl();
//            Goods goods = gs.findGoodsById(Long.valueOf(selectString));
//            session.setAttribute("goods", goods);
//            request.getRequestDispatcher("store_set_stock.jsp").forward(request, response);
        }
        out.close();//关闭输出流
    }
}