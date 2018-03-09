package controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package controller
 * @author 胡志强
 * @date 2018/3/6 10:34
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import Entity.MainPage;
import common.util.AddConditionUtils;
import common.util.SpringContextUtil;
import common.util.base.BaseAction;
import domain.Goods;
import domain.Invertory;
import domain.People;
import domain.Store;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import service.GoodsService;
import service.InvertoryService;
import service.PeopleService;
import service.StoreService;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StoreAction
 * @Description 商铺相关action
 * @author 胡志强
 * @date 2018/3/6
*/
@Action( value = "storeAction")

@Results({
        @Result( name="storeHome",location="/store_home_page.jsp"),
})
public class StoreAction extends BaseAction{

    @Autowired
    private PeopleService peopleService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private InvertoryService invertoryService;
    @Autowired
    private GoodsService goodsService;
    /**
     * @Title: storeHome
     * @Description: 跳转到store的主页
     * @author hzq
     * @date
     * @throw YnCorpSysException
     */
    public String storeHome(){

        HttpSession session = req.getSession();
        Long  peopleId =Long.valueOf(req.getParameter("peopleId"));
        String result = "";

        try {
            //一个人只能同时拥有一个店
            People people = new People();
            people = peopleService.findPeopleById(peopleId);
            if(people != null ){
                List<Map<String,Object>> map1 = new ArrayList<Map<String,Object>>();
                map1.add(AddConditionUtils.addCondition("people_Id", "=", peopleId));
                List<Store> stores = new ArrayList<Store>();
                stores = storeService.findStoreByUnSureCondition(map1);
                if (stores.size()==0){
                    session.setAttribute("people",people);
                    result = "storeHome";
                }else{
                    //根据店铺id查找到商品信息
                    List<MainPage> mainPages = new ArrayList<MainPage>();
                    mainPages = invertoryService.findMainPageByStoreId(stores.get(0).getId());
                    //再根据库存编号中的商品id查找商品信息
                    session.setAttribute("stores",stores);
                    session.setAttribute("peoples",people);
                    session.setAttribute("mainPages",mainPages);
                    result = "storeHome";

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }

    /**
     * @Title: offLoading
     * @Description: 商品下架
     * @author hzq
     * @date
     */
    public String offLoading(){
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
                return "offLoading";
            }else{
                System.out.println("出现错误");
                return "error";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }
}