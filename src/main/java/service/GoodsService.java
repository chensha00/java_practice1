package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author yanyong
 * @date 2018/1/20 0020 16:58
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.Goods;

import java.util.List;

/**
 * @author yanyong
 * @InterfaceName GoodsService
 * @Description 商品类 操作接口
 * @date 2018/1/20 0020
 */
public interface GoodsService {

    /**
     * @Title: findGoodsById
     * @Description: 查找指定id商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 商品对象
     */
    public Goods findGoodsById(Long id);

    public List<Goods> findGoodsAll();

    /**
     * @Title: saveGoods
     * @Description: 保存商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: goods 商品信息
     * @return: 受影响行数
     */
    public Integer saveGoods(Goods goods);

    /**
     * @Title: deleteGoodsById
     * @Description: 删除指定id的商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 受影响行数
     */
    public Integer deleteGoodsById(Long id);

    /**
     * @Title: updateGoodsById
     * @Description: 更新指定id商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @param: goods 商品信息
     * @return: 受影响行数
     */
    public Integer updateGoods(Goods goods);

    /**
     * @Title: showGoods
     * @Description: 查看商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: goods 商品对象
     */
    public void showGoods(Goods goods);

}