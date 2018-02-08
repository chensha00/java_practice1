package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author yanyong
 * @date 2018/1/24 0024 17:18
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.*;

import java.util.Date;

/**
 * @author yanyong
 * @ClassName TestAll
 * @Description 类描述
 * @date 2018/1/24 0024
 */
public class TestAll {


    /**
     * @Title: main
     * @Description: 主函数
     * @author yanyong
     * @date 2018-1-24 17:18:27
     */
    public static void main(String[] args) {
        //创建操作方法

        PeopleService peopleService = new PeopleServiceImpl();
        StoreService storeService = new StoreServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        GoodsOrderService goodsOrderService = new GoodsOrderServiceImpl();
        OrderDetailService orderDetailService = new OrderDetailServiceImpl();
        PayFlowService payFlowService = new PayFlowServiceImpl();
        InvertoryService invertoryService = new InvertoryServiceImpl();
        /**
         * shangzhiqian
         * 数据库数据插入修改及打印
         *    String name, String cardId, String sex, Integer age, String address
         */
        People people0 = new People("马加爵", "893458929", "男", 23, 100000d, "四川成都郫都区");
        People people1 = new People("李伟达", "895788929", "男", 21, 100000d, "四川成都新都区");
        People people2 = new People("黄小蕾", "895589229", "女", 23, 100000d, "四川成都都江堰");
        People people3 = new People("斯国一", "829578929", "男", 26, 100000d, "四川成都武侯区");
        People people4 = new People("姚迪思", "892589829", "女", 25, 100000d, "四川成都金牛区");

        System.out.println(peopleService.savePeople(people0));
        System.out.println(peopleService.savePeople(people1));
        System.out.println(peopleService.savePeople(people2));
        System.out.println(peopleService.savePeople(people3));
        System.out.println(peopleService.savePeople(people4));
        System.out.println("\n");
        /**
         * shangzhiqian
         *  创建店铺信息，测试插入数据库并返回受影响行数
         */
        Store store1 = new Store("Ax001", "阿迪达斯旗舰店", 0L, 1L);
        Store store2 = new Store("Ax002", "南极人直营店", 0L, 2L);
        Store store3 = new Store("Ax003", "立白官方授权", 0L, 3L);
        Store store4 = new Store("Ax004", "外星人官网直销", 0L, 4L);
//        Store store5 = new Store("Ax005", "耐克专卖", 0L, 5L);

        System.out.println(storeService.saveStore(store1));
        System.out.println(storeService.saveStore(store2));
        System.out.println(storeService.saveStore(store3));
        System.out.println(storeService.saveStore(store4));
//        System.out.println(storeService.saveStore(store5));

//        System.out.println(storeService.saveStore(store6));
//        //String goodsNum, String name, Byte type, Double price, String unit, Double number, Date procedureDate, Float shelfLife, Byte shelfLifeUnit, Long storeId
        Goods goods0 = new Goods("G001", "军大衣", (byte) 3, "件", new Date(), 100f, (byte) 1);
        Goods goods1 = new Goods("G002", "卫衣", (byte) 3, "件", new Date(), 100f, (byte) 1);
        Goods goods2 = new Goods("G003", "帽子", (byte) 3, "件", new Date(), 100f, (byte) 1);
        Goods goods3 = new Goods("G004", "扫帚", (byte) 1, "件", new Date(), 100f, (byte) 1);
        Goods goods4 = new Goods("G005", "羽绒服", (byte) 3, "件", new Date(), 100f, (byte) 1);
        Goods goods5 = new Goods("G006", "短裤", (byte) 3, "件", new Date(), 100f, (byte) 1);
        Goods goods6 = new Goods("G007", "动感单车", (byte) 2, "件", new Date(), 100f, (byte) 1);
        Goods goods7 = new Goods("G008", "哑铃", (byte) 2, "件", new Date(), 100f, (byte) 1);
        Goods goods8 = new Goods("G009", "冲锋衣", (byte) 3, "件", new Date(), 100f, (byte) 1);
        Goods goods9 = new Goods("G010", "立白洗衣液", (byte) 1, "件", new Date(), 100f, (byte) 1);
        Goods goods10 = new Goods("G011", "外星人笔记本", (byte) 0, "件", new Date(), 100f, (byte) 1);

        goodsService.saveGoods(goods0);
        goodsService.saveGoods(goods1);
        goodsService.saveGoods(goods2);
        goodsService.saveGoods(goods3);
        goodsService.saveGoods(goods4);
        goodsService.saveGoods(goods5);
        goodsService.saveGoods(goods6);
        goodsService.saveGoods(goods7);
        goodsService.saveGoods(goods8);
        goodsService.saveGoods(goods9);
        goodsService.saveGoods(goods10);

        System.out.println("\n");


        //Long storeId, Store store, Long goodsId, Goods goods, Double price, Double number
        Invertory invertory1 = new Invertory(1L, store1, 1L, goods2, 354d, 1000d);
        Invertory invertory2 = new Invertory(2L, store2, 3L, goods3, 3874d, 54d);
        Invertory invertory3 = new Invertory(3L, store3, 10L, goods1, 41d, 5d);
        Invertory invertory4 = new Invertory(2L, store2, 1L, goods1, 154d, 4024d);
        Invertory invertory5 = new Invertory(5L, store1, 6L, goods3, 244d, 125d);
        Invertory invertory6 = new Invertory(1L, store2, 9L, goods2, 437387d, 78d);
        Invertory invertory7 = new Invertory(2L, store3, 2L, goods2, 01402042d, 40d);

        System.out.println(invertoryService.saveInvertory(invertory1));
        System.out.println(invertoryService.saveInvertory(invertory2));
        System.out.println(invertoryService.saveInvertory(invertory3));
        System.out.println(invertoryService.saveInvertory(invertory4));
        System.out.println(invertoryService.saveInvertory(invertory5));
        System.out.println(invertoryService.saveInvertory(invertory6));
        System.out.println(invertoryService.saveInvertory(invertory7));


        //创建订单信息，测试插入数据库并返回受影响行数
        People people = new People("zhangsan1", "893458929", "男", 23, 100000d, "四川成都");

        GoodsOrder goodsOrder1 = new GoodsOrder("100100", 1L, people, 452021045d, new Date(), new Date(), (byte) 1, true);
        GoodsOrder goodsOrder2 = new GoodsOrder("100101", 1L, people, 2134552.45d, new Date(), new Date(), (byte) 1, true);
        GoodsOrder goodsOrder3 = new GoodsOrder("100102", 1L, people, 4520524d, new Date(), new Date(), (byte) 1, true);
        GoodsOrder goodsOrder4 = new GoodsOrder("100103", 1L, people, 12585d, new Date(), new Date(), (byte) 1, true);
        GoodsOrder goodsOrder5 = new GoodsOrder("100104", 1L, people, 124d, new Date(), new Date(), (byte) 1, true);

        System.out.println(goodsOrderService.addGoodsOrderById(goodsOrder1));
        System.out.println(goodsOrderService.addGoodsOrderById(goodsOrder2));
        System.out.println(goodsOrderService.addGoodsOrderById(goodsOrder3));
        System.out.println(goodsOrderService.addGoodsOrderById(goodsOrder4));
        System.out.println(goodsOrderService.addGoodsOrderById(goodsOrder5));

        System.out.println("\n");


        OrderDetail orderDetail1 = new OrderDetail("2017070901", 1L, 1L, 1L, 2L, 20d, 20d, 400d, new Date(), new Date(), new Date(), (byte) 1, true);
        OrderDetail orderDetail2 = new OrderDetail("2017070902", 1L, 2L, 1L, 1L, 20d, 20d, 400d, new Date(), new Date(), new Date(), (byte) 1, true);
        OrderDetail orderDetail3 = new OrderDetail("2017070903", 1L, 1L, 1L, 2L, 20d, 20d, 400d, new Date(), new Date(), new Date(), (byte) 1, true);
        OrderDetail orderDetail4 = new OrderDetail("2017070904", 1L, 2L, 1L, 1L, 20d, 20d, 400d, new Date(), new Date(), new Date(), (byte) 1, true);
        orderDetailService.addOrderDetail(orderDetail1);
        orderDetailService.addOrderDetail(orderDetail2);
        orderDetailService.addOrderDetail(orderDetail3);
        orderDetailService.addOrderDetail(orderDetail4);


        System.out.println(orderDetailService.addOrderDetail(orderDetail1));
        System.out.println(orderDetailService.addOrderDetail(orderDetail2));
        System.out.println(orderDetailService.addOrderDetail(orderDetail3));
        System.out.println(orderDetailService.addOrderDetail(orderDetail4));


        System.out.println("\n");

        //创建流水信息，测试插入数据库并返回受影响行数
        //String flowNum, Long peopleId, Double money, Byte flowType, Data crateTime, Long orderDetailId, Long goodsOrderId
        PayFlow payFlow1 = new PayFlow("FL0001", 1L, 400d, (byte) 1, new Date(), 1L);
        PayFlow payFlow2 = new PayFlow("FL0002", 2L, 4600d, (byte) 1, new Date(), 2L);
        PayFlow payFlow3 = new PayFlow("FL0003", 3L, 500d, (byte) 1, new Date(), 3L);
        PayFlow payFlow4 = new PayFlow("FL0004", 4L, 600d, (byte) 2, new Date(), 1L, 1L);
        PayFlow payFlow5 = new PayFlow("FL0005", 4L, 600d, (byte) 2, new Date(), 2L, 2L);
        System.out.println(payFlowService.savePayFlow(payFlow1));
        System.out.println(payFlowService.savePayFlow(payFlow2));
        System.out.println(payFlowService.savePayFlow(payFlow3));
        System.out.println(payFlowService.savePayFlow(payFlow4));
        System.out.println(payFlowService.savePayFlow(payFlow5));


    }
}