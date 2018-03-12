package service;/**
 * Created by HS on 2018/1/20.
 */

import common.util.DataSourceUtils;
import common.util.JdbcUtils;
import dao.PeopleDao;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.GoodsException;
import tools.GoodsOrderException;
import tools.PeopleException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author shangzhiqian
 * @ClassName PeopleServiceImpl
 * @Description 人员类 操作类，实现PeopleService接口
 * @date 2018/1/20
 */
@Service("peopleService")
@Transactional
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    @Autowired
    private GoodsOrderService goodsOrderService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private PayFlowService payFlowService;


    /**
     * @Title: findPeopleById
     * @Description: 通过指定Id查找人员
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 人员对象
     */
    @Override
    public People findPeopleById(Long id){
        return peopleDao.findPeopleById(id);
    }

    /**
     * @Title: deletePeopleById
     * @Description: 删除指定id 的人员信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 受影响行数
     */
    public Integer deletePeopleById(Long id){
        return peopleDao.deletePeopleById(id);
    }
    /**
     * @Title: updatePeople
     * @Description: 更新指定人员的信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定人员id
     * @param: people 指定人员信息
     * @return: 受影响行数
     */
    @Override
    public Integer updatePeople(People people){
        return peopleDao.updatePeople(people);
    }
    /**
     * @Title: savePeople
     * @Description: 保存人员信息
     * @author yanyong
     * @date 2018-01-21
     * @param: people 人员对象
     * @return: 受影响行数
     */
    @Override
    public Integer savePeople(People people){
        return peopleDao.savePeople(people);
    }


    /**
     * @Title: findPeopleByUserName
     * @Description: 查找用户根据用户名和密码
     * @author yanyong
     * @date 2018-01-30
     * @param: userName 用户名
     * @param: password 密码
     * @return: 人员对象
     */
    public People findPeopleByUserName(String userName,String password){

        return peopleDao.findPeopleByUserName(userName,password);
        // 1.创建自定义连接池对象
//        return people;
    }
    public List<People> getAllPeople(){
        return peopleDao.getAllPeople();
    }

    /**
     * @Title: showPeople
     * @Description: 查看人员信息
     * @author yanyong
     * @date 2018-01-21
     * @param: people 人员对象
     */
    @Override
    public void showPeople(People people) {
        System.out.print("主键ID:" + people.getId()+" ");
        System.out.print("姓  名:" + people.getName()+" ");
        System.out.print("身份证号:" + people.getCardId()+" ");
        System.out.print("性别:" + people.getSex()+" ");
        System.out.print("年龄:" + people.getAge()+" ");
        System.out.print("余额:" + people.getMoney()+" ");
        System.out.print("地址:" + people.getAddress()+" ");
        System.out.println();
    }

    /**
     * @param
     * @return
     * @throws
     * @Title:
     * @Description: 方法描述
     * @author shangzhiqian
     * @date 买东西方法 buyGoods
     */
    @Override
    public GoodsOrder buyGoods(long peopleId, List<Long> idList, List<Double> buyNumList) throws PeopleException, GoodsException {
        Double sumMoney = 0d;
        List<Double> goodsMoneyList = new ArrayList<Double>();
        if (idList.size() != buyNumList.size()) {
            throw new PeopleException("数据错误，无法购买");
        }
        for (int i = 0; i < idList.size(); i++) {
            if (inventoryService.judgeNumberIsEnough(idList.get(i), buyNumList.get(i)) == true) {
                System.out.println("库存Id:" + idList.get(i));
                Inventory inventory = inventoryService.findInventoryById(idList.get(i));
                Double goodsMoney = inventoryService.calculationMoney(inventory, buyNumList.get(i));
                goodsMoneyList.add(goodsMoney);
                sumMoney = sumMoney + goodsMoney;
            } else {
                throw new GoodsException("id为" + idList.get(i) + "数量不够，无法购买");
            }
        }
        String orderNum = "GO" + System.currentTimeMillis();
        GoodsOrder goodsOrder = new GoodsOrder(orderNum, peopleId, sumMoney);
        goodsOrderService.showGoodsOrder(goodsOrder);
        Integer num = goodsOrderService.saveGoodsOrderById(goodsOrder);
        goodsOrder = goodsOrderService.findGoodsOrderByNum(goodsOrder.getOrderNum());

        for (int i = 0; i < idList.size(); i++) {
            String orderDetailNum = "OD" + System.currentTimeMillis();
            Inventory inventory = inventoryService.findInventoryById(idList.get(i));
            Long buyerId = goodsOrder.getPeopleId();
            Long storeId = inventory.getStoreId();
            Long goodsId = inventory.getGoodsId();
            Long goodsOrderId = goodsOrder.getId();
            Double number = buyNumList.get(i);
            Double goodsPrice = inventory.getPrice();
            Double goodsAmount = goodsMoneyList.get(i);
            OrderDetail orderDetail = new OrderDetail(orderDetailNum, buyerId, storeId, goodsId, goodsOrderId, number, goodsPrice, goodsAmount);
            Integer number2 = orderDetailService.saveOrderDetail(orderDetail);
            System.out.println(number2);
        }
        return goodsOrder;

    }


    /**
     * @Title: receivedGoods
     * @Description: 接收订购商品
     * @author yanyong
     * @date 2018-01-23
     * @param: goods 商品
     * @param: isRecv 是否收货
     * @return: 是否收货
     */
    @Override
    public Boolean receivedGoods(Long orderDetailId, Boolean isRecv) throws PeopleException {
        OrderDetail orderDetail = new OrderDetailServiceImpl().findOrderDetailById(orderDetailId);
        if (isRecv == true && orderDetail.getOrderStatus() == 3) {
            orderDetail.setOrderStatus((byte) 4);
            new OrderDetailServiceImpl().updateOrderDetailById(orderDetail.getId(), orderDetail);
            return true;
        } else {
            throw new PeopleException("因xx原因收货失败");
        }
    }

    /**
     * @Title: judgeMoneyIsEnough
     * @Description: 判断人员余额是否足够
     * @author yanyong
     * @date 2018-01-23
     * @param: id 人员id
     * @param: needMoney 需要花费的金额
     * @return: 余额是否足够 false--否，true--是
     */
    @Override
    public Boolean judgeMoneyIsEnough(Long id, Double needMoney) {
        People people = this.findPeopleById(id);
        if (people.getMoney() >= needMoney) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @Title: payGoodsMoneyById
     * @Description: 支付指定订单购物金额
     * @author yanyong
     * @date 2018-01-28
     * @param: id 指定id
     * @return:
     */
    public Boolean payGoodsMoneyByOrderId(Long peopleId, Long orderId) throws GoodsException, GoodsOrderException {
        GoodsOrder goodsOrder = goodsOrderService.findGoodsOrderById(orderId);
        People people = peopleService.findPeopleById(peopleId);
        List<OrderDetail> orderDetailList = null;
        Boolean isPay = false;
        if (goodsOrder.getOrderStatus() == (byte) 1) {
            throw new GoodsOrderException("id为" + goodsOrder.getId() + "的订单已支付");
        }
        if (people.getMoney() < goodsOrder.getTotalMoney()) {
            throw new GoodsException("id为" + goodsOrder.getPeopleId() + "人员余额不够，无法购买");
        }
        //获取指定订单的订单详情
        orderDetailList = orderDetailService.findOrderDetailListByOrderId(orderId);
        //支付订单金额
        isPay = peopleService.descMoney(people.getId(), goodsOrder.getTotalMoney());
        if (isPay == true) {
            goodsOrder.setOrderStatus((byte) 1);
            goodsOrder.setSuccessTime(new Date());
            //String flowNum, Long peopleId, Double money, Byte flowType, Date crateTime, Long orderDetailId, Long goodsOrderId
            //生成流水编号
            String flowNum = "PGO" + System.currentTimeMillis();
            //生成流水信息
            PayFlow payFlow = new PayFlow(flowNum, people.getId(), goodsOrder.getTotalMoney(), (byte) 1, new Date(), goodsOrder.getId());
            //更新订单信息
            goodsOrderService.updateGoodsOrder(goodsOrder);
            //保存流水信息
            payFlowService.savePayFlow(payFlow);
            for (int i = 0; i < orderDetailList.size(); i++) {
                //卖家增加金额
                peopleService.ascMoney(orderDetailList.get(i).getStore().getPeopleId(), orderDetailList.get(i).getGoodsAmount());
                orderDetailList.get(i).setOrderStatus((byte) 1);
                orderDetailList.get(i).setSuccessTime(new Date());
                //获取流水比编号
                String flowNum1 = "POD" + System.currentTimeMillis();
                //生成流水信息
                PayFlow payFlow1 = new PayFlow(flowNum1, orderDetailList.get(i).getStore().getPeopleId(), orderDetailList.get(i).getGoodsAmount(), (byte) 2, new Date(), orderDetailList.get(i).getId(), orderDetailList.get(i).getGoodsOrderId());
                orderDetailService.updateOrderDetailById(orderDetailList.get(i).getId(), orderDetailList.get(i));
                int index=payFlowService.savePayFlow(payFlow1);
            }
            return true;
        } else {
            goodsOrder.setOrderStatus((byte) 2);
            goodsOrderService.updateGoodsOrder(goodsOrder);
            return false;
        }

    }

    /**
     * @Title: descMoney
     * @Description: 减少金额，对指定人员id
     * @author yanyong
     * @date 2018-01-28
     * @param: peopleId 指定人员id
     * @param: money 金额数
     * @return: 是否减少成功
     */

    public Boolean descMoney(Long peopleId, Double money) {
        People people = this.findPeopleById(peopleId);
        people.setMoney(people.getMoney() - money);
        Integer number = this.updatePeople(people);
        if (number > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @Title: ascMoney
     * @Description: 增加金额，对指定人员id
     * @author yanyong
     * @date 2018-01-28
     * @param: peopleId 指定人员id
     * @param: money 金额数
     * @return: 是否增加成功
     */
    public Boolean ascMoney(Long peopleId, Double money) {
        People people = this.findPeopleById(peopleId);
        people.setMoney(people.getMoney() + money);
        Integer number = this.updatePeople(people);
        if (number > 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * @Title: findPeopleByUnSureCondition
     * @Description: 方法描述
     * @author hzq
     * @date 2018/01/30
     * @param map 条件和值对应key和value
     * @throw SQLException
     */
    public List<People> findPeopleByUnSureCondition(List<Map<String,Object>> map)
            throws SQLException{
        //定义连接对象
        Connection conn = null;
        //定义预编译 Statement对象
        PreparedStatement preparedStatement = null;
        List<People> peoples = null;
        // 1.创建自定义连接池对象
        DataSource dataSource = new DataSourceUtils();
        try {
            //获取连接对象
            conn = dataSource.getConnection();
            //关闭自动连接
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放连接资源
            JdbcUtils.release(conn, preparedStatement, null);
            //返回人员对象
            return peoples;
        }
    }

}
