package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author yanyong
 * @date 2018/1/22 0022 18:09
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.GoodsOrder;
import domain.People;

import java.util.Date;

/**
 * @author yanyong
 * @ClassName TestGoodsOrderService
 * @Description 类描述
 * @date 2018/1/22 0022
 */
public class TestGoodsOrderService {

    /**
     * @Title: main
     * @Description: 主函数
     * @author yanyong
     * @date
     * @throw YnCorpSysException
     */

    public static void main(String[] args){

        //新建订单信息service对象
        GoodsOrderService goodsOrderService=new GoodsOrderServiceImpl();
        //测试查找订单信息状态
        GoodsOrder goodsOrder=goodsOrderService.findGoodsOrderById(1L);
        //测试修改订单信息状态
        goodsOrderService.showGoodsOrder(goodsOrder);

//        System.out.println(goodsOrderService.addGoodsOrderById(goodsOrder));
        goodsOrder.setOrderStatus((byte)5);

        System.out.println(goodsOrderService.updateGoodsOrderById(1L,goodsOrder));

//        PeopleService peopleService=new PeopleServiceImpl();
        //String orderNum, Long peopleId, Double totalMoney, Date addTime, Date successTime, Byte orderStatus, Boolean isInvalid
//        GoodsOrder goodsOrder=new GoodsOrder();//new GoodsOrder("1232323",25L,peopleService.findPeopleById(25L),39495.34d,new Date(),new Date(),(byte)0,false);
//        goodsOrder.setOrderNum("11212");
//        goodsOrder.setPeopleId(3433L);
//        goodsOrder.setTotalMoney(3934.34d);
//        goodsOrder.setAddTime(goodsOrderService.findGoodsOrderById(1L).getAddTime());
//        goodsOrder.setSuccessTime(goodsOrderService.findGoodsOrderById(1L).getAddTime());
//        goodsOrder.setOrderStatus((byte)1);
//        goodsOrder.setIsInvalid(false);
//        System.out.println(goodsOrderService.addGoodsOrderById(goodsOrder));

        //新建对象
        People people=new People();
        GoodsOrder goodsOrder1=new GoodsOrder(1L,"100100" ,1L,people,400d,new Date(),new Date(),(byte)1,true);
        GoodsOrder goodsOrder2=new GoodsOrder(2L,"100101" ,1L,people,4600d,new Date(),new Date(),(byte)1,true);
        GoodsOrder goodsOrder3=new GoodsOrder(3L,"100102" ,1L,people,500d,new Date(),new Date(),(byte)1,true);
        GoodsOrder goodsOrder4=new GoodsOrder(4L,"100103" ,1L,people,600d,new Date(),new Date(),(byte)1,true);





//        System.out.println(goodsOrderService.addGoodsOrderById(goodsOrder1));
        goodsOrderService.addGoodsOrderById(goodsOrder2);
        goodsOrderService.addGoodsOrderById(goodsOrder3);
        goodsOrderService.addGoodsOrderById(goodsOrder4);

    }
}