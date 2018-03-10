package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author liukang
 * @date 2018/1/20 17:01
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.PayFlow;

import java.util.List;
import java.util.Map;


/**
 * @author liukang
 * @InterfaceName PayFlowService
 * @Description 流水接口
 * @date 2018/1/20
 */
public interface PayFlowService {

    /**
     * @Title: findPayFlowById
     * @Description: 通过id查找流水信息
     * @author liukang
     * @date 2018-01-24
     * @param: id 指定id
     * @return: 流水信息
     */

    public PayFlow findPayFlowById(Long id);

    /**
     * @Title: findPayFlowById
     * @Description: 通过流水号查ID
     * @author liukang
     * @date 2018-01-24
     * @param: id 指定id
     * @return: 流水信息
     */

    public PayFlow findPayFlowByFlowNum(String flowNum) throws RuntimeException;

    /**
     * @Title: savePayFlow
     * @Description: 保存流水信息
     * @author liukang
     * @date 2018-01-24
     * @param: payFlow 流水信息
     * @return: 受影响行数
     */

    public int savePayFlow(PayFlow payFlow);

    /**
     * @param peopleId
     * @Title: MonthConsumption
     * @Description: 指定人员的当月消费情况
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> MonthConsumption(Long peopleId);

    /**
     * @Title: MonthEarnings
     * @Description: 指定卖家的本月盈利
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> MonthEarnings(Long storeId);

    /**
     * @Title: YearConsumption
     * @Description: 指定买家的本年消费
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> YearConsumption(Long peopleId);

    /**
     * @Title: YearEarnings
     * @Description: 指定卖家的本年盈利
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> YearEarnings(Long storeId);

}