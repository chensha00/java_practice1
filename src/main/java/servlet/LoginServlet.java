package servlet;/********************************************************************
 /**
 * @Project: bigstar_online_mall
 * @Package servlet
 * @author yanyong
 * @date 2018/1/30 0030 14:46
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.google.gson.Gson;
import common.util.SpringContextUtil;
import domain.People;
import service.PeopleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author yanyong
 * @ClassName LoginServlet
 * @Description 登录处理servlet类
 * @date 2018/1/30 0030
 */
public class LoginServlet extends HttpServlet {

    /**
     * @Title: doGet
     * @Description: get请求
     * @author yanyong
     * @date 2018-01-30
     * @throw ServletException, IOException
     * @param: req request对象
     * @param: resp response对象
     */

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * @Title: doPost
     * @Description: gpost请求处理
     * @author yanyong
     * @date 2018-01-30
     * @throw ServletException, IOException
     * @param: req request对象
     * @param: resp response对象
     */

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String userName = req.getParameter("username");
        String pwd = req.getParameter("password");
        System.out.println(userName + " " + pwd); //
        //使用Spring调用service层
        PeopleService peopleService = (PeopleService) SpringContextUtil.getBean("peopleService");
        People person = peopleService.findPeopleByUserName(userName, pwd);
//        System.out.println(person.getUsreName() + person.getPassWord()); //
        HttpSession session = req.getSession();
        if (person == null) {
            session.setAttribute("LoginMessage", "error");
            resp.sendRedirect("../login_page.jsp");
        } else {
            session.removeAttribute("LoginMessage");
            session.setAttribute("person", person);
//            resp.sendRedirect("/mainAction!main.do");
//            resp.setCharacterEncoding("UTF-8");
//            resp.setContentType("text/html;charset=UTF-8");
//
            PrintWriter out = resp.getWriter();
//
            HashMap<String,String> hashMap=new HashMap<String, String>();
            hashMap.put("MESSAGE","登陆成功");
            Gson gson=new Gson();
//
            out.print(gson.toJson(hashMap));
//            //关闭流
            out.flush();
            out.close();
        }
    }
}