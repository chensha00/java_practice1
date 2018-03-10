package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author liukang
 * @date 2018/1/20 17:02
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import dao.PayFlowDao;
import domain.PayFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author liukang
 * @ClassName PayFlowServiceImpl
 * @Description PayFlowService流水接口的实现
 * @date 2018/1/20
 */
@Service ("payFlowService")
@Transactional
public class PayFlowServiceImpl implements PayFlowService {

    @Autowired
    private PayFlowDao payFlowDao;

    @Autowired
    private PayFlowService payFlowService;


    /**
     * @Title: findPayFlowById
     * @Description: 通过id查找流水信息
     * @author liukang
     * @date 2018-01-24
     * @param: id 指定id
     * @return: 流水信息
     */
    @Override
    public PayFlow findPayFlowById(Long id) {
        PayFlow payFlow = null;
        payFlow = payFlowDao.findPayFlowById(id);

            //返回流水对象
//            if (payFlow != null) {
//                payFlow.setPeople(.findPeopleById(payFlow.getPeopleId()));
//                payFlow.setOrderDetail(new OrderDetailServiceImpl().findOrderDetailById(payFlow.getOrderDetailId()));
//
        return payFlow;

    }


    /**
     * @Title: findPayFlowById
     * @Description: 通过流水号查ID
     * @author liukang
     * @date 2018-01-24
     * @param: id 指定id
     * @return: 流水信息
     */
    @Override
    public PayFlow findPayFlowByFlowNum(String flowNum) throws RuntimeException {
        PayFlow payFlow = null;

        try {
            payFlow = payFlowDao.findPayFlowByFlowNum(flowNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payFlow;
    }


    /**
     * @Title: savePayFlow
     * @Description: 保存流水信息
     * @author liukang
     * @date 2018-01-24
     * @param: payFlow 流水信息
     * @return: 受影响行数
     */

    @Override
    public int savePayFlow(PayFlow payFlow) {
        int number = 0;

        number = payFlowDao.savePayFlow(payFlow);


            //受影响行数
        return number;

    }

    /**
     * @param peopleId
     * @Title: MonthConsumption
     * @Description: 指定人员的当月消费情况
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<Map<String, Object>> MonthConsumption(Long peopleId) {
        List<Map<String, Object>> rs = null;
        try {
            rs = payFlowDao.MonthConsumption(peopleId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //受影响行数
            return rs;
        }
    }

    /**
     * @Title: MonthEarnings
     * @Description: 指定卖家的本月盈利
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<Map<String, Object>> MonthEarnings(Long storeId) {
        List<Map<String, Object>> rs = null;
        try {
            rs = payFlowDao.MonthConsumption(storeId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //受影响行数
            return rs;
        }
    }

    /**
     * @Title: YearConsumption
     * @Description: 指定买家的本年消费
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<Map<String, Object>> YearConsumption(Long peopleId) {
        List<Map<String, Object>> rs = null;
        try {
            rs = payFlowDao.MonthConsumption(peopleId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //受影响行数
            return rs;
        }
    }

    /**
     * @Title: YearEarnings
     * @Description: 指定卖家的本年盈利
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<Map<String, Object>> YearEarnings(Long storeId) {
        List<Map<String, Object>> rs = null;
        try {
            rs = payFlowDao.MonthConsumption(storeId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //受影响行数
            return rs;
        }
    }
}

