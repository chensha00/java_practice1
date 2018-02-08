package servlet;/********************************************************************
/**
* @Project: bigstar_online_mall
* @Package servlet
* @author liukang
* @date 2018/2/5 8:37
* @Copyright: 2018 www.zyht.com Inc. All rights reserved.
* @version V1.0
*/

import domain.People;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @author liukang
* @ClassName HeadPageServlet
* @Description 排头的servlet
* @date 2018/2/5
*/
public class HeadPageServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    /**
     * @Title: doPost
     * @Description: 从注册页面传入人员
     * @author liukang
     * @date
     * @throw ServletException, IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //登录人员的信息
        People person = (People) req.getAttribute("person");
        req.setAttribute("person", person);
        //从数据库获取商品信息，显示在主页上
        req.getRequestDispatcher("/head_page.jsp").forward(req, resp);
    }
}