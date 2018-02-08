package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author yanyong
 * @date 2018/1/21 0021 23:51
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.Goods;

import java.util.Date;

/**
 * @author yanyong
 * @ClassName TestGoodsService
 * @Description 类描述
 * @date 2018/1/21 0021
 */
public class TestGoodsService {

    /**
     * @Title: main
     * @Description: 主函数
     * @author yanyong
     * @date
     * @throw YnCorpSysException
     */

    public static void main(String[] args) {
        GoodsService goodsService = new GoodsServiceImpl();
        Goods goods = null;
//        goods = goodsService.findGoodsById(1L);
//        goodsService.showGoods(goods);
        //Long id, String goodsNum, String name, Byte type, Double price, String unit, Double number, Date procedureDate, Float shelfLife, Byte shelfLifeUnit, Long storeId, Store store
        Goods goods1=new Goods(22L,"3434","lajgl",(byte)2,"ge",new Date(),232.4f,(byte)1);
//        goods.setGoodsNum("390003500045");
        System.out.println(goodsService.saveGoods(goods1));


//        System.out.println(goodsService.deleteGoodsById(5L));
//        System.out.println(goodsService.updateGoodsById(6L, goods));


    }
}