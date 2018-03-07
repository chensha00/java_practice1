package servlet;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package servlet
 * @author kang
 * @date 2018/3/6 16:39
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import Entity.MainPage;
import common.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import service.InvertoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author kang
 * @ClassName MainPageSearch
 * @Description 搜索页面
 * @date 2018/3/6
 */
public class MainPageSearchServlet extends HttpServlet {

    @Autowired
    private InvertoryService invertoryService;


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

        //获取信息
        String condition = req.getParameter("condition");
        InvertoryService invertoryService = (InvertoryService) SpringContextUtil.getBean("invertoryService");
        //从数据库获取商品信息，显示在主页上
        List<MainPage> list = invertoryService.findMainPageCondition(condition);

        HttpSession session = req.getSession();
        session.setAttribute("mainList", list);
//        req.setAttribute("mainList", list);
//        req.getRequestDispatcher("/helloWord.jsp").forward(req, resp);
//        resp.sendRedirect("/main_page_search.jsp");
        resp.sendRedirect("../helloWord.jsp");

    }
}