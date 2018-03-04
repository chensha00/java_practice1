package servlet; /**
 * @Project: zyht_web
 * @Package servlet
 * @author jiangxiangwen
 * @date 2018/3/4
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import common.util.SpringContextUtil;
import domain.LogisticsGoby;
import domain.LogisticsInfo;
import service.LogisticsGobyServiceImpl;
import service.LogisticsInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName LogisticsServlet
 * @Description 物流详情
 * @date 2018/3/4
 */
public class LogisticsServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

        //转发
        req.getRequestDispatcher("/logistics_page.jsp").forward(req,resp);

    }
}
