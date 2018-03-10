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
     * @Title: findMainPageInvertoryAll
     * @Description: 查询所有订单的价格，数量，以及商品的ID
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageInvertoryAll();

    /**
     * @Title: findMainPageInvertory
     * @Description: 查询指定订单的价格，数量，以及商品的ID
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageInvertory(Long start, Long end);

    /**
     * @Title: findMainPageCondition
     * @Description: 根据条件查询主页面的显示
     * @author kang
     * @date 2018-03-06
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageCondition(String condition);

    /**
     * @Title: findMainPageByStoreId
     * @Description: 根据商品id查找商品信息
     * @author hzq
     * @date 2018-03-06
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageByStoreId(Long storeId);

    /**
     * @param type 商品类型
     * @Title: findMainPageClassify
     * @Description: 分类查询
     * @author kang
     * @date 2018-03-10
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageClassify(Byte type);
}
