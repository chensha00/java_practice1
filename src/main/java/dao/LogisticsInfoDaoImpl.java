package dao; /**
 * @Project: zyht_web
 * @Package dao
 * @author jiangxiangwen
 * @date 2018/3/3
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import common.util.base.BaseDaoImpl;
import domain.LogisticsInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName LogisticsInfoDaoImpl
 * @Description 类的描述
 * @date 2018/3/3
 */
@Repository("LogisticsInfoDao")
public class LogisticsInfoDaoImpl extends BaseDaoImpl<LogisticsInfo> implements LogisticsInfoDao {
    /**
     * @param OrderDetailId 订单详情 主键id
     * @return LogisticsInfo 物流信息实体
     * @Title: findLogisticsInfoByOrderDetailId
     * @Description: 通过传入orderDetailId（订单详情 主键id）查询物流信息实体
     * @author jiangxiangwen
     * @date 2018/3/3
     */
    @Override
    public LogisticsInfo findLogisticsInfoByOrderDetailId(Long OrderDetailId) {
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"findLogisticsInfoByOrderDetailId",OrderDetailId);
    }

    /**
     * @return List<LogisticsInfo> 物流信息实体的集合
     * @Title: findLogisticsInfoAll
     * @Description: 查询所有的物流信息
     * @author jiangxiangwen
     * @date 2018/3/3
     */
    @Override
    public List<LogisticsInfo> findLogisticsInfoAll() {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"findLogisticsInfoAll");
    }

    /**
     * @param logisticsInfo 物流信息实体
     * @return Integer 返回受影响的行数
     * @Title: saveLogisticsInfo
     * @Description: 添加物流信息实体
     * @author jiangxiangwen
     * @date 2018/3/3
     */
    @Override
    public Integer saveLogisticsInfo(LogisticsInfo logisticsInfo) {
        return this.sqlSessionTemplate.insert(getMybaitsNameSpace()+"saveLogisticsInfo",logisticsInfo);
    }

    /**
     * @param logisticsInfo 物流信息实体
     * @return Integer 受影响的行数
     * @Title: deleteLogisticsInfoById
     * @Description: 删除物流信息
     * @author jiangxiangwen
     * @date 2018/3/3
     */
    @Override
    public Integer deleteLogisticsInfoById(LogisticsInfo logisticsInfo) {
        return this.sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteLogisticsInfoById",logisticsInfo);
    }

    /**
     * @param logisticsInfo 物流信息实体
     * @return Integer 受影响的行数
     * @Title: updateLogisticsInfoByOrderDetailId
     * @Description: 更新物流信息
     * @author jiangxiangwen
     * @date 2018/3/3
     */
    @Override
    public Integer updateLogisticsInfoByOrderDetailId(LogisticsInfo logisticsInfo) {
        return this.sqlSessionTemplate.update(getMybaitsNameSpace()+"updateLogisticsInfoByOrderDetailId",logisticsInfo);
    }

    //本地测试
//    public static void main(String[] args) {
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//        LogisticsInfoDaoImpl logisticsInfoDao= (LogisticsInfoDaoImpl)applicationContext.getBean("LogisticsInfoDao");
////        List<LogisticsInfo> logisticsInfo=logisticsInfoDao.findLogisticsInfoAll();
//        LogisticsInfo logisticsInfo=new LogisticsInfo();
//        logisticsInfo.setLogisticsNum("78987545647875");
//        logisticsInfo.setOrderDetailId(1l);
//        logisticsInfo.setDeliverName("壮士");
//        logisticsInfo.setDeliverPhone("13334555977");
//        logisticsInfo.setDeliverAddress("weizhi");
//        logisticsInfo.setId(3l);
//        logisticsInfoDao.updateLogisticsInfoByOrderDetailId(logisticsInfo);
//    }
}
