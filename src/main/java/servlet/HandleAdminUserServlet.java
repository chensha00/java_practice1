package servlet;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package servlet
 * @author yanyong
 * @date 2018/3/5 0005 0:14
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
 * @ClassName HandleAdminUserServlet
 * @Description 类描述
 * @date 2018/3/5 0005
 */
public class HandleAdminUserServlet extends HttpServlet {
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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取命令信息
        String useClass=req.getParameter("useClass");
        Long id=Long.valueOf(req.getParameter("id"));
        String handleWays=req.getParameter("handleWays");
        System.out.println(useClass+" "+id+" "+handleWays);
        //获取peopleService和storeService
        PeopleService peopleService= (PeopleService) SpringContextUtil.getBean("peopleService");
        StoreService storeService= (StoreService) SpringContextUtil.getBean("storeService");
        //获取session
        HttpSession session=req.getSession();
        //useClass为人员和People时
        if ("people".equals(useClass)){
            //处理方式为删除和修改时
            if ("delete".equals(handleWays)){
                //删除人员信息
                peopleService.deletePeopleById(id);
                //替换session peopleList信息
                List<People> peopleList=new ArrayList<People>();
                peopleList=peopleService.getAllPeople();
                session.removeAttribute("peopleList");
                session.setAttribute("peopleList",peopleList);
            }else if ("update".equals(handleWays)){
                //修改 people信息
                People updPeople=peopleService.findPeopleById(id);
                session.setAttribute("updPeople",updPeople);
//                resp.sendRedirect("../update_people.jsp");
            }else {
                resp.getWriter().write("error");
            }
        }else if ("store".equals(useClass)){

            if ("delete".equals(handleWays)){
                //删除store信息
                storeService.deleteStoreById(id);
                //替换session storeList信息
                List<Store> storeList=new ArrayList<Store>();
                try {
                    storeList=storeService.findAllStore();
                    session.removeAttribute("storeList");
                    session.setAttribute("storeList",storeList);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else if ("update".equals(handleWays)){
                //修改store信息
                Store updStore=storeService.findStoreById(id);
                session.setAttribute("updStore",updStore);
//                resp.sendRedirect("../update_store.jsp");
            }else {
                resp.getWriter().write("error");
            }
        }else {
            resp.getWriter().write("error");
        }
        
    }
}