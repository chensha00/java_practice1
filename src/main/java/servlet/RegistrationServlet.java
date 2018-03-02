package servlet;/**
 * Created by Kaiser on 2018/1/31.
 */
/********************************************************************
 /**
 * @Project: bigstar_online_mall
 * @Package servlet
 * @author zuorui
 * @date 2018/1/31 9:43
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.SpringContextUtil;
import domain.People;
import service.PeopleService;
import service.PeopleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zuorui
 * @ClassName registration
 * @Description 类描述
 * @date 2018/1/31
 */
public class RegistrationServlet extends HttpServlet {

    /**
     * @Title: doGet
     * @Description: get请求
     * @author zuorui
     * @date 2018-01-31
     * @throw ServletException, IOException
     * @param: req request对象
     * @param: resp response对象
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * @Title: doPost
     * @Description: post请求
     * @author zuorui
     * @date 2018-01-31
     * @throw ServletException, IOException
     * @param: req request对象
     * @param: resp response对象
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        System.out.println("进来了");
        String userName = req.getParameter("username");
        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String idd = req.getParameter("idCard");
        String ads = req.getParameter("address");
        String amt = req.getParameter("amount");
//        System.out.println(userName+""+name+""+pwd+""+sex+""+age+""+idd+""+ads+""+amt+"");//

//        将person的信息存入数据库，调用peopleService 的save方法
        People people1 = new People();
        people1.setUsreName(userName);
        people1.setName(name);
        people1.setSex(sex);
        people1.setCardId(idd);
        people1.setAddress(ads);
        people1.setPassWord(pwd);
        if (age.equals("") != true && age != null) {
            people1.setAge(Integer.valueOf(age));
        }
        if (amt.equals("") != true && amt != null) {
            people1.setMoney(Double.valueOf(amt));
        }
        //

//        new PeopleServiceImpl().showPeople(people1);
        // 拿到PeopleService
        PeopleService peopleService=(PeopleService) SpringContextUtil.getBean("peopleService");

        Integer line = peopleService.savePeople(people1);

        System.out.println(line);
        if (line == null) {
            System.out.println("注册失败");
            resp.sendRedirect("../registration_page.jsp");
        } else if (line == 0) {
            System.out.println("注册失败");
            resp.sendRedirect("../registration_page.jsp");
        } else {
            //注册成功直接转登录页面
            System.out.println("注册成功");
            resp.sendRedirect(req.getContextPath()+"/login_page.jsp");
        }
    }
}
