package controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package controller
 * @author kang
 * @date 2018/3/7 14:53
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import Entity.MainPage;
import common.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import service.InvertoryService;
import tools.LimitMethod;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author kang
 * @ClassName MainAction
 * @Description 主页面
 * @date 2018/3/7
 */
@Action(value = "mainAction")
@Results({
        @Result(name = "main", location = "/main_page.jsp"),
        @Result(name = "limit", location = "/main_page.jsp"),
        @Result(name = "cart", location = "/cart.jsp"),
        @Result(name = "search", location = "/main_page_search.jsp"),
        @Result(name = "searchLimit", location = "/main_page_search.jsp")
})
public class MainAction extends BaseAction {

    @Autowired
    private InvertoryService invertoryService;


    /**
     * @Title: main
     * @Description: 主页显示商品
     * @author kang
     * @date 2018-03-07
     * @throw YnCorpSysException
     */
    public String main() {
        String result = "";
        //从数据库获取商品信息，显示在主页上
        List<MainPage> list = invertoryService.findMainPageInvertory(0L, 20L);
        Integer total = invertoryService.limitMainPage();
        Integer present = 1;
        req.setAttribute("mainList", list);
        req.setAttribute("total", total);
        req.setAttribute("present", present);
        result = "main";
        return result;
    }

    /**
     * @Title:
     * @Description: 主页分页
     * @author kang
     * @date 2018-03-08
     * @throw YnCorpSysException
     */
    public String limit() {
        String result = "";
        String present = req.getParameter("present");
        String page = req.getParameter("page");
        List<MainPage> list = invertoryService.findMainPageInvertoryAll();
        Integer totalNum = list.size();
        LimitMethod limitMethod = new LimitMethod();
        Map map = limitMethod.limitMethods(present, page, totalNum);
        List<MainPage> list1 = list.subList((int) map.get("start"), (int) map.get("end"));
        req.setAttribute("mainList", list1);
        req.setAttribute("total", map.get("total"));
        req.setAttribute("present", map.get("present"));
        result = "limit";
        return result;
    }


    /**
     * @Title: cart
     * @Description: 购物车显示
     * @author kang
     * @date 2018-03-07
     * @throw YnCorpSysException
     */
    public String cart() {
        String result = "";
        String op = req.getParameter("op");
        HttpSession session = req.getSession();
        List<MainPage> cartList = new ArrayList<MainPage>();
        //获取op，对其进行判断
        if ("add".equals(op)) {
            //将获取的信息储存到mainPage对象并发送
            String invertoryId = req.getParameter("idName");
            String name = req.getParameter("nameName");
            String price = req.getParameter("priceName");
            String number = req.getParameter("numberName");
            String storeName = req.getParameter("storeNameName");
            MainPage mainPage = new MainPage();
            mainPage.setInvertoryId(Long.valueOf(invertoryId));
            mainPage.setName(name);
            mainPage.setPrice(Double.valueOf(price));
            mainPage.setNumber(Double.valueOf(number));
            mainPage.setStoreName(storeName);

            cartList = (List<MainPage>) session.getAttribute("cartList");
            if (cartList == null) {
                cartList = new ArrayList<MainPage>();
            }

            cartList.add(mainPage);
            session.setAttribute("cartList", cartList);
            req.setAttribute("cartList", cartList);
        } else if ("list".equals(op)) {

            cartList = (List<MainPage>) session.getAttribute("cartList");
            req.setAttribute("cartList", cartList);
        }
        result = "cart";
        return result;
    }

    /**
     * @Title: search
     * @Description: 搜索页显示商品
     * @author kang
     * @date 2018-03-07
     * @throw YnCorpSysException
     */
    public String search() {
        String result = "";
        String condition = req.getParameter("search");
        //从数据库获取商品信息，显示在搜索页上
        List<MainPage> list = invertoryService.findMainPageCondition(condition);
        if (list != null && list.size() != 0) {
            int total = list.size();
            List<MainPage> list1 = null;
            if (total > 20) {
                list1 = list.subList(0, 20);
            } else {
                list1 = list;
            }
            Integer present = 1;
            int total1 = (total-1) / 20 + 1;
            req.setAttribute("total", total1);
            req.setAttribute("present", present);
            req.setAttribute("search", condition);
            req.setAttribute("mainList", list1);
        } else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = null;
            try {
                out = resp.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.println("您所搜索的商品或者店铺不存在！");
            out.close();//关闭输出流
        }
        result = "search";
        return result;
    }

    /**
     * @Title:
     * @Description: 搜索分页
     * @author kang
     * @date 2018-03-08
     * @throw YnCorpSysException
     */
    public String searchLimit() {
        String result = "";
        String condition = req.getParameter("search");
        String present = req.getParameter("present");
        String page = req.getParameter("page");
        List<MainPage> list = invertoryService.findMainPageCondition(condition);
        Integer totalNum = list.size();
        LimitMethod limitMethod = new LimitMethod();
        Map map = limitMethod.limitMethods(present, page, totalNum);
        List<MainPage> list1 = list.subList((int) map.get("start"), (int) map.get("end"));
        req.setAttribute("mainList", list1);
        req.setAttribute("search", condition);
        req.setAttribute("total", map.get("total"));
        req.setAttribute("present", map.get("present"));
        result = "searchLimit";
        return result;
    }
}