package service; /**
 * @Project: zyht_web
 * @Package service
 * @author jiangxiangwen
 * @date 2018/3/4
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName LogisticsInfo
 * @Description 类的描述
 * @date 2018/3/4
 */
public interface LogisticsInfoService {

    /**
     * @Title: findLogisticsInfoByOrderDetailId
     * @Description: 通过传入orderDetailId（订单详情 主键id）查询物流信息实体
     * @author jiangxiangwen
     * @date 2018/3/3
     * @param OrderDetailId 订单详情 主键id
     * @return LogisticsInfo 物流信息实体
     *
     */
    public domain.LogisticsInfo findLogisticsInfoByOrderDetailId(Long OrderDetailId);

    /**
     * @Title: findLogisticsInfoAll
     * @Description: 查询所有的物流信息
     * @author jiangxiangwen
     * @date 2018/3/3
     * @param
     * @return List<LogisticsInfo> 物流信息实体的集合
     *
     */
    public List<domain.LogisticsInfo> findLogisticsInfoAll();

    /**
     * @Title: saveLogisticsInfo
     * @Description: 添加物流信息实体
     * @author jiangxiangwen
     * @date 2018/3/3
     * @param logisticsInfo 物流信息实体
     * @return Integer 返回受影响的行数
     *
     */
    public Integer saveLogisticsInfo(domain.LogisticsInfo logisticsInfo);

    /**
     * @Title: deleteLogisticsInfoById
     * @Description: 删除物流信息
     * @author jiangxiangwen
     * @date 2018/3/3
     * @param logisticsInfo 主键id
     * @return Integer 受影响的行数
     *
     */
    public Integer deleteLogisticsInfoById(domain.LogisticsInfo logisticsInfo);

    /**
     * @Title: updateLogisticsInfoByOrderDetailId
     * @Description: 更新物流信息
     * @author jiangxiangwen
     * @date 2018/3/3
     * @param logisticsInfo 物流信息实体
     * @return Integer 受影响的行数
     *
     */
    public Integer updateLogisticsInfoByOrderDetailId(domain.LogisticsInfo logisticsInfo);
}
