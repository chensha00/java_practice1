package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author 胡志强
 * @date 2018/1/20 17:12
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.DataSourceUtils;
import dao.StoreDao;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.StateEnum;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 胡志强
 * @ClassName StoreServiceImpl
 * @Description StoreService的接口实现类
 * @date 2018/1/20
 */
@Service("storeService")
@Transactional
public class StoreServiceImpl implements StoreService {

    @Autowired
    private  StoreDao storeDao;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private InvertoryService invertoryService;

    @Autowired
    private OrderDetailService orderDetailService;


    /**
     * @Title: findStoreById
     * @Description: 通过指定Id查找商铺
     * @author hzq
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 商铺对象
     */
    @Override
    public Store findStoreById(Long id) throws RuntimeException {

        List<Store> store = new ArrayList<Store>();

        try {
            store = storeDao.findStoreById(id);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return store.get(0);
    }

    /**
     * @Title: findStoreByStoreNum
     * @Description: 通过指定storeNum查找商铺
     * @author hzq
     * @date 2018-01-21
     * @param: id 指定storeNum
     * @return: 商铺对象
     */
    public Store findStoreByStoreNum(String storeNum) throws RuntimeException {


        Store store = null;

        try {
            store = storeDao.findStoreByStoreNum(storeNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return store;

    }

    /**
     * @Title: saveStore
     * @Description: 保存人员信息
     * @author hzq
     * @date 2018-01-21
     * @param: Store 人员对象
     * @return: 受影响行数
     */
    @Override
    public Long saveStore(Store store) throws RuntimeException {

        Long storeId = null;

        try {

            storeId = storeDao.saveStore(store);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storeId;

    }

    /**
     * @Title: showStore
     * @Description: 查看商铺信息
     * @author hzq
     * @date 2018-01-21
     * @param: store 商铺对象
     */
    @Override
    public void showStore(Store store) throws RuntimeException {
        System.out.print("主键ID:" + store.getId());
        System.out.print("编号:" + store.getStoreNum());
        System.out.print("店铺名称:" + store.getStoreName());
        System.out.print("信誉度:" + store.getCredit());
        System.out.print("店铺所有者ID:" + store.getPeopleId());
        People people = new People();
        people = peopleService.findPeopleById(store.getPeopleId());
        System.out.print("店铺所有者姓名:" + people.getName());
        System.out.println();
    }

    /**
     * @Title: deleteStoreById
     * @Description: 删除指定id 的商铺信息
     * @author hzq
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 受影响行数
     */
    @Override
    public Integer deleteStoreById(Long id) throws RuntimeException {
        //定义连接对象

        Integer number = 0;

        try {
            number = storeDao.deleteStoreById(id);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return number;
    }

    /**
     * @Title: updateStoreById
     * @Description: 更新指定商铺的信息
     * @author hzq
     * @date 2018-01-21
     * @param: id 指定商铺id
     * @param: store 指定的商铺的信息
     * @return: 受影响行数
     */
    @Override
    public Integer updateStoreById(Long id, Store store) throws RuntimeException {

        Integer number = null;
        // 1.创建自定义连接池对象
        Store oldStore = this.findStoreById(id);
        //判断需要修改的是哪些信息
        if (store.getStoreNum() != null) {
            oldStore.setStoreNum(store.getStoreNum());
        }
        if (store.getCredit() != 0) {
            oldStore.setCredit(store.getCredit());
        }
        if (store.getStoreName() != null) {
            oldStore.setStoreName(store.getStoreName());
        }
        if (store.getPeopleId() != null) {
            oldStore.setPeopleId(store.getPeopleId());
        }
//        DataSource dataSource = new DataSourceUtils();
        try {

            number = storeDao.updateStoreById(id, oldStore);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;

    }

    /**
     * @param goods  要进的货
     * @param store  商铺信息
     * @param number 进货的数量
     * @param price  如果是新进的货物，则添加价格
     * @Title: setStock
     * @Description: 商铺进货
     * @author hzq
     * @date 2018-01-21
     * @return: 是否成功
     */
    @Override
    public boolean setStock(List<Goods> goods, Double[] number, Store store, Double[] price)
            throws RuntimeException {
        boolean result = false;
        //商铺要进的货物或许是多个
        for (int i = 0; i < goods.size(); i++) {
            //对商品进行查找，判断该商品是否有或者有但是商品所属店铺不是该商铺，就执行添加操作
            Invertory invertory = new Invertory();
            //根据商铺id和商品id查找库存
            try {
                invertory = invertoryService.findInvertoryByStoreIdAndGoodsId(store.getId(), goods.get(i).getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //将查找出来的商品进行判断
            if (invertory.getId() != null) {
                //如果有库存则判定商铺之前进过这个货
                double newNumber = invertory.getNumber().doubleValue() + number[i].doubleValue();
                invertory.setNumber(newNumber);
                //更新商品库存
                int rows = 0;
                rows = invertoryService.changeGoodsNumberById(invertory.getId(), newNumber);
                //根据rows的结果返回结果
                if (rows != 0) {
                    result = true;
                } else {
                    result = false;
                }
            } else {
                //如果所属商品不是进货的商铺，则添加记录
                invertory.setGoodsId(goods.get(i).getId());
                invertory.setNumber(number[i]);
                invertory.setStoreId(store.getId());
                invertory.setPrice(price[i]);
                Integer rows = 0;
                rows = invertoryService.saveInvertory(invertory);
                //根据rows的结果返回结果
                if (rows != 0) {
                    result = true;
                } else {
                    result = false;
                }
            }
        }

        return result;
    }

    /**
     * @Title: delivery
     * @Description: 商铺发货
     * @author hzq
     * @date 2018-01-21
     * //     * @param orderDetail 订单详情
     * @return: 是否成功
     */
    public Date delivery(Long orderDetailId) throws RuntimeException {

        OrderDetail orderDetail = orderDetailService.findOrderDetailById(orderDetailId);
        if (orderDetail.getOrderStatus() != (byte) 1) {
            throw new RuntimeException("订单未支付");
        }
        if (orderDetail.getOrderStatus() >= (byte) 3) {
            throw new RuntimeException("订单已发货");
        }
        //发货是根根据订单详情发货
        Invertory invertory = new Invertory();
        //根据商铺id和商品id查找库存
        try {
            invertory = invertoryService.findInvertoryByStoreIdAndGoodsId(orderDetail.getStoreId(), orderDetail.getGoodsId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (invertory != null) {
            double newNumber = invertory.getNumber().doubleValue() - orderDetail.getNumber().doubleValue();
            invertory.setNumber(newNumber);
            //调用商品的更新方法
            int rows = 0;
            rows = invertoryService.changeGoodsNumberById(invertory.getId(), newNumber);
//            根据rows的结果返回结果
            if (rows != 0) {
                orderDetail.setOrderStatus(StateEnum.SEND.getIndex());
                orderDetail.setDeliveryTime(new Date());
                orderDetailService.updateOrderDetailById(orderDetail.getId(), orderDetail);
                System.out.println("发货成功");
                return new Date();
            } else {
                return null;
            }
        }
        return null;
    }
    /**
     * @Title: findStoreByUnSureCondition
     * @Description: 商铺的不确定条件查询
     * @author hzq
     * @date 2018/01/30
     * @param map 条件和值对应key和value
     * @throw SQLException
     */
    public List<Store> findStoreByUnSureCondition(List<Map<String,Object>> map)
            throws SQLException {
        List<Store> stores = null;
        try {
            stores = storeDao.findStoreByUnSureCondition(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stores;

    }
    /**
     * @Title: findAllStore
     * @Description: 查询全部商铺信息
     * @author hzq
     * @date 2018/01/30
     * @throw SQLException
     */
    @Override
    public List<Store> findAllStore() throws SQLException {
        return storeDao.findAllStore();
    }
}