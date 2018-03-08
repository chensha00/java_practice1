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
import common.util.SpringContextUtil;
import common.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import service.InvertoryService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
        @Result(name = "search", location = "/main_page_search.jsp")
})
public class MainAction extends BaseAction {

    InvertoryService invertoryService = (InvertoryService) SpringContextUtil.getBean("invertoryService");

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
     * @Description: 分页
     * @author kang
     * @date 2018-03-08
     * @throw YnCorpSysException
     */
    public String limit() {
        String result = "";
        String page = req.getParameter("page");
        Integer present = Integer.valueOf(req.getParameter("present"));
        Integer total = Integer.valueOf(req.getParameter("total"));
        Integer totalNum = invertoryService.findInvertoryAll().size();
        Long start = 0l;
        Long end = 0l;
        out:
        if (page.equals("start")) {
            end = 20l;
            break out;
        } else if (page.equals("last")) {
            if (present > 1) {
                start = Long.valueOf((present - 2) * 20);
                end = Long.valueOf((present - 1) * 20);
                break out;
            } else {
                end = 20l;
                break out;
            }
        } else if (page.equals("next")) {
            if (present < total - 1) {
                start = Long.valueOf(present * 20);
                end = Long.valueOf((present + 1) * 20);
                break out;
            } else {
                start = Long.valueOf((total - 1) * 20);
                end = Long.valueOf(totalNum);
                break out;
            }
        } else if (page.equals("end")) {
            start = Long.valueOf((total - 1) * 20);
            end = Long.valueOf(totalNum);
            break out;
        } else {
            Integer number = Integer.valueOf(page);
            if (number < total && number > 0) {
                start = Long.valueOf((number - 1) * 20);
                end = Long.valueOf(number * 20);
                break out;
            } else if (number == total) {
                start = Long.valueOf((total - 1) * 20);
                end = Long.valueOf(totalNum);
                break out;
            } else {
                start = Long.valueOf((present - 2) * 20);
                end = Long.valueOf((present - 1) * 20);
                break out;
            }
        }
        List<MainPage> list = invertoryService.findMainPageInvertory(start, end);
        Long aLong = start / 20 + 1;
        present = Integer.parseInt(String.valueOf(aLong));
        req.setAttribute("mainList", list);
        req.setAttribute("total", total);
        req.setAttribute("present", present);
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
     * @Title: main
     * @Description: 主页显示商品
     * @author kang
     * @date 2018-03-07
     * @throw YnCorpSysException
     */
    public String search() {
        String result = "";
        String condition = req.getParameter("search");
        InvertoryService invertoryService = (InvertoryService) SpringContextUtil.getBean("invertoryService");
        //从数据库获取商品信息，显示在主页上
        List<MainPage> list = invertoryService.findMainPageCondition(condition);

        HttpSession session = req.getSession();
        session.setAttribute("mainList", list);
        if (list != null && list.size() != 0) {
            session.setAttribute("mainList", list);
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

}