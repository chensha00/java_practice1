package servlet;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package servlet
 * @author yanyong
 * @date 2018/3/5 0005 18:21
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyong
 * @ClassName UpdatePeopleServlet
 * @Description 类描述
 * @date 2018/3/5 0005
 */
public class UpdatePeopleServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //peopleId:id,name:name,cardId:cardId,sex:sex,age:age,money:money,address:address,username:username,password:password
        //设置编码方式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取人员信息
//        String idString=req.getParameter("peopleId");
        Long id=Long.valueOf(req.getParameter("peopleId"));
        String name=req.getParameter("name");
        String cardId=req.getParameter("cardId");
        String sex=req.getParameter("sex");
        Integer age=Integer.valueOf(req.getParameter("age"));
        Double money=Double.valueOf(req.getParameter("money"));
        String address=req.getParameter("address");
        String userName=req.getParameter("username");
        String password=req.getParameter("password");
        //生成人员对象
        People people=new People();
        people.setId(id);
        people.setName(name);
        people.setCardId(cardId);
        people.setSex(sex);
        people.setAge(age);
        people.setMoney(money);
        people.setAddress(address);
        people.setUsreName(userName);
        people.setPassWord(password);
        //获取peopleService
        PeopleService peopleService= (PeopleService) SpringContextUtil.getBean("peopleService");
        //更新人员信息
        peopleService.updatePeople(people);
        //更新peopleList信息
        List<People> peopleList=new ArrayList<People>();
        HttpSession session=req.getSession();
        peopleList=peopleService.getAllPeople();
        session.removeAttribute("peopleList");
        session.setAttribute("peopleList",peopleList);
    }
}