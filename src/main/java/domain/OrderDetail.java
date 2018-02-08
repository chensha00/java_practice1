package domain;/**
 * Created by Roger_yu on 2018/1/20.
 */

import java.util.Date;

/**
 * @author yuweiyang
 * @ClassName OrderDetail
 * @Description 订单详情 实体类
 * @date 2018/1/20
 */
public class OrderDetail {
    /**
     * id 主键ID
     */
    private Long id;

    /**
     * orderNum 订单编号
     */
    private String orderNum;

    /**
     * peopleId 买家外键
     */
    private Long peopleId;

    /**
     * peopleId 买家外键对象
     */
    private People people;

    /**
     * storeId 店铺外键
     */
    private Long storeId;

    /**
     * storeId 店铺外键对象
     */
    private Store store;

    /**
     * goodsId 商品外键
     */
    private Long goodsId;

    /**
     * goodsId 商品外键对象
     */
    private Goods goods;

    /**
     * goodsOrderId 订单信息外键
     */
    private Long goodsOrderId;

    /**
     * goodsOrderId 订单信息外键对象
     */
    private GoodsOrder goodsOrder;

    /**
     * number 购买数量
     */
    private Double number;

    /**
     * goodsPrice 商品单价
     */
    private Double goodsPrice;

    /**
     * goodsAmount 商品总金额
     */
    private Double goodsAmount;

    /**
     * addTime 订单生成日期 yyyy-MM-dd HH:mm:ss
     */
    private Date addTime;

    /**
     * successTime 交易成功日期 yyyy-MM-dd HH:mm:ss
     */
    private Date successTime;

    /**
     * deliveryTime 发货日期 yyyy-MM-dd HH:mm:ss
     */
    private Date deliveryTime;

    /**
     * orderStatus 订单状态 0--未支付，1--支付成功，2--支付失败，3--发货中，4--订单完成
     */
    private Byte orderStatus;

    /**
     * isInvalid 是否作废 false--作废，true--不作废
     */
    private Boolean isInvalid;

    /**
     * @Title:
     * @Description: 封装函数
     * @author yuweiyang
     * @date
     */

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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
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

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Double getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Double goodsAmount) {
        this.goodsAmount = goodsAmount;
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

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
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

    /**
     * @Title:
     * @Description: 构造函数
     * @author yuweiyang
     * @date
     */
    public OrderDetail(Long id, String orderNum, Long peopleId, People people, Long storeId, Store store, Long goodsId, Goods goods, Long goodsOrderId, GoodsOrder goodsOrder, Double number, Double goodsPrice, Double goodsAmount, Date addTime, Date successTime, Date deliveryTime, Byte orderStatus, Boolean isInvalid) {
        this.id = id;
        this.orderNum = orderNum;
        this.peopleId = peopleId;
        this.people = people;
        this.storeId = storeId;
        this.store = store;
        this.goodsId = goodsId;
        this.goods = goods;
        this.goodsOrderId = goodsOrderId;
        this.goodsOrder = goodsOrder;
        this.number = number;
        this.goodsPrice = goodsPrice;
        this.goodsAmount = goodsAmount;
        this.addTime = addTime;
        this.successTime = successTime;
        this.deliveryTime = deliveryTime;
        this.orderStatus = orderStatus;
        this.isInvalid = isInvalid;
    }

    public OrderDetail() {

    }

    public OrderDetail(String orderNum, Long peopleId, Long storeId, Long goodsId, Long goodsOrderId, Double number, Double goodsPrice, Double goodsAmount, Date addTime, Date successTime, Date deliveryTime, Byte orderStatus, Boolean isInvalid) {
        this.orderNum = orderNum;
        this.peopleId = peopleId;
        this.storeId = storeId;
        this.goodsId = goodsId;
        this.goodsOrderId = goodsOrderId;
        this.number = number;
        this.goodsPrice = goodsPrice;
        this.goodsAmount = goodsAmount;
        this.addTime = addTime;
        this.successTime = successTime;
        this.deliveryTime = deliveryTime;
        this.orderStatus = orderStatus;
        this.isInvalid = isInvalid;
    }

    public OrderDetail(String orderNum, Long peopleId, Long storeId, Long goodsId, Long goodsOrderId, Double number, Double goodsPrice, Double goodsAmount) {
        this.orderNum = orderNum;
        this.peopleId = peopleId;
        this.storeId = storeId;
        this.goodsId = goodsId;
        this.goodsOrderId = goodsOrderId;
        this.number = number;
        this.goodsPrice = goodsPrice;
        this.goodsAmount = goodsAmount;
        this.addTime = new Date();
//        this.successTime = null;
//        this.deliveryTime = deliveryTime;
        this.orderStatus = (byte) 0;
        this.isInvalid = true;
    }
}