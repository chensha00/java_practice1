package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author liukang
 * @date 2018/1/24 23:18
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.Goods;
import domain.Invertory;
import domain.People;
import domain.Store;
import tools.GoodsException;
import tools.PeopleException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liukang
 * @ClassName CommodityTrading
 * @Description 模拟商品交易全部过程
 * @date 2018/1/24
 */
public class CommodityTrading {

    public static void main(String[] args) throws PeopleException {

        //liukang  asfjkadslfjwqoenfskn
        //创建函数
        GoodsOrderService goodsOrderService = new GoodsOrderServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        InvertoryService invertoryService = new InvertoryServiceImpl();
        OrderDetailService orderDetailService = new OrderDetailServiceImpl();
        PayFlowService payFlowService = new PayFlowServiceImpl();
        PeopleService peopleService = new PeopleServiceImpl();
        StoreService storeService = new StoreServiceImpl();

        //testGetHub zuorui
        //首先生成商品信息插入数据库
        Goods goods1 = new Goods("G001", "衣服1", (byte) 3, "件", new Date(), 100f, (byte) 1);
        Goods goods2 = new Goods("G002", "衣服2", (byte) 3, "件", new Date(), 100f, (byte) 1);
        Goods goods3 = new Goods("G003", "衣服3", (byte) 3, "件", new Date(), 100f, (byte) 1);
        Goods goods4 = new Goods("G004", "衣服4", (byte) 1, "件", new Date(), 100f, (byte) 1);
        Goods goods5 = new Goods("G005", "衣服5", (byte) 3, "件", new Date(), 100f, (byte) 1);
        System.out.println(goodsService.saveGoods(goods1));
        System.out.println(goodsService.saveGoods(goods2));
        System.out.println(goodsService.saveGoods(goods3));
        System.out.println(goodsService.saveGoods(goods4));
        System.out.println(goodsService.saveGoods(goods5));
        System.out.println("\n");
        System.out.println("\n");


        //生成人员信息插入数据库
        People people0 = new People("zhangsan1", "893458929", "男", 23, 100000d, "四川成都");
        People people1 = new People("zhangsan2", "895788929", "男", 23, 100000d, "四川成都");
        People people2 = new People("zhangsan3", "89558929", "女", 23, 100000d, "四川成都");
        People people3 = new People("zhangsan4", "829578929", "男", 23, 100000d, "四川成都");
        People people4 = new People("zhangsan5", "892589829", "男", 23, 100000d, "四川成都");
        System.out.println(peopleService.savePeople(people0));
        System.out.println(peopleService.savePeople(people1));
        System.out.println(peopleService.savePeople(people2));
        System.out.println(peopleService.savePeople(people3));
        System.out.println(peopleService.savePeople(people4));
        System.out.println("\n");
        System.out.println("\n");


        //生成店铺信息插入入数据库
        Store store1 = new Store("Ax001", "店铺A", 0L, 1L);
        Store store2 = new Store("Ax002", "店铺B", 0L, 1L);
        Store store3 = new Store("Ax003", "店铺C", 0L, 1L);
        Store store4 = new Store("Ax004", "店铺D", 0L, 1L);
        Store store5 = new Store("Ax005", "店铺E", 0L, 1L);
        System.out.println(storeService.saveStore(store1));
        System.out.println(storeService.saveStore(store2));
        System.out.println(storeService.saveStore(store3));
        System.out.println(storeService.saveStore(store4));
        System.out.println(storeService.saveStore(store5));
        System.out.println("\n");
        System.out.println("\n");


        //生成初始库存信息插入入数据库
        Invertory invertory1 = new Invertory(1L, store1, 1L, goods1, 50d, 20d);
        Invertory invertory2 = new Invertory(1L, store1, 1L, goods2, 40d, 255d);
        Invertory invertory3 = new Invertory(1L, store1, 1L, goods3, 20d, 354d);
        Invertory invertory4 = new Invertory(1L, store1, 1L, goods3, 30d, 354d);
        Invertory invertory5 = new Invertory(1L, store1, 1L, goods3, 30d, 354d);
        System.out.println(invertoryService.saveInvertory(invertory1));
        System.out.println(invertoryService.saveInvertory(invertory2));
        System.out.println(invertoryService.saveInvertory(invertory3));
        System.out.println(invertoryService.saveInvertory(invertory4));
        System.out.println(invertoryService.saveInvertory(invertory5));
        System.out.println("\n");
        System.out.println("\n");


        //店铺进货，更新商品数量
        List<Goods> goods = new ArrayList<Goods>();
        goods.add(goods1);
        goods.add(goods2);
        Double[] numArr = {20d, 30d};
        Double[] priceArr = {100d, 200d};
        storeService.setStock(goods, numArr, store1, priceArr);

        //买家买货，生成订单和订单详情
        List<Long> idList = new ArrayList<Long>();
        idList.add(0l);
        idList.add(1l);
        List<Double> buyNumList = new ArrayList<Double>();
        buyNumList.add(2d);
        buyNumList.add(3d);
        try {
            peopleService.buyGoods(1, idList, buyNumList);
        } catch (PeopleException e) {
            e.printStackTrace();
        } catch (GoodsException e) {
            e.printStackTrace();
        }

//        //卖家卖货
//        try {
//            goodsService.sale(0l,2d);
//            goodsService.sale(1l,3d);
//        } catch (GoodsException e) {
//            e.printStackTrace();
//        }
//
//        //买家付款，生成流水
//        payFlowService.pay(goodsOrder,people1);
//
//        //店铺发货，更新库存
//        try {
//            storeService.delivery(goods);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //买家收货，店铺收钱，生成流水
//        try {
//            peopleService.receivedGoods(0l,true);
//            peopleService.receivedGoods(1l,true);
//        } catch (PeopleException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            payFlowService.collect(goods,orderDetail.getId(),true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}