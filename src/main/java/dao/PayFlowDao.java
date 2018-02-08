package dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package dao
 * @author liukang
 * @date 2018/1/20 17:19
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.PayFlow;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author liukang
 * @InterfaceName PayFlowDao
 * @Description 流失表SQL
 * @date 2018/1/20
 */
public interface PayFlowDao {


    /**
     * @Title: findPayFlowById
     * @Description: 流水表的ID查询
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public PayFlow findPayFlowById(Long id) throws SQLException;

    /**
     * @param flowNum 流水号
     * @Title: findPayFlowByPayFlowNum
     * @Description: 通过流水号查询流水表
     * @author kang
     * @date 2018-02-06
     * @throw YnCorpSysException
     */
    public PayFlow findPayFlowByFlowNum(String flowNum) throws SQLException;


    /**
     * @param payFlow
     * @Title: savePayFlow
     * @Description: 流水表的插入
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public Long savePayFlow(PayFlow payFlow) throws SQLException;

    /**
     * @param peopleId
     * @Title: MonthConsumption
     * @Description: 指定人员的当月消费情况
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> MonthConsumption(Long peopleId) throws SQLException;

    /**
     * @Title: MonthEarnings
     * @Description: 指定卖家的本月盈利
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> MonthEarnings(Long storeId) throws SQLException;

    /**
     * @Title: YearConsumption
     * @Description: 指定买家的本年消费
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> YearConsumption(Long peopleId) throws SQLException;

    /**
     * @Title: YearEarnings
     * @Description: 指定卖家的本年盈利
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> YearEarnings(Long storeId) throws SQLException;

}