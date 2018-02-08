package service;/**
 * Created by Roger_yu on 2018/1/24.
 */

import domain.*;

import java.util.Date;

/**
 * @author yuweiyang
 * @ClassName TestOrderDetailService
 * @Description 订单详情测试类
 * @date 2018/1/24
 */
public class TestOrderDetailService {
    public static void main1(String[] args){
        //新建订单详情对象
        People people1=new People();
        Store store1=new Store();
        Goods goods1=new Goods();
        GoodsOrder goodsOrder1=new GoodsOrder();

        OrderDetail orderDetail1=new OrderDetail(1L,"2017070901", 1L,people1,1L,store1,1L,goods1,1L,goodsOrder1,20d, 20d, 400d,new Date(),new Date(), new Date(),(byte)1,true);
        OrderDetail orderDetail2=new OrderDetail(1L,null, null,null,null,null,null,null,null,null,null,null,null,null,null,new Date(),(byte)4,true);
        //新建订单详情service对象
        OrderDetailService orderDetailService=new OrderDetailServiceImpl();
        //测试新增订单详情
        orderDetailService.addOrderDetail(orderDetail1);
        //测试修改订单状态
        orderDetailService.updateOrderDetailById(1L,orderDetail2);
        //测试查找订单详情
        orderDetailService.findOrderDetailById(1L);
    }
    /**
     * @Title: main
     * @Description: 主函数
     * @author yanyong
     * @date
     * @throw YnCorpSysException
     */

    public static void main(String[] args){
        OrderDetail orderDetail=new OrderDetailServiceImpl().findOrderDetailById(8L);
        orderDetail.setNumber(1000.01d);
        orderDetail.setSuccessTime(new Date());
        System.out.println(new OrderDetailServiceImpl().updateOrderDetailById(orderDetail.getId(),orderDetail));
    }
}