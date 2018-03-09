package controller;/**
 * Created by Roger_yu on 2018/3/8.
 */


import common.util.base.BaseAction;
import domain.Store;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import service.StoreService;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * @author yuweiyang
 * @ClassName OrderDetailAction
 * @Description 类描述
 * @date 2018/3/8
 */
@Action (value = "orderDetailAction")
@Results({
        @Result( name="storeOrder",location="/store_order.jsp")
})
@AllowedMethods({"storeOrder"})
public class OrderDetailAction extends BaseAction{
    @Autowired
    private StoreService storeService;
    /**
     * @Title:
     * @Description: 跳转到订单详情页面
     * @author yuweiyang
     * @date
     */
    public String storeOrder(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
//        接收商铺ID
        String s=req.getParameter("storeId");
        Long  storeId =Long.valueOf(req.getParameter("storeId"));
        String result = "";

        Store store=new Store();
        store=storeService.findStoreById(storeId);
        if (store!=null){
//          保存在store在session中
            HttpSession session=req.getSession();
            session.setAttribute("store",store);
            return "storeOrder";
        }else{
            return ERROR;
        }






    }
}