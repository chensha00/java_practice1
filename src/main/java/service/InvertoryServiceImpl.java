package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author liukang
 * @date 2018/1/25 16:59
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import dao.InvertoryDao;
import domain.Goods;
import domain.Invertory;
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
 * @ClassName InvertoryServiceImpl
 * @Description 库存操作类实现 InvertoryService
 * @date 2018/1/25
 */
@Service("invertoryService")
@Transactional
public class InvertoryServiceImpl implements InvertoryService {

    @Autowired
    private InvertoryDao invertoryDao;

    /**
     * @Title: saveInvertory
     * @Description: 保存库存信息
     * @author yanyong
     * @date 2018-01-25
     * @param: invertory 库存对象
     * @return: 受影响行数
     */
    @Override
    public Integer saveInvertory(Invertory invertory) {

        Integer number = 0;

            number = invertoryDao.saveInvertory(invertory);

            return number;

    }

    /**
     * @Title: findInvertoryById
     * @Description: 查找库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 库存对象
     */
    @Override
    public Invertory findInvertoryById(Long id) {

        Invertory invertory = null;

        invertory = invertoryDao.findInvertoryById(id).get(0);

            return invertory;
    }


    /**
     * @Title: deleteInvertoryById
     * @Description: 删除库存信息 通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @return: 受影响行数
     */
    @Override
    public Integer deleteInvertoryById(Long id) {
        Integer number = 0;
        try {
            number = invertoryDao.deleteInvertoryById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //返回受影响行数
            return number;
        }
    }

    /**
     * @Title: updateInvertorById
     * @Description: 更新库存信息通过指定id
     * @author yanyong
     * @date 2018-01-25
     * @param: id 指定id
     * @param: invertory 库存对象
     * @return: 受影响行数
     */

    @Override
    public Integer updateInvertorById(Long id, Invertory invertory) {
        Integer number = 0;
        Invertory oldInvertory = this.findInvertoryById(id);
        if (invertory.getPrice() != null) {
            oldInvertory.setPrice(invertory.getPrice());
        }
        if (invertory.getNumber() != null) {
            oldInvertory.setNumber(invertory.getNumber());
        }
        try {
            number = invertoryDao.updateInvertorById(id, oldInvertory);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //返回受影响行数
            return number;
        }
    }

    /**
     * @Title: showInvertory
     * @Description: 查看库存信息
     * @author yanyong
     * @date 2018-01-26
     * @throw YnCorpSysException
     * @param: 库存对象
     */
    public void showInvertory(Invertory invertory) {
        System.out.println("主键ID：" + invertory.getId());
        System.out.println("店铺ID：" + invertory.getStoreId());
        System.out.println("商品ID：" + invertory.getGoodsId());
        System.out.println("价格：" + invertory.getPrice());
        System.out.println("数量：" + invertory.getNumber());
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
        Invertory invertory = new Invertory();
        Integer num = 0;
        invertory.setNumber(number);
        num = this.updateInvertorById(id, invertory);
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
        Invertory invertory = this.findInvertoryById(goods.getId());
        if (invertory != null) {
            Integer number = this.changeGoodsNumberById(goods.getId(), invertory.getNumber() + addNum);
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
        Invertory invertory = this.findInvertoryById(id);
        Integer number = 0;
        if (invertory == null) {
            throw new GoodsException("商品不存在");
        } else {
            if (invertory.getNumber() < saleNum) {
                throw new GoodsException("商品数量不够，无法售卖");
            } else {
                number = this.changeGoodsNumberById(id, invertory.getNumber() - saleNum);
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
    public Double calculationMoney(Invertory invertory, Double num) {
        return invertory.getPrice() * num;
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
        Invertory invertory = new InvertoryServiceImpl().findInvertoryById(id);
        if (invertory.getNumber() >= needNumber) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param storeId:商铺id
     * @param goodsId：商铺id
     * @Title: findInvertoryByStoreIdAndGoodId
     * @Description: 根据商铺id和商铺id查找库存信息
     * @author hzq
     * @date 2018-01-26
     * @throw RuntimeException
     */
    public Invertory findInvertoryByStoreIdAndGoodsId(Long storeId, Long goodsId) throws SQLException {
        Invertory invertory = null;
        try {
            invertory = invertoryDao.findInvertoryByStoreIdAndGoodsId(storeId, goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //返回库存对象
            return invertory;
        }
    }

    /**
     * @param map 条件和值对应key和value
     * @Title: findInvertoryByUnSureCondition
     * @Description: 通过商铺id查找库存信息
     * @author hzq
     * @date 2018/01/30
     * @throw SQLException
     */
    @Override
    public List<Invertory> findInvertoryByUnSureCondition(List<Map<String, Object>> map) throws SQLException {
        List<Invertory> invertorys = null;
        try {
            invertorys = invertoryDao.findInvertoryByUnSureCondition(map);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return invertorys;
        }
    }

    /**
     * @Title: findMainPageInvertory
     * @Description: 查询所有订单的价格，数量，以及商品的ID
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<javabean.MainPage> findMainPageInvertory() {
        List<javabean.MainPage> mainPages = new ArrayList<javabean.MainPage>();
        try {
            mainPages = invertoryDao.findMainPageInvertory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mainPages;

    }
}