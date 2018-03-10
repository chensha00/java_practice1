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
import domain.Inventory;
import service.GoodsService;
import service.InventoryService;
import service.PeopleService;
import service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    InventoryService inventoryService = (InventoryService) SpringContextUtil.getBean("inventoryService");

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
            List<Inventory> inventory = inventoryService.findInventoryByUnSureCondition(map);
            int res =  inventoryService.deleteInventoryById(inventory.get(0).getId());
            if (res!=0){
                System.out.println("下架成功");
                req.getRequestDispatcher("../store/store_home_servlet").forward(req,resp);
            }else{
                System.out.println("出现错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}