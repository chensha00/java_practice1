package domain;/********************************************************************
 /**
 * @Project: java_practice
 * @Package domain
 * @author liukang
 * @date 2018/1/20 16:42
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author liukang
 * @ClassName PayFlow
 * @Description 流水表实体类
 * @date 2018/1/20
 */
public class PayFlow {
    /**
     * payFlowId 主键ID
     */
    private Long id;
    /**
     * flowNum 流水号
     */
    private String flowNum;
    /**
     * peopleId 人员外键
     */
    private Long peopleId;
    /**
     * people 人员对象
     */
    private People people;
    /**
     * money 金额
     */
    private Double money;
    /**
     * flowType 流水类型 1--支出，2--收入
     */
    private Byte flowType;
    /**
     * crateTime 流水生成时间  yyyy-MM-dd HHmmss
     */
    private Date createTime;
    /**
     * orderDetailId 订单详情外键
     */
    private Long orderDetailId;
    /**
     * orderDetail 订单详情对象
     */
    private OrderDetail orderDetail;
    /**
     * goodsOrderId 订单信息外键
     */
    private Long goodsOrderId;
    /**
     * goodsOrder 订单信息对象
     */
    private GoodsOrder goodsOrder;

    //封装

    public Long getPayFlowId() {
        return id;
    }

    public void setPayFlowId(Long id) {
        this.id = id;
    }

    public String getFlowNum() {
        return flowNum;
    }

    public void setFlowNum(String flowNum) {
        this.flowNum = flowNum;
    }

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Byte getFlowType() {
        return flowType;
    }

    public void setFlowType(Byte flowType) {
        this.flowType = flowType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Long getGoodsOrderId() {
        return goodsOrderId;
    }

    public void setGoodsOrderId(Long goodsOrderId) {
        this.goodsOrderId = goodsOrderId;
    }

    public GoodsOrder getGoodsOrder() {
        return goodsOrder;
    }

    public void setGoodsOrder(GoodsOrder goodsOrder) {
        this.goodsOrder = goodsOrder;
    }

    //构造
    public PayFlow() {
    }

    public PayFlow(String flowNum, Long peopleId, Double money, Byte flowType, Date crateTime, Long orderDetailId, Long goodsOrderId) {
        this.flowNum = flowNum;
        this.peopleId = peopleId;
        this.money = money;
        this.flowType = flowType;
        this.createTime = crateTime;
        this.orderDetailId = orderDetailId;
        this.goodsOrderId = goodsOrderId;
    }

    public PayFlow(String flowNum, Long peopleId, Double money, Byte flowType, Date crateTime, Long goodsOrderId) {
        this.flowNum = flowNum;
        this.peopleId = peopleId;
        this.money = money;
        this.flowType = flowType;
        this.createTime = crateTime;
        this.goodsOrderId = goodsOrderId;
    }

    public PayFlow(Long id, String flowNum, Long peopleId, People people, Double money, Byte flowType, Date crateTime, Long orderDetailId, OrderDetail orderDetail, Long goodsOrderId, GoodsOrder goodsOrder) {
        this.id = id;
        this.flowNum = flowNum;
        this.peopleId = peopleId;
        this.people = people;
        this.money = money;
        this.flowType = flowType;
        this.createTime = crateTime;
        this.orderDetailId = orderDetailId;
        this.orderDetail = orderDetail;
        this.goodsOrderId = goodsOrderId;
        this.goodsOrder = goodsOrder;
    }
}