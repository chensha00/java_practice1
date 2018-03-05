package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author yanyong
 * @date 2018/1/20 0020 16:58
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import dao.GoodsDao;
import domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.GoodsTypeEnum;
import tools.TimeFormat;

import java.util.List;

/**
 * @author yanyong
 * @ClassName GoodsServiceImpl
 * @Description 商品 操作类 实现GoodsService 接口
 * @date 2018/1/20 0020
 */
@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;// = new GoodsDaoImpl();
    /**
     * @Title: findGoodsById
     * @Description: 查找指定id商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 商品对象
     */
    @Override
    public Goods findGoodsById(Long id){
        return goodsDao.findGoodsById(id);
    }

    public List<Goods> findGoodsAll(){
        return goodsDao.findGoodsAll();
    }


    /**
     * @Title: saveGoods
     * @Description: 保存商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: goods 商品信息
     * @return: 受影响行数
     */
    @Override
    public Integer saveGoods(Goods goods){
        return goodsDao.saveGoods(goods);
    }


    /**
     * @Title: deleteGoodsById
     * @Description: 删除指定id的商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 受影响行数
     */
    @Override
    public Integer deleteGoodsById(Long id) {
        return goodsDao.deleteGoodsById(id);
    }

    /**
     * @Title: updateGoodsById
     * @Description: 更新指定id商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @param: goods 商品信息
     * @return: 受影响行数
     */
    @Override
    public Integer updateGoods(Goods goods){
        return goodsDao.updateGoods(goods);
    }


    /**
     * @Title: showGoods
     * @Description: 查看商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: goods 商品对象
     */
    @Override
    public void showGoods(Goods goods) {
        System.out.print("主键ID:" + goods.getId() + " ");
        System.out.print("商品编号:" + goods.getGoodsNum() + " ");
        System.out.print("名称:" + goods.getName() + " ");
        System.out.print("类型:" + GoodsTypeEnum.findGoodsTypeByIndex(goods.getType()) + " ");
        System.out.print("单位:" + goods.getUnit() + " ");
        System.out.print("生产时间:" + new TimeFormat(goods.getProcedureDate()).format() + " ");
        System.out.print("保质期:" + goods.getShelfLife() + " ");
        System.out.print("保质期单位:" + goods.getShelfLifeUnit() + " ");
        System.out.println();
    }

}