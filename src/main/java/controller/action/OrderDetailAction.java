package controller.action;/**
 * Created by Roger_yu on 2018/3/8.
 */


import com.google.gson.Gson;
import common.util.SpringContextUtil;
import common.util.base.BaseAction;
import domain.OrderDetail;
import domain.Store;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import service.OrderDetailService;
import service.StoreService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

/**
 * @author yuweiyang
 * @ClassName OrderDetailAction
 * @Description 类描述
 * @date 2018/3/8
 */
@Action (value = "orderDetailAction")
@Results({
        @Result( name="storeOrder",location="/store_order.jsp"),
        @Result( name="storeDelivery",location="/store_order.jsp")
})
@AllowedMethods({"storeOrder","storeDelivery"})
public class OrderDetailAction extends BaseAction{
    @Autowired
    private StoreService storeService;

    @Autowired
    private OrderDetailService orderDetailService;
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
        List<OrderDetail> orderDetail=orderDetailService.findOrderDetailByStoreId(storeId);
        if (store!=null && orderDetail!=null){
//          保存在store在session中
            HttpSession session=req.getSession();
            session.setAttribute("store",store);
            session.setAttribute("orderDetail",orderDetail);
            return "storeOrder";
        }else{
            return ERROR;
        }
    }
    /**
     * @Title:
     * @Description: 发货按钮 订单详情页面
     * @author yuweiyang
     * @date
     */
    public String storeDelivery() throws IOException {
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        //        接收订单详情ID
        String id=req.getParameter("storeId");
        Long  odId =Long.valueOf(req.getParameter("storeId"));
        String result = "";

        StoreService storeService= (StoreService) SpringContextUtil.getBean("storeService");
        storeService.delivery(odId);

        PrintWriter out = resp.getWriter();
        HashMap<String,String> hashMap=new HashMap<String, String>();
        hashMap.put("MESSAGE","发货成功");
        Gson gson=new Gson();
        out.print(gson.toJson(hashMap));
//            //关闭流
        out.flush();
        out.close();
        return "storeDelivery";
    }
}