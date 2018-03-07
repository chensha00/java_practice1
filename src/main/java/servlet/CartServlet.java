package servlet;/********************************************************************
/**
* @Project: bigstar_online_mall
* @Package servlet
* @author liukang
* @date 2018/1/31 9:56
* @Copyright: 2018 www.zyht.com Inc. All rights reserved.
* @version V1.0
*/


import Entity.MainPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* @author liukang
* @ClassName CartServlet
* @Description 购物车的servlet
* @date 2018/1/31
*/
public class CartServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doPost(req, resp);
    }

    /**
     * @Title: doPost
     * @Description: 传输数据
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String op = req.getParameter("op");
        if ("add".equals(op)) {
            add(req, resp);
        } else if ("list".equals(op)) {
            list(req, resp);
        }

    }

    /**
     * @Title: add
     * @Description: 将主页获取的数据传到购物车页面
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public void add(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String invertoryId = req.getParameter("idName");
        String name = req.getParameter("nameName");
        String price = req.getParameter("priceName");
        String number = req.getParameter("numberName");
        String storeName = req.getParameter("storeNameName");
        MainPage mainPage = new MainPage();
        mainPage.setInvertoryId(Long.valueOf(invertoryId));
        mainPage.setName(name);
        mainPage.setPrice(Double.valueOf(price));
        mainPage.setNumber(Double.valueOf(number));
        mainPage.setStoreName(storeName);


        HttpSession session = req.getSession();
        List<MainPage> cartList = new ArrayList<MainPage>();
        cartList = (List<MainPage>) session.getAttribute("cartList");
        if (cartList == null) {
            cartList = new ArrayList<MainPage>();
        }
        cartList.add(mainPage);

        session.setAttribute("cartList", cartList);
        req.setAttribute("cartList", cartList);
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    //获取信息
    public void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<MainPage> cartList = new ArrayList<MainPage>();
        cartList = (List<MainPage>) session.getAttribute("cartList");
        req.setAttribute("cartList", cartList);
        System.out.println(cartList);
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

}