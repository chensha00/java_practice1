package servlet;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package servlet
 * @author 胡志强
 * @date 2018/3/2 9:32
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

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

/**
 * @ClassName UpdateGoodsPrice
 * @Description 商品调价
 * @author 胡志强
 * @date 2018/3/2
*/
public class UpdateGoodsPrice extends HttpServlet {
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
        //首先获取需要调价的库存的信息
        Long inventoryId = Long.valueOf(req.getParameter("inventoryId"));
        Inventory inventory = new Inventory();
        inventory = inventoryService.findInventoryById(inventoryId);
        //然后获取新的商品价格信息
        Double price = Double.valueOf(req.getParameter("price"));
        if (price!=null){
            inventory.setPrice(price);
            int row = inventoryService.updateInventorById(inventoryId,inventory);
            if (row!=0){
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }
        }

    }
}