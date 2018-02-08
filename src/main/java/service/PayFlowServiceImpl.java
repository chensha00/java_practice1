package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author liukang
 * @date 2018/1/20 17:02
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import dao.PayFlowDao;
import domain.PayFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author liukang
 * @ClassName PayFlowServiceImpl
 * @Description PayFlowService流水接口的实现
 * @date 2018/1/20
 */
@Service ("payFlowService")
@Transactional
public class PayFlowServiceImpl implements PayFlowService {

    @Autowired
    private PayFlowDao payFlowDao;

    @Autowired
    private PayFlowService payFlowService;

//    /**
//     * @Title: pay
//     * @Description: 支付方法实现
//     * @author liukang
//     * @date 2018-1-21 22:17:28
//     * @throw YnCorpSysException
//     */
//    @Override
//    public Boolean pay(GoodsOrder goodsOrder, People people)  throws Exception{
//        //判断买家拥有金钱是否大于等于商品总金额
//        if (people.getMoney().doubleValue() >= goodsOrder.getTotalMoney().doubleValue()) {
//            //付款更新买家拥有金额
//            people.setMoney(people.getMoney().doubleValue() - goodsOrder.getTotalMoney().doubleValue());
//            System.out.println("支付成功！\n" + people.getName() + "您的当前余额：" + people.getMoney());
//            peopleService.updatePeopleById(people.getId(),people);
//            //生产支付流水并更新流水表
//            PayFlow payFlow = new PayFlow();
//            payFlow.setFlowNum((new Date()).toString() + people.getId() + goodsOrder.getId());
//            payFlow.setPeople(people);
//            payFlow.setPeopleId(people.getId());
//            payFlow.setMoney(goodsOrder.getTotalMoney());
//            payFlow.setFlowType((byte) 1);
//            payFlow.setCrateTime(new Date());
//            payFlow.setGoodsOrder(goodsOrder);
//            payFlow.setGoodsOrderId(goodsOrder.getId());
//            this.savePayFlow(payFlow);
//            return true;
//        } else {
//            System.out.println("余额不足，支付失败");
//            return false;
//        }
//    }
//
//
//
//    /**
//     * @Title: collect
//     * @Description: 收款方法实现
//     * @author liukang
//     * @date 2018-1-21 22:17:28
//     * @throw YnCorpSysException
//     */
//    @Override
//    public void collect(List<Goods> goods,Long orderDetailId, Boolean isRecv) throws Exception {
//        //判断卖家是否发货
//        for (int i = 0; i < goods.size(); i++) {
//            if (new StoreServiceImpl().delivery(goods) != null) {
//                //判断买家是否收货或者发货时间大于15天
//                if ((new PeopleServiceImpl().receivedGoods(orderDetailId,isRecv)) || (((new Date()).getTime() - (new StoreServiceImpl().delivery(goods)).getTime()) / (1000 * 60 * 60 * 24) >= 15)) {
//                    //店铺收款，更新持有人余额
//                    goods.get(i).getStore().getPeople().setMoney(goods.get(i).getStore().getPeople().getMoney().doubleValue()+goods.get(i).getNumber().doubleValue()*goods.get(i).getPrice());
//                    System.out.println("收款成功！\n当前余额：" + goods.get(i).getStore().getPeople().getMoney());
//                    ////生产支付流水并更新流水表
//                    PayFlow payFlow = new PayFlow();
//                    payFlow.setFlowNum((new Date()).toString() + goods.get(i).getStore().getPeople().getId());
//                    payFlow.setPeople(goods.get(i).getStore().getPeople());
//                    payFlow.setPeopleId(goods.get(i).getStore().getPeople().getId());
//                    payFlow.setMoney(goods.get(i).getStore().getPeople().getMoney());
//                    payFlow.setFlowType((byte) 2);
//                    payFlow.setCrateTime(new Date());
//                }
//            } else {
//                System.out.println("买家还未确定收货！");
//            }
//        }
//    }
//
//    /**
//     * @Title: collect
//     * @Description: 收款方法实现
//     * @author liukang
//     * @date 2018-1-21 22:17:28
//     * @throw YnCorpSysException
//     */
//    @Override
//    public void collect(List<Goods> goods,Long orderDetailId, Boolean isRecv) throws Exception {
//        //判断卖家是否发货
//        for (int i = 0; i < goods.size(); i++) {
//            if (new StoreServiceImpl().delivery(goods) != null) {
//                //判断买家是否收货或者发货时间大于15天
//                if ((new PeopleServiceImpl().receivedGoods(orderDetailId,isRecv)) || (((new Date()).getTime() - (new StoreServiceImpl().delivery(goods)).getTime()) / (1000 * 60 * 60 * 24) >= 15)) {
//                    //店铺收款，更新持有人余额
//                    goods.get(i).getStore().getPeople().setMoney(goods.get(i).getStore().getPeople().getMoney().doubleValue()+goods.get(i).getNumber().doubleValue()*goods.get(i).getPrice());
//                    System.out.println("收款成功！\n当前余额：" + goods.get(i).getStore().getPeople().getMoney());
//                    ////生产支付流水并更新流水表
//                    PayFlow payFlow = new PayFlow();
//                    payFlow.setFlowNum((new Date()).toString() + goods.get(i).getStore().getPeople().getId());
//                    payFlow.setPeople(goods.get(i).getStore().getPeople());
//                    payFlow.setPeopleId(goods.get(i).getStore().getPeople().getId());
//                    payFlow.setMoney(goods.get(i).getStore().getPeople().getMoney());
//                    payFlow.setFlowType((byte) 2);
//                    payFlow.setCrateTime(new Date());
//                }
//            } else {
//                System.out.println("买家还未确定收货！");
//            }
//        }
//    }
//
//    /**
//     * @Title: collect
//     * @Description: 收款方法实现
//     * @author liukang
//     * @date 2018-1-21 22:17:28
//     * @throw YnCorpSysException
//     */
//    @Override
//    public void collect(OrderDetail orderDetail,Boolean isRecv) throws Exception {
//        List<Goods> goodses=new ArrayList<Goods>();
//        goodses.add(orderDetail.getGoods());
//        //判断卖家是否发货
//            if (new StoreServiceImpl().delivery(goodses) != null) {
//                //判断买家是否收货或者发货时间大于15天
//                if ((new PeopleServiceImpl().receivedGoods(orderDetail.getId(),isRecv)) || (((new Date()).getTime() - (new StoreServiceImpl().delivery(goodses)).getTime()) / (1000 * 60 * 60 * 24) >= 15)) {
//                    //店铺收款，更新持有人余额
//                    orderDetail.getStore().getPeople().setMoney(orderDetail.getStore().getPeople().getMoney().doubleValue()+orderDetail.getGoodsAmount().doubleValue());
//                    System.out.println("收款成功！\n当前余额：" + orderDetail.getStore().getPeople().getMoney());
//                    peopleService.updatePeopleById(orderDetail.getStore().getPeople().getId(),orderDetail.getStore().getPeople());
//                    ////生产支付流水并更新流水表
//                    PayFlow payFlow = new PayFlow();
//                    payFlow.setFlowNum((new Date()).toString() + orderDetail.getStore().getPeople().getId());
//                    payFlow.setPeople(orderDetail.getStore().getPeople());
//                    payFlow.setPeopleId(orderDetail.getStore().getPeople().getId());
//                    payFlow.setMoney(orderDetail.getStore().getPeople().getMoney());
//                    payFlow.setFlowType((byte) 2);
//                    payFlow.setCrateTime(new Date());
//                    payFlow.setOrderDetailId(orderDetail.getId());
//                    payFlow.setOrderDetail(orderDetail);
//                    this.savePayFlow(payFlow);
//            } else {
//                System.out.println("买家还未确定收货！");
//            }
//        }
//    }


