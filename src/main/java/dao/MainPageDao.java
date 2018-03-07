package dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package dao
 * @author kang
 * @date 2018/3/1 8:58
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import Entity.MainPage;

import java.util.List;

/**
 * @author kang
 * @InterfaceName MainPageDao
 * @Description 接口描述
 * @date 2018/3/1
 */
public interface MainPageDao {
    /**
     * @Title: findMainPageInvertory
     * @Description: 查询所有订单的价格，数量，以及商品的ID
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageInvertory();

    /**
     * @Title: findMainPageCondition
     * @Description: 根据条件查询主页面的显示
     * @author kang
     * @date 2018-03-06
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageCondition(String condition);

}
