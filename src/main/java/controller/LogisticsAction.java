package controller; /**
 * @Project: zyht_web
 * @Package controller
 * @author jiangxiangwen
 * @date 2018/3/6
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import common.util.SpringContextUtil;
import common.util.base.BaseAction;
import domain.LogisticsGoby;
import domain.LogisticsInfo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import service.LogisticsGobyServiceImpl;
import service.LogisticsInfoServiceImpl;

import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName LogisticsAction
 * @Description 物流详情
 * @date 2018/3/6
 */
@Action( value = "logisticsAction")

@Results({
        @Result( name="logisticsPage",location="/logistics_page.jsp"),
})
public class LogisticsAction extends BaseAction {

    public String logisticsPage(){
         req.setAttribute("orderDetailId","1");
        // 获得订单详情的 id
        String orderDetailId= (String) req.getAttribute("orderDetailId");
        // 查询出物流信息
        LogisticsInfoServiceImpl logisticsInfoService= (LogisticsInfoServiceImpl) SpringContextUtil.getBean("logisticsInfoService");
        LogisticsInfo logisticsInfo = logisticsInfoService.findLogisticsInfoByOrderDetailId(Long.valueOf(orderDetailId));
        // 查询出物流过程
        LogisticsGobyServiceImpl logisticsGobyService= (LogisticsGobyServiceImpl) SpringContextUtil.getBean("logisticsGobyService");
        List<LogisticsGoby> gobyList=logisticsGobyService.findLogisticsGobyLogisticsnfoId(logisticsInfo.getId());

            req.setAttribute("logisticsInfo",logisticsInfo);
            req.setAttribute("gobyList",gobyList);
        return "logisticsPage";
    }
}