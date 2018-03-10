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
import common.util.SpringContextUtil;
import domain.People;
import service.InventoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
* @author liukang
* @ClassName MainPageServlet
* @Description 主页的servlet
* @date 2018/1/31
*/
public class MainPageServlet extends HttpServlet {

    InventoryService inventoryService= (InventoryService) SpringContextUtil.getBean("inventoryService");


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    /**
     * @Title: doPost
     * @Description: 从数据库获取数据显示在前台
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
        List<MainPage> list = inventoryService.findMainPageInventory(0L, 20L);
        Integer total = inventoryService.limitMainPage();
        Integer present = 1;
        req.setAttribute("mainList", list);
        req.setAttribute("total", total);
        req.setAttribute("present", present);
        req.getRequestDispatcher("/main_page.jsp").forward(req, resp);
    }

}