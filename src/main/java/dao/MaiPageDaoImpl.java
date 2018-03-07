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

import java.util.List;

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
    public List<MainPage> findMainPageInvertory() {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findMainPageInvertory");
    }

    @Override
    public List<MainPage> findMainPageCondition(String condition) {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findMainPageCondition", condition);
    }


}