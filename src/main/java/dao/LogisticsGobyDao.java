package dao; /**
 * @Project: zyht_web
 * @Package dao
 * @author jiangxiangwen
 * @date 2018/3/4
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import domain.LogisticsGoby;

import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName LogisticsGobyDao
 * @Description 物流过程表数据库操作接口
 * @date 2018/3/4
 */
public interface LogisticsGobyDao {
    /**
     * @Title: findLogisticsGobyLogisticsnfoId
     * @Description: 通过传入 logisticsInfoId（物流信息 主键id）查询物流过程实体
     * @author jiangxiangwen
     * @date 2018/3/3
     * @param logisticsInfoId 物流信息 主键id
     * @return List<LogisticsGoby.xml> 返回物流过程的集合
     *
     */
    public  List<LogisticsGoby> findLogisticsGobyLogisticsnfoId(Long logisticsInfoId);

    /**
     * @Title: saveLogisticsGoby
     * @Description: 添加物流过程实体
     * @author jiangxiangwen
     * @date 2018/3/3
     * @param logisticsGoby 物流过程实体
     * @return Integer 返回受影响的行数
     *
     */
    public Integer saveLogisticsGoby(LogisticsGoby logisticsGoby);

    /**
     * @Title: deleteLogisticsGobyById
     * @Description: 删除物流过程
     * @author jiangxiangwen
     * @date 2018/3/3
     * @param logisticsGoby 物流过程实体
     * @return Integer 受影响的行数
     *
     */
    public Integer deleteLogisticsGobyById(LogisticsGoby logisticsGoby);

    /**
     * @Title: updateLogisticsGobyId
     * @Description: 更新物流信息
     * @author jiangxiangwen
     * @date 2018/3/3
     * @param logisticsGoby 物流信息实体
     * @return Integer 受影响的行数
     *
     */
    public Integer updateLogisticsGobyId(LogisticsGoby logisticsGoby);
}
