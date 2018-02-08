package servlet;/********************************************************************
 /**
 * @Project: bigstar_online_mall
 * @Package servlet
 * @author liukang
 * @date 2018/2/4 20:05
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.People;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * @author liukang
 * @ClassName PersonServlet
 * @Description 账户页面处理
 * @date 2018/2/4
 */
public class PersonServlet extends HttpServlet{

    private static ResourceBundle lStrings = ResourceBundle.getBundle("javax.servlet.http.LocalStrings");

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = lStrings.getString("http.method_post_not_supported");
        if(protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }

//        设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
//        给对象赋值
        String userName=req.getParameter("username");
        String name=req.getParameter("name");
        String idd=req.getParameter("cardId");
        String pwd=req.getParameter("password");
        String Sex=req.getParameter("sex");
        String Age=req.getParameter("age");
        String Money=req.getParameter("money");
        String add=req.getParameter("address");
        System.out.println("userName"+" "+pwd);//

//        将person信息存入数据库，调用peopleService的save方法
        People person=new People();
        person.setUsreName(userName);
        person.setName(name);
        person.setSex(Sex);
        person.setCardId(idd);
        person.setAddress(add);
        person.setPassWord(pwd);
    }


}