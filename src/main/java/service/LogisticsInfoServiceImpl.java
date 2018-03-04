package service; /**
 * @Project: zyht_web
 * @Package service
 * @author jiangxiangwen
 * @date 2018/3/4
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import dao.LogisticsInfoDao;
import domain.LogisticsInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName LogisticsInfoServiceImpl
 * @Description 类的描述
 * @date 2018/3/4
 */
public class LogisticsInfoServiceImpl implements LogisticsInfoService {

    @Autowired
    private LogisticsInfoDao logisticsInfoDao;

    /**
     * @param orderDetailId 订单详情 主键id
     * @return LogisticsInfo 物流信息实体
     * @Title: findLogisticsInfoByOrderDetailId
     * @Description: 通过传入orderDetailId（订单详情 主键id）查询物流信息实体
     * @author jiangxiangwen
     * @date 2018/3/3
     */
    @Override
    public LogisticsInfo findLogisticsInfoByOrderDetailId(Long orderDetailId) {
        return logisticsInfoDao.findLogisticsInfoByOrderDetailId(orderDetailId);
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
        return logisticsInfoDao.findLogisticsInfoAll();
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
        return logisticsInfoDao.saveLogisticsInfo(logisticsInfo);
    }

    /**
     * @param logisticsInfo 主键id
     * @return Integer 受影响的行数
     * @Title: deleteLogisticsInfoById
     * @Description: 删除物流信息
     * @author jiangxiangwen
     * @date 2018/3/3
     */
    @Override
    public Integer deleteLogisticsInfoById(LogisticsInfo logisticsInfo) {
        return logisticsInfoDao.deleteLogisticsInfoById(logisticsInfo);
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
        return logisticsInfoDao.updateLogisticsInfoByOrderDetailId(logisticsInfo);
    }
}