    /**
     * @Title: findPayFlowById
     * @Description: 通过id查找流水信息
     * @author liukang
     * @date 2018-01-24
     * @param: id 指定id
     * @return: 流水信息
     */
    @Override
    public PayFlow findPayFlowById(Long id) {
        PayFlow payFlow = null;
        try {
            payFlow = payFlowDao.findPayFlowById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //返回流水对象
            if (payFlow != null) {
                payFlow.setPeople(new PeopleServiceImpl().findPeopleById(payFlow.getPeopleId()));
                payFlow.setOrderDetail(new OrderDetailServiceImpl().findOrderDetailById(payFlow.getOrderDetailId()));
                payFlow.setGoodsOrder(new GoodsOrderServiceImpl().findGoodsOrderById(payFlow.getGoodsOrderId()));
            }
            return payFlow;
        }
    }


    /**
     * @Title: findPayFlowById
     * @Description: 通过流水号查ID
     * @author liukang
     * @date 2018-01-24
     * @param: id 指定id
     * @return: 流水信息
     */
    @Override
    public PayFlow findPayFlowByFlowNum(String flowNum) throws RuntimeException {
        PayFlow payFlow = null;

        try {
            payFlow = payFlowDao.findPayFlowByFlowNum(flowNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payFlow;
    }


    /**
     * @Title: savePayFlow
     * @Description: 保存流水信息
     * @author liukang
     * @date 2018-01-24
     * @param: payFlow 流水信息
     * @return: 受影响行数
     */

    @Override
    public Long savePayFlow(PayFlow payFlow) {
        Long number = 0L;
        try {
            number = payFlowDao.savePayFlow(payFlow);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //受影响行数
            return number;
        }
    }

    /**
     * @param peopleId
     * @Title: MonthConsumption
     * @Description: 指定人员的当月消费情况
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<Map<String, Object>> MonthConsumption(Long peopleId) {
        List<Map<String, Object>> rs = null;
        try {
            rs = payFlowDao.MonthConsumption(peopleId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //受影响行数
            return rs;
        }
    }

    /**
     * @Title: MonthEarnings
     * @Description: 指定卖家的本月盈利
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<Map<String, Object>> MonthEarnings(Long storeId) {
        List<Map<String, Object>> rs = null;
        try {
            rs = payFlowDao.MonthConsumption(storeId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //受影响行数
            return rs;
        }
    }

    /**
     * @Title: YearConsumption
     * @Description: 指定买家的本年消费
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<Map<String, Object>> YearConsumption(Long peopleId) {
        List<Map<String, Object>> rs = null;
        try {
            rs = payFlowDao.MonthConsumption(peopleId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //受影响行数
            return rs;
        }
    }

    /**
     * @Title: YearEarnings
     * @Description: 指定卖家的本年盈利
     * @author liukang
     * @date
     * @throw YnCorpSysException
     */
    @Override
    public List<Map<String, Object>> YearEarnings(Long storeId) {
        List<Map<String, Object>> rs = null;
        try {
            rs = payFlowDao.MonthConsumption(storeId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //受影响行数
            return rs;
        }
    }
}

