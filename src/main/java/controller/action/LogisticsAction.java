package controller.action; /**
 * @Project: zyht_web
 * @Package controller
 * @author jiangxiangwen
 * @date 2018/3/6
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import common.util.SpringContextUtil;
import common.util.base.BaseAction;
import domain.LogisticsGoby;
import domain.LogisticsInfo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import service.LogisticsGobyService;
import service.LogisticsGobyServiceImpl;
import service.LogisticsInfoService;
import service.LogisticsInfoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName LogisticsAction
 * @Description 物流详情
 * @date 2018/3/6
 */
@Action( value = "logisticsAction")

@Results({
        @Result( name="logisticsPage",location="/logistics_page.jsp")
})
public class LogisticsAction extends BaseAction {

    // 物流信息的service层
    @Autowired
    private LogisticsInfoService logisticsInfoService;

    // 物流过程的service层
    @Autowired
    private LogisticsGobyService logisticsGobyService;

    /**
     * @Title: logisticsPage
     * @Description: 物流页，传入一个订单详情的id
     * @author jiangxiangwen
     * @date 2018/3/11
     * @param
     * @return
     *
     */
    public String logisticsPage(){
         req.setAttribute("orderDetailId","1");
        // 获得订单详情的 id
        String orderDetailId= (String) req.getAttribute("orderDetailId");
        // 查询出物流信息
        LogisticsInfo logisticsInfo = logisticsInfoService.findLogisticsInfoByOrderDetailId(Long.valueOf(orderDetailId));
        if (logisticsInfo!=null) {
            // 查询出物流过程
            List<LogisticsGoby> gobyList = logisticsGobyService.findLogisticsGobyLogisticsnfoId(logisticsInfo.getId());

            req.setAttribute("logisticsInfo", logisticsInfo);
            req.setAttribute("gobyList", gobyList);

        }
        return "logisticsPage";
    }

    /**
     * @Title: addLogistics
     * @Description: 添加物流信息，需要传入一个订单详情的id
     * @author jiangxiangwen
     * @date 2018/3/11
     * @param
     * @return
     *
     */
    public void addLogistics() throws IOException {
        // 获取表单提交过来的数据
        String deliverName=req.getParameter("deliver_name");
        String deliverPhone=req.getParameter("deliver_phone");
        String deliverddress=req.getParameter("deliver_address");
        String consigneeName=req.getParameter("consignee_name");
        String consigneePhone=req.getParameter("consignee_phone");
        String consigneeAddress=req.getParameter("consignee_address");
        // 将拿到的数据放入物流信息实体类
        LogisticsInfo logisticsInfo=new LogisticsInfo();
        logisticsInfo.setDeliverName(deliverName);
        logisticsInfo.setDeliverPhone(deliverPhone);
        logisticsInfo.setDeliverAddress(deliverddress);
        logisticsInfo.setConsigneeName(consigneeName);
        logisticsInfo.setDeliverPhone(consigneePhone);
        logisticsInfo.setDeliverAddress(consigneeAddress);
        // 传入serivce层
        Integer row=logisticsInfoService.saveLogisticsInfo(logisticsInfo);
        PrintWriter out = resp.getWriter();
        HashMap<String,String> hashMap=new HashMap<String, String>();
        Gson gson=new Gson();
        if(row==null||row==0){
            hashMap.put("MESSAGE","添加失败");
            out.print(gson.toJson(hashMap));
        }
        else {
            hashMap.put("MESSAGE","添加成功");
            out.print(gson.toJson(hashMap));
        }
        out.flush();
        out.close();
    }
}



