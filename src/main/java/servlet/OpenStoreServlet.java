package servlet;/********************************************************************
 /**
 * @Project: jsp_web
 * @Package servlet
 * @author 胡志强
 * @date 2018/2/2 9:11
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.Invertory;
import domain.Store;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName OpenStoreServlet
 * @Description 开通商店
 * @author 胡志强
 * @date 2018/2/2
*/
public class OpenStoreServlet extends HttpServlet {
    static PeopleService peopleService = new PeopleServiceImpl();
    static StoreService storeService = new StoreServiceImpl();
    static InvertoryService invertoryService = new InvertoryServiceImpl();
    static GoodsService goodsService = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        //获取想要开通商品的人的id
        HttpSession session = req.getSession();
        Long peopleId = (Long) session.getAttribute("peopleId");
        //获取商铺名
        String storeName = req.getParameter("storeName");
        //生成商铺编号
        String storeNum = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(storeNum);
        //给对象设值并插入数据
        Store newStore = new Store();
        newStore.setStoreName(storeName);
        newStore.setPeopleId(peopleId);
        newStore.setStoreNum(storeNum);
        newStore.setCredit(0L);
        Long storeId = storeService.saveStore(newStore);

        if (storeId != 0){
            System.out.println("开通成功");
            resp.sendRedirect("/StoreServletStock.htm");
        }else {
            resp.sendRedirect("../people_open_store.jsp");
            System.out.println("插入失败");
        }
    }
}