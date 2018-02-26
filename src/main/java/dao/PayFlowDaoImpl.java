package dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package dao
 * @author liukang
 * @date 2018/1/20 17:19
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.base.BaseDaoImpl;
import domain.PayFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import service.PayFlowService;
import tools.TimeFormat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liukang
 * @ClassName PayFlowDaoImpl
 * @Description 流水表SQL的实现
 * @date 2018/1/20
 */
@Repository("payFlowDao")
public class PayFlowDaoImpl extends BaseDaoImpl<PayFlow> implements PayFlowDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PayFlowService payFlowService;

    @Autowired
    private StoreDao storeDao;

    //当前系统时间，并设置成年月日格式
    public static java.util.Date date = new java.util.Date();
    public static TimeFormat timeFormat = new TimeFormat(date);
    public static String timeStr = timeFormat.format("yyyy-MM-dd");
    //数据库处理

    /**
     * @Title: findPayFlowById
     * @Description: 流水表的ID查询实现
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public PayFlow findPayFlowById(Long id) throws SQLException {
        ResultSet resultSet = null;
        String findSql = "SELECT ID,FLOW_NUM,PEOPLE_ID,MONEY,FLOW_TYPE,CREATE_TIME,ORDER_DETALL_ID,GOODS_ORDER_ID FROM PayFlow WHERE ID=?;";
        List<PayFlow> payFlows = jdbcTemplate.query(findSql, new ResultSetExtractor<List<PayFlow>>() {
            @Override
            public List<PayFlow> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<PayFlow> payFlows = new ArrayList<PayFlow>();
                while (resultSet.next()) {
                    PayFlow payFlow1 = new PayFlow();
                    payFlow1.setPeopleId(resultSet.getLong(1));
                    payFlow1.setFlowNum(resultSet.getString(2));
                    payFlow1.setPeopleId(resultSet.getLong(3));
                    payFlow1.setMoney(resultSet.getDouble(4));
                    payFlow1.setFlowType(resultSet.getByte(5));
                    payFlow1.setCrateTime(resultSet.getDate(6));
                    payFlow1.setOrderDetailId(resultSet.getLong(7));
                    payFlow1.setGoodsOrderId(resultSet.getLong(8));
                    payFlows.add(payFlow1);
                }
                return payFlows;
            }
        }, id);
        return payFlows.get(0);
    }

    /**
     * @param flowNum 流水号
     * @Title: findPayFlowByPayFlowNum
     * @Description: 通过流水号查询流水表
     * @author kang
     * @date 2018-02-06
     * @throw YnCorpSysException
     */
    @Override
    public PayFlow findPayFlowByFlowNum(String flowNum) throws SQLException {
        ResultSet resultSet = null;
        String findSql = "SELECT ID,FLOW_NUM,PEOPLE_ID,MONEY,FLOW_TYPE,CREATE_TIME,ORDER_DETALL_ID,GOODS_ORDER_ID FROM PayFlow WHERE ID=?;";
        List<PayFlow> payFlows = jdbcTemplate.query(findSql, new ResultSetExtractor<List<PayFlow>>() {
            @Override
            public List<PayFlow> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<PayFlow> payFlows = new ArrayList<PayFlow>();
                while (resultSet.next()) {
                    PayFlow payFlow1 = new PayFlow();
                    payFlow1.setPeopleId(resultSet.getLong(1));
                    payFlow1.setFlowNum(resultSet.getString(2));
                    payFlow1.setPeopleId(resultSet.getLong(3));
                    payFlow1.setMoney(resultSet.getDouble(4));
                    payFlow1.setFlowType(resultSet.getByte(5));
                    payFlow1.setCrateTime(resultSet.getDate(6));
                    payFlow1.setOrderDetailId(resultSet.getLong(7));
                    payFlow1.setGoodsOrderId(resultSet.getLong(8));
                    payFlows.add(payFlow1);
                }
                return payFlows;
            }
        }, flowNum);
        return payFlows.get(0);
    }


    /**
     * @Title: savePayFlow
     * @Description: 流水表的插入的实现
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public Long savePayFlow(PayFlow payFlow) throws SQLException {
        this.sqlSessionTemplate.insert(getMybaitsNameSpace() + "add", payFlow);
        return null;
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
    public List<Map<String, Object>> MonthConsumption(Long peopleId) throws SQLException {
        String selectSQL = "SELECT SUM(MONEY) FROM PAY_FLOW WHERE PEOPLE_ID=" +
                peopleId + " AND FLOW_TYPE=1 AND CREATE_TIME LIKE '" + timeStr.substring(0, 6) + "%';";
        List<Map<String, Object>> rs = jdbcTemplate.queryForList(selectSQL);
        return rs;
    }

    /**
     * @Title: MonthEarnings
     * @Description: 指定卖家的本月盈利
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<Map<String, Object>> MonthEarnings(Long storeId) throws SQLException {
        Long peopleId = storeDao.findStoreById(storeId).get(0).getPeopleId();
        String selectSQL = "SELECT SUM(MONEY) FROM PAY_FLOW WHERE PEOPLE_ID=" + peopleId +
                " AND FLOW_TYPE=2 AND CREATE_TIME LIKE '" + timeStr.substring(0, 6) + "%';";
        List<Map<String, Object>> rs = jdbcTemplate.queryForList(selectSQL);
        return rs;
    }

    /**
     * @Title: YearConsumption
     * @Description: 指定买家的本年消费
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<Map<String, Object>> YearConsumption(Long peopleId) throws SQLException {
        String selectSQL = "SELECT SUM(MONEY) FROM PAY_FLOW WHERE PEOPLE_ID=" + peopleId +
                " AND FLOW_TYPE=1 AND CREATE_TIME LIKE '" + timeStr.substring(0, 3) + "%';";
        List<Map<String, Object>> rs = jdbcTemplate.queryForList(selectSQL);
        return rs;
    }

    /**
     * @Title: YearEarnings
     * @Description: 指定卖家的本年盈利
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<Map<String, Object>> YearEarnings(Long storeId) throws SQLException {
        Long peopleId = storeDao.findStoreById(storeId).get(0).getPeopleId();
        String selectSQL = "SELECT SUM(MONEY) FROM PAY_FLOW WHERE PEOPLE_ID=" + peopleId +
                " AND FLOW_TYPE=1 AND CREATE_TIME LIKE '" + timeStr.substring(0, 3) + "%';";
        List<Map<String, Object>> rs = jdbcTemplate.queryForList(selectSQL);
        return rs;
    }

}