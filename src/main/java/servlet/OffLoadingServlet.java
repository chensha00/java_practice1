package servlet;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package servlet
 * @author 胡志强
 * @date 2018/2/26 8:44
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.AddConditionUtils;
import common.util.SpringContextUtil;
import domain.Goods;
import domain.Invertory;
import domain.People;
import domain.Store;
import service.GoodsService;
import service.InvertoryService;
import service.PeopleService;
import service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OffLoadingServlet
 * @Description 商品下架类
 * @author 胡志强
 * @date 2018/2/26
*/
public class OffLoadingServlet extends HttpServlet {
    //使用Spring调用service层
    PeopleService peopleService = (PeopleService) SpringContextUtil.getBean("peopleService");

    StoreService storeService = (StoreService) SpringContextUtil.getBean("storeService");

    InvertoryService invertoryService = (InvertoryService) SpringContextUtil.getBean("invertoryService");

    GoodsService goodsService = (GoodsService) SpringContextUtil.getBean("goodsService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("username","zhangsan1");
        String username = (String) session.getAttribute("username");

        String sqlUserName = " '" + username + "' ";
        List<Map<String,Object>> map = new ArrayList<Map<String,Object>>();
        map.add(AddConditionUtils.addCondition("username", "=", sqlUserName));
        try {
            //一个人只能同时拥有一个店
            List<People> peoples = new ArrayList<People>();
            peoples = peopleService.findPeopleByUnSureCondition(map);
            if(peoples.get(0) != null ){
                List<Map<String,Object>> map1 = new ArrayList<Map<String,Object>>();
                map1.add(AddConditionUtils.addCondition("people_Id", "=", peoples.get(0).getId()));
                List<Store> stores = new ArrayList<Store>();
                stores = storeService.findStoreByUnSureCondition(map1);
                //测试mybatis
                Store store = new Store();
                store = storeService.findStoreById(1L);
                System.out.println(store.getStoreNum());
                if (stores.get(0) == null){
                    session.setAttribute("peoples",peoples);
                    req.getRequestDispatcher("../people_open_store.jsp").forward(req,resp);
                }else{
                    //根据店铺id查找到库存信息
                    List<Invertory> invertories = new ArrayList<Invertory>();
                    List<Map<String,Object>> map2 = new ArrayList<Map<String,Object>>();
                    map2.add(AddConditionUtils.addCondition("store_id","=",stores.get(0).getId()));
                    invertories = invertoryService.findInvertoryByUnSureCondition(map2);
                    //再根据库存编号中的商品id查找商品信息
                    List<Goods> goods = new ArrayList<Goods>();
                    for (int i = 0; i < invertories.size() ; i++) {
                        Goods good = new Goods();
                        good = goodsService.findGoodsById(invertories.get(i).getGoodsId());
                        goods.add(good);
                    }
                    session.setAttribute("stores",stores);
                    session.setAttribute("peoples",peoples);
                    session.setAttribute("invertorys",invertories);
                    session.setAttribute("goods",goods);
                    req.getRequestDispatcher("../store_home_page.jsp").forward(req,resp);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}