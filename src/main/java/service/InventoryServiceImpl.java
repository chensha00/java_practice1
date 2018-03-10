package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author liukang
 * @date 2018/1/25 16:59
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import Entity.MainPage;
import dao.InventoryDao;
import dao.MainPageDao;
import domain.Goods;
import domain.Inventory;
import domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.GoodsException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author liukang
 * @ClassName inventoryServiceImpl
 * @Description 库存操作类实现 inventoryService
 * @date 2018/1/25
 */
@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDao inventoryDao;

    @Autowired
    private MainPageDao mainPageDao;

    /**
     * @Title: saveInventory
     * @Description: 保存库存信息
     * @author yanyong
     * @date 2018-01-25
     * @param: inventory 库存对象
     * @return: 受影响行数
     */
    @Override
    public Integer saveInventory(Inventory inventory) {

        Integer number = 0;

        number = inventoryDao.saveInventory(inventory);

        return number;

    }

    /**
     * @Title: findInventoryById
     * @Description: 查找库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 库存对象
     */
    @Override
    public Inventory findInventoryById(Long id) {

        Inventory inventory = inventoryDao.findInventoryById(id);

        return inventory;
    }


    /**
     * @Title: deleteInventoryById
     * @Description: 删除库存信息 通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 受影响行数
     */
    @Override
    public Integer deleteInventoryById(Long id) {
        Integer number = 0;
        try {
            number = inventoryDao.deleteInventoryById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //返回受影响行数
            return number;
        }
    }

    /**
     * @Title: updateInventorById
     * @Description: 更新库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @param: inventory 库存对象
     * @return: 受影响行数
     */

    @Override
    public Integer updateInventorById(Long id, Inventory inventory) {
        Integer number = 0;
        Inventory oldinventory = this.findInventoryById(id);
        if (inventory.getPrice() != null) {
            oldinventory.setPrice(inventory.getPrice());
        }
        if (inventory.getNumber() != null) {
            oldinventory.setNumber(inventory.getNumber());
        }
        try {
            number = inventoryDao.updateInventorById(id, oldinventory);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //返回受影响行数
            return number;
        }
    }

    /**
     * @Title: showInventory
     * @Description: 查看库存信息
     * @author yanyong
     * @date 2018-01-26
     * @throw YnCorpSysException
     * @param: 库存对象
     */
    public void showInventory(Inventory inventory) {
        System.out.println("主键ID：" + inventory.getId());
        System.out.println("店铺ID：" + inventory.getStoreId());
        System.out.println("商品ID：" + inventory.getGoodsId());
        System.out.println("价格：" + inventory.getPrice());
        System.out.println("数量：" + inventory.getNumber());
    }

    /**
     * @Title: changeGoodsNumberById
     * @Description: 修改指定id的商品数量
     * @author yanyong
     * @date 2018-01-22
     * @param: id 指定id
     * @param: number 商品数量
     * @return: 修改行数
     */
    @Override
    public Integer changeGoodsNumberById(Long id, Double number) {
        Inventory inventory = new Inventory();
        Integer num = 0;
        inventory.setNumber(number);
        num = this.updateInventorById(id, inventory);
        return num;
    }


    /**
     * @Title: stock
     * @Description: 商品进货
     * @author yanyong
     * @date 2018-01-22
     * @param: store 指定商铺
     * @param: goods 进货的商品
     * @param: addNum 进货的数量
     * @param: price 进货后设定卖价
     * @return: 受影响行数
     */
    @Override
    public Integer stock(Store store, Goods goods, Double addNum, Double price) {
        Inventory inventory = this.findInventoryById(goods.getId());
        if (inventory != null) {
            Integer number = this.changeGoodsNumberById(goods.getId(), inventory.getNumber() + addNum);
            return number;
        } else {
            return 0;
        }
    }

    /**
     * @Title: sale
     * @Description: 出售商品
     * @author yanyong
     * @date 2018-01-22
     * @param: id 对指定id的商品出售
     * @param: saleNum 出售数量
     * @return: 受影响行数
     */
    @Override
    public Integer sale(Long id, Double saleNum) throws GoodsException {
        Inventory inventory = this.findInventoryById(id);
        Integer number = 0;
        if (inventory == null) {
            throw new GoodsException("商品不存在");
        } else {
            if (inventory.getNumber() < saleNum) {
                throw new GoodsException("商品数量不够，无法售卖");
            } else {
                number = this.changeGoodsNumberById(id, inventory.getNumber() - saleNum);
                return number;
            }
        }
    }

    /**
     * @Title: calculationMoney
     * @Description: 计算商品金额
     * @author yanyong
     * @date 2018-01-22
     * @param: goods 商品
     * @param: num 数量
     * @return: 计算金额
     */
    public Double calculationMoney(Inventory inventory, Double num) {
        return inventory.getPrice() * num;
    }

    /**
     * @Title: judgeNumberIsEnough
     * @Description: 判断数量是否足够
     * @author yanyong
     * @date 2018-01-23
     * @param: id 指定id
     * @param: needNumber 需要数量
     * @return: 数量是否足够，false--否，true--是
     */
    @Override
    public Boolean judgeNumberIsEnough(Long id, Double needNumber) {
        Inventory inventory = this.findInventoryById(id);
        if (inventory.getNumber() >= needNumber) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param storeId:商铺id
     * @param goodsId：商铺id
     * @Title: findInventoryByStoreIdAndGoodId
     * @Description: 根据商铺id和商铺id查找库存信息
     * @author hzq
     * @date 2018-01-26
     * @throw RuntimeException
     */
    public Inventory findInventoryByStoreIdAndGoodsId(Long storeId, Long goodsId) throws SQLException {
        Inventory inventory = null;

        inventory = inventoryDao.findInventoryByStoreIdAndGoodsId(storeId, goodsId);

        return inventory;
    }

    /**
     * @param storeId:商铺id
     * @Title: findMainPageByStoreId
     * @Description: 根据商铺id和商铺id查找库存信息
     * @author hzq
     * @date 2018-01-26
     * @throw RuntimeException
     */
    public List<MainPage> findMainPageByStoreId(Long storeId) {
        List<MainPage> mainPages = new ArrayList<MainPage>();

        mainPages = mainPageDao.findMainPageByStoreId(storeId);

        return mainPages;
    }


    /**
     * @param map 条件和值对应key和value
     * @Title: findInventoryByUnSureCondition
     * @Description: 通过商铺id查找库存信息
     * @author hzq
     * @date 2018/01/30
     * @throw SQLException
     */
    @Override
    public List<Inventory> findInventoryByUnSureCondition(List<Map<String, Object>> map) throws SQLException {
        List<Inventory> inventory = null;
        try {
            inventory = inventoryDao.findInventoryByUnSureCondition(map);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return inventory;
        }
    }

    /**
     * @Title: findMainPageInventory
     * @Description: 查询所有订单的价格，数量，以及商品的ID
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<MainPage> findMainPageInventory(Long start,Long end) {
        List<MainPage> mainPages = new ArrayList<MainPage>();

        mainPages = mainPageDao.findMainPageInventory(start, end);

        return mainPages;

    }

    /**
     * @Title: findMainPageCondition
     * @Description: 根据条件查询主页面的显示
     * @author kang
     * @date 2018-03-06
     * @throw YnCorpSysException
     */
    @Override
    public List<MainPage> findMainPageCondition(String condition) {
        List<MainPage> mainPages = new ArrayList<MainPage>();

        mainPages = mainPageDao.findMainPageCondition(condition);

        return mainPages;
    }

    /**
     * @Title: findInventoryById
     * @Description: 查找库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 库存对象
     */
    @Override
    public List<Inventory> findInventoryAll(){
        return inventoryDao.findInventoryAll();
    }

    /**
     * @Title: limitMainPage
     * @Description: 分页页数
     * @author kang
     * @date 2018-03-08
     * @throw YnCorpSysException
     */
    public Integer limitMainPage(){
        List<Inventory> list=this.findInventoryAll();
        int count=list.size();
        int pageNum=count/20+1;
        return pageNum;
    }

    /**
     * @Title: findMainPageInventoryAll
     * @Description: 查询所有订单的价格，数量，以及商品的ID
     * @author liukang
     * @date
     * @throw SQLException
     */
    @Override
    public List<MainPage> findMainPageInventoryAll(){
        return mainPageDao.findMainPageInventoryAll();
    }

    /**
     * @param type 商品类型
     * @Title: findMainPageClassify
     * @Description: 分类查询
     * @author kang
     * @date 2018-03-10
     * @throw YnCorpSysException
     */
    @Override
    public List<MainPage> findMainPageClassify(Byte type) {
        return mainPageDao.findMainPageClassify(type);
    }
}