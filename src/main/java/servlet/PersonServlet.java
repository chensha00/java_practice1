package servlet;/********************************************************************
 /**
 * @Project: bigstar_online_mall
 * @Package servlet
 * @author liukang
 * @date 2018/2/4 20:05
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.SpringContextUtil;
import domain.People;
import service.PeopleService;

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


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
//      先查找出要修改的人员信息
        Long peopleId = Long.valueOf(req.getParameter("peopleId"));
        PeopleService peopleService = (PeopleService) SpringContextUtil.getBean("peopleService");
        People people = new People();
        people = peopleService.findPeopleById(peopleId);
        //判断用户修改的内容
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        if (address.equals(people.getPassWord())){
            if (password.equals(people.getPassWord())){
                System.out.println("请输入要修改的内容");
            }
        }else
        {
            People newPeople = new People();
            newPeople.setPassWord(password);
            newPeople.setAddress(address);
            int row=peopleService.updatePeople(newPeople);
            if(row!=0){
                System.out.println("修改成功");
                //跳转到响应的servlet
                resp.sendRedirect("/");
            }
        }

    }


}