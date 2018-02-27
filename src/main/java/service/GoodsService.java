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

//    /**
//     * @Title: changeGoodsNumberById
//     * @Description: 修改指定id的商品数量
//     * @author yanyong
//     * @date 2018-01-22
//     * @param: id 指定id
//     * @param: number 商品数量
//     * @return: 修改行数
//     */
//    public Integer changeGoodsNumberById(Long id, Double number);
//
//    /**
//     * @Title: stock
//     * @Description: 商品进货
//     * @author yanyong
//     * @date 2018-01-22
//     * @param: id 对指定id的商品进货
//     * @param: addNum 进货数量
//     * @return: 受影响行数
//     */
//    public Integer stock(Long id, Double addNum);
//
//    /**
//     * @Title: sale
//     * @Description: 出售商品
//     * @author yanyong
//     * @date 2018-01-22
//     * @param: id 对指定id的商品出售
//     * @param: saleNum 出售数量
//     * @return: 受影响行数
//     */
//    public Integer sale(Long id, Double saleNum) throws GoodsException;
//
//    /**
//     * @Title: calculationMoney
//     * @Description: 计算商品金额
//     * @author yanyong
//     * @date 2018-01-22
//     * @param: goods 商品
//     * @param: num 数量
//     * @return: 计算金额
//     */
//    public Double calculationMoney(Goods goods, Double num);
//
//    /**
//     * @Title: judgeNumberIsEnough
//     * @Description: 判断数量是否足够
//     * @author yanyong
//     * @date 2018-01-23
//     * @param: id 指定id
//     * @param: needNumber 需要数量
//     * @return: 数量是否足够，false--否，true--是
//     */
//    public Boolean judgeNumberIsEnough(Long id,Double needNumber);

}