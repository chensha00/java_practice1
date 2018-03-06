package domain;/**
 * Created by Kaiser on 2018/1/20.
 */
/********************************************************************
 /**
 * @Project: java_practice
 * @Package domain
 * @author zuorui
 * @date 2018/1/20 16:43
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import java.util.Date;

/**
 * @author zuorui
 * @ClassName GoodsOrder
 * @Description 类描述
 * @date 2018/1/20
 */
public class GoodsOrder {

    /**
     * id 主键
     */
    private Long id;

    /**
     * orderNum 订单编号
     */
    private String orderNum;

    /**
     * peopleId 买家（人员外键）
     */
    private Long peopleId;

    /**
     * people 买家（对象）
     */
    private People people;

    /**
     * totalMoney 订单总金额
     */
    private Double totalMoney;

    /**
     * addTime 生成日期 yyyy-MM-dd HH:mm:ss
     */
    private Date addTime;

    /**
     * successTime 交易成功时间 yyyy-MM-dd HH:mm:ss
     */
    private Date successTime;

    /**
     * orderStatus "订单状态 0--未支付，1--支付成功，2--支付失败"
     */
    private Byte orderStatus;

    /**
     * isInvalid  "订单是否作废 0--作废，1--不作废"
     */
    private Boolean isInvalid;

    //get和set方法


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getIsInvalid() {
        return isInvalid;
    }

    public void setIsInvalid(Boolean isInvalid) {
        this.isInvalid = isInvalid;
    }
//构造方法


    public GoodsOrder(Long id, String orderNum, Long peopleId, People people, Double totalMoney, Date addTime, Date successTime, Byte orderStatus, Boolean isInvalid) {
        this.id = id;
        this.orderNum = orderNum;
        this.peopleId = peopleId;
        this.people = people;
        this.totalMoney = totalMoney;
        this.addTime = addTime;
        this.successTime = successTime;
        this.orderStatus = orderStatus;
        this.isInvalid = isInvalid;
    }

    public GoodsOrder(String orderNum, Long peopleId, Double totalMoney) {
        this.orderNum = orderNum;
        this.peopleId = peopleId;
        this.totalMoney = totalMoney;
        this.orderStatus = (byte) 0;
        this.isInvalid = false;
        this.addTime = new Date();
    }

    public GoodsOrder(Long peopleId, Double totalMoney, Byte orderStatus) {
        this.peopleId = peopleId;
        this.totalMoney = totalMoney;
        this.orderStatus = orderStatus;
        this.isInvalid = false;
        this.addTime = new Date();
    }

    public GoodsOrder(String orderNum, Long peopleId, People people, Double totalMoney, Date addTime, Date successTime, Byte orderStatus, Boolean isInvalid) {
        this.orderNum = orderNum;
        this.peopleId = peopleId;
        this.people = people;
        this.totalMoney = totalMoney;
        this.addTime = addTime;
        this.successTime = successTime;
        this.orderStatus = orderStatus;
        this.isInvalid = isInvalid;
    }

    public GoodsOrder() {

    }


}
