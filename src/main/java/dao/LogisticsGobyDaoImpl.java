package dao; /**
 * @Project: zyht_web
 * @Package dao
 * @author jiangxiangwen
 * @date 2018/3/4
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import common.util.base.BaseDaoImpl;
import domain.LogisticsGoby;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName LogisticsGobyDaoImpl
 * @Description 类的描述
 * @date 2018/3/4
 */
@Repository("logisticsGobyDaoImpl")
public class LogisticsGobyDaoImpl extends BaseDaoImpl<LogisticsGoby> implements LogisticsGobyDao {
    /**
     * @param logisticsInfoId 物流信息 主键id
     * @return List<LogisticsGoby.xml> 返回物流过程的集合
     * @Title: findLogisticsGobyLogisticsnfoId
     * @Description: 通过传入 logisticsInfoId（物流信息 主键id）查询物流过程实体
     * @author jiangxiangwen
     * @date 2018/3/3
     */
    @Override
    public List<LogisticsGoby> findLogisticsGobyLogisticsnfoId(Long logisticsInfoId) {
        LogisticsGoby logisticsGoby=new LogisticsGoby();
        logisticsGoby.setLogisticsnfoId(logisticsInfoId);
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"findLogisticsGobyLogisticsnfoId",logisticsGoby);
    }

    /**
     * @param logisticsGoby 物流过程实体
     * @return Integer 返回受影响的行数
     * @Title: saveLogisticsGoby
     * @Description: 添加物流过程实体
     * @author jiangxiangwen
     * @date 2018/3/3
     */
    @Override
    public Integer saveLogisticsGoby(LogisticsGoby logisticsGoby) {
        return this.sqlSessionTemplate.insert(getMybaitsNameSpace()+"saveLogisticsGoby",logisticsGoby);
    }

    /**
     * @param logisticsGoby 物流过程实体
     * @return Integer 受影响的行数
     * @Title: deleteLogisticsGobyById
     * @Description: 删除物流过程
     * @author jiangxiangwen
     * @date 2018/3/3
     */
    @Override
    public Integer deleteLogisticsGobyById(LogisticsGoby logisticsGoby) {
        return this.sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteLogisticsGobyById",logisticsGoby);
    }

    /**
     * @param logisticsGoby 物流信息实体
     * @return Integer 受影响的行数
     * @Title: updateLogisticsGobyId
     * @Description: 更新物流信息
     * @author jiangxiangwen
     * @date 2018/3/3
     */
    @Override
    public Integer updateLogisticsGobyId(LogisticsGoby logisticsGoby) {
        return this.sqlSessionTemplate.update(getMybaitsNameSpace()+"updateLogisticsGobyId",logisticsGoby);
    }

    //测试
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        LogisticsGobyDaoImpl logisticsGobyDaoImpl = (LogisticsGobyDaoImpl) applicationContext.getBean("logisticsGobyDaoImpl");
        List<LogisticsGoby> logisticsGobyLogisticsnfoId = logisticsGobyDaoImpl.findLogisticsGobyLogisticsnfoId(1l);


    }
}
