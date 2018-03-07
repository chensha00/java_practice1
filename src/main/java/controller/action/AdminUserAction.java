package controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package controller.action
 * @author yanyong
 * @date 2018/3/7 0007 14:36
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.SpringContextUtil;
import common.util.base.BaseAction;
import domain.People;
import domain.Store;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import service.PeopleService;
import service.StoreService;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyong
 * @ClassName AdminUserAction
 * @Description 类描述
 * @date 2018/3/7 0007
 */
@Action(value = "adminUserAction")
@Results({
        @Result(name = "updatePeople",location = "/update_people.jsp"),
        @Result(name = "updateStore",location = "/update_store.jsp"),
        @Result(name = "success",location = "/administrator_page.jsp")
})
@AllowedMethods({"findPeopleAll","findStoreAll","deletePeople","deleteStore","updatePeople","updateStore"})
public class AdminUserAction extends BaseAction {

    /**
     * @Title: findPeopleAll
     * @Description: 查找所有人员信息
     * @author yanyong
     * @date 2018-03-07
     * @return: SUCCESS
     */
    public String findPeopleAll(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
//        String command=req.getParameter("command");
        //获取peopleService
        PeopleService peopleService= (PeopleService) SpringContextUtil.getBean("peopleService");
        //获取人员信息集合
        List<People> peopleList=new ArrayList<People>();
        peopleList=peopleService.getAllPeople();
//            req.setAttribute();
        //保存人员信息集合到session中
        HttpSession session=req.getSession();
//        session.removeAttribute("peopleList");
        session.setAttribute("peopleList",peopleList);
        return SUCCESS;
    }

    /**
     * @Title: findStore
     * @Description: 查找店铺信息并保存到session中
     * @author yanyong
     * @date 2018-03-07
     * @return: SUCCESS
     */
    public String findStoreAll(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        //获取storeService
        StoreService storeService= (StoreService) SpringContextUtil.getBean("storeService");
        //获取人员信息店铺集合
        List<Store> storeList=new ArrayList<Store>();
        try {
            storeList=storeService.findAllStore();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //保存人员信息集合到session中
        HttpSession session=req.getSession();
        session.setAttribute("storeList",storeList);
        return SUCCESS;
    }

    /**
     * @Title: deletePeople
     * @Description: 删除指定id的人员
     * @author yanyong
     * @date 2018-03-07
     * @return: SUCCESS
     */

    public void deletePeople(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        //获取需要删除的人员id
        String strId=req.getParameter("peopleId");
        Long peopleId=Long.valueOf(strId);
        //获取peopleService
        PeopleService peopleService= (PeopleService) SpringContextUtil.getBean("peopleService");
        //删除人员信息
        peopleService.deletePeopleById(peopleId);
        //替换session peopleList信息
        HttpSession session=req.getSession();
        List<People> peopleList=new ArrayList<People>();
        peopleList=peopleService.getAllPeople();
        session.removeAttribute("peopleList");
        session.setAttribute("peopleList",peopleList);
//        return SUCCESS;
    }

    /**
     * @Title: deleteStore
     * @Description: 删除指定id店铺
     * @author yanyong
     * @date 2018-03-07
     * @return: SUCCESS
     */

    public void deleteStore(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        //获取id
        String strId=req.getParameter("storeId");
        Long storeId=Long.valueOf(strId);
        //获取storeService
        StoreService storeService= (StoreService) SpringContextUtil.getBean("storeService");
        //获取人员信息店铺集合
        List<Store> storeList=new ArrayList<Store>();

        //删除store信息
        storeService.deleteStoreById(storeId);
        //替换session storeList信息
        HttpSession session=req.getSession();
        try {
            storeList=storeService.findAllStore();
            session.removeAttribute("storeList");
            session.setAttribute("storeList",storeList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        return SUCCESS;
    }

    /**
     * @Title: updatePeople
     * @Description: 修改人员信息
     * @author yanyong
     * @date 2018-03-07
     * @return: String structs删选值
     */

    public String updatePeople(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        //获取需要删除的人员id
        String strId=req.getParameter("peopleId");
        Long peopleId=Long.valueOf(strId);
        //获取peopleService
        PeopleService peopleService= (PeopleService) SpringContextUtil.getBean("peopleService");

//        HttpSession session=req.getSession();
        //获取需要修改 people信息
        HttpSession session=req.getSession();
        People updPeople=peopleService.findPeopleById(peopleId);
        session.setAttribute("updPeople",updPeople);
        return "updatePeople";
    }

    /**
     * @Title: updateStore
     * @Description: 修改店铺信息
     * @author yanyong
     * @date 2018-03-07
     * @return: String structs删选值
     */

    public String updateStore(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        //获取id
        String strId=req.getParameter("storeId");
        Long storeId=Long.valueOf(strId);
        //获取storeService
        StoreService storeService= (StoreService) SpringContextUtil.getBean("storeService");
        //获取人员信息店铺集合
        List<Store> storeList=new ArrayList<Store>();
        //修改store信息
        HttpSession session=req.getSession();
        Store updStore=storeService.findStoreById(storeId);
        session.setAttribute("updStore",updStore);
        return "updateStore";


    }

}