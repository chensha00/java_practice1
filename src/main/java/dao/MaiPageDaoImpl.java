package dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package dao
 * @author kang
 * @date 2018/3/1 8:59
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import Entity.MainPage;
import common.util.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kang
 * @ClassName MaiPageDaoImpl
 * @Description 类描述
 * @date 2018/3/1
 */
@Repository("MainPageDao")
public class MaiPageDaoImpl extends BaseDaoImpl<MainPage> implements MainPageDao {

    /**
     * @Title: findMainPageInvertory
     * @Description: 查询所有订单的价格，数量，以及商品的ID
     * @author liukang
     * @date
     * @throw SQLException
     */
    @Override
    public List<MainPage> findMainPageInvertoryAll() {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findMainPageInvertoryAll");
    }

    /**
     * @Title: findMainPageInvertory
     * @Description: 查询指定订单的价格，数量，以及商品的ID
     * @author liukang
     * @date
     * @throw SQLException
     */
    @Override
    public List<MainPage> findMainPageInvertory(Long start,Long end) {
        Map map = new HashMap();
        map.put("start",start);
        map.put("end", end);
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findMainPageInvertory",map);
    }

    /**
     * @Title: findMainPageCondition
     * @Description: 根据条件查询主页面的显示
     * @author kang
     * @date 2018-03-08
     * @throw YnCorpSysException
     */
    @Override
    public List<MainPage> findMainPageCondition(String condition) {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findMainPageCondition", condition);
    }



}