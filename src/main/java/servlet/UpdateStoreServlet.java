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
import domain.Store;
import service.StoreService;

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
 * @ClassName UpdateStore
 * @Description 类描述
 * @date 2018/3/5 0005
 */
public class UpdateStoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码方式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取店铺信息
        String id=req.getParameter("storeId");
        String storeNum=req.getParameter("storeNum");
        String storeName=req.getParameter("storeName");
        String credit=req.getParameter("credit");
        String peopleId=req.getParameter("peopleId");
        //生成对象
        Store store=new Store();
        store.setId(Long.valueOf(id));
        store.setStoreNum(storeNum);
        store.setStoreName(storeName);
        store.setCredit(Long.valueOf(credit));
        store.setPeopleId(Long.valueOf(peopleId));
        //获取storeService
        StoreService storeService= (StoreService) SpringContextUtil.getBean("storeService");
        storeService.updateStore(store);
        //获取store集合
        HttpSession session=req.getSession();
        session.removeAttribute("storeList");
        List<Store> storeList=new ArrayList<Store>();
        storeList=storeService.getStoreAll();
        session.setAttribute("storeList",storeList);
    }
}