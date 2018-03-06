package servlet;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package servlet
 * @author yanyong
 * @date 2018/2/28 0028 16:35
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.SpringContextUtil;
import domain.People;
import domain.Store;
import service.PeopleService;
import service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyong
 * @ClassName adminUseServlet
 * @Description 类描述
 * @date 2018/2/28 0028
 */
public class AdminUseServlet extends HttpServlet {
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
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String command=req.getParameter("command");
        PeopleService peopleService= (PeopleService) SpringContextUtil.getBean("peopleService");
        StoreService storeService= (StoreService) SpringContextUtil.getBean("storeService");
        List<People> peopleList=new ArrayList<People>();
        List<Store> storeList=new ArrayList<Store>();

        if (command.equals("findPeople")){
            peopleList=peopleService.getAllPeople();
//            req.setAttribute();
            HttpSession session=req.getSession();
            session.setAttribute("peopleList",peopleList);
//            return ;
//            req.setAttribute("peopleList",peopleList);
//            resp.sendRedirect("../administrator_page.jsp");
        }else if(command.equals("findStore")){
            try {
                storeList=storeService.findAllStore();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            HttpSession session=req.getSession();
            session.setAttribute("storeList",storeList);
//            req.setAttribute("storeList",storeList);
//            resp.sendRedirect("../administrator_page.jsp");
        }
    }
}