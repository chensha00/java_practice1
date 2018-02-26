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
         //接收数据（商品信息和店铺信息）
        Long storeId =(Long)req.getAttribute("storeId");
        Long goodId =(Long)req.getAttribute("goodId");
        //通过两个id查找库存表，获取该条记录的库存id
        List<Map<String,Object>> map = new ArrayList<Map<String,Object>>();
        map.add(AddConditionUtils.addCondition("store_id", "=", storeId));
        map.add(AddConditionUtils.addCondition("good_id", "=", goodId));
        try {
            List<Invertory> invertory = invertoryService.findInvertoryByUnSureCondition(map);
            int res =  invertoryService.deleteInvertoryById(invertory.get(0).getId());
            if (res!=0){
                System.out.println("下架成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}