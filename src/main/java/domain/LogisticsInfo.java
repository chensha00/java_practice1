package domain;/**
 * Created by Roger_yu on 2018/3/2.
 */


import java.util.Date;

/**
 * @author jiangxiangwen
 * @ClassName LogisticsInfo
 * @Description 物流信息表
 * @date 2018/3/2
 */
public class LogisticsInfo {
  /**
   * id 主键id
   */
  private Long id;

  /**
   * logistics_num 物流单号
   */
  private String logisticsNum;

  /**
   * logisticsTime 物流信息生成时间
   */
  private Date logisticsTime;

  /**
   * logistics_state 物流状态
   */
  private Byte logisticsState;

  /**
   * order_detail_id 订单详情表
   */
  private Long orderDetailId;

  /**
   * deliver_name 发货人姓名
   */
  private String deliverName;

  /**
   * deliver_phone 发货人电话
   */
  private String deliverPhone;

  /**
   * deliver_address 发货地址
   */
  private String deliverAddress;

  /**
   * consignee_name 收货人姓名
   */
  private String consigneeName;

  /**
   * consignee_phone 收货人电话
   */
  private String consigneePhone;

  /**
   * consignee_address 收货人地址
   */
  private String consigneeAddress;

  /**
   * message 备注信息 默认null
   */
  private String message;

  /**
   * userStar 用户评星 1-5 颗星 1-极差 2-差 3-一般 4-良 5-优 默认null
   */
  private Byte userStar;

  /**
   * userComment 用户评价内容 默认null
   */
  private String userComment;

  //get & set

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogisticsNum() {
    return logisticsNum;
  }

  public void setLogisticsNum(String logisticsNum) {
    this.logisticsNum = logisticsNum;
  }

  public Byte getLogisticsState() {
    return logisticsState;
  }

  public void setLogisticsState(Byte logisticsState) {
    this.logisticsState = logisticsState;
  }

  public Long getOrderDetailId() {
    return orderDetailId;
  }

  public void setOrderDetailId(Long orderDetailId) {
    this.orderDetailId = orderDetailId;
  }

  public String getDeliverName() {
    return deliverName;
  }

  public void setDeliverName(String deliverName) {
    this.deliverName = deliverName;
  }

  public String getDeliverPhone() {
    return deliverPhone;
  }

  public void setDeliverPhone(String deliverPhone) {
    this.deliverPhone = deliverPhone;
  }

  public String getDeliverAddress() {
    return deliverAddress;
  }

  public void setDeliverAddress(String deliverAddress) {
    this.deliverAddress = deliverAddress;
  }

  public String getConsigneeName() {
    return consigneeName;
  }

  public void setConsigneeName(String consigneeName) {
    this.consigneeName = consigneeName;
  }

  public String getConsigneePhone() {
    return consigneePhone;
  }

  public void setConsigneePhone(String consigneePhone) {
    this.consigneePhone = consigneePhone;
  }

  public String getConsigneeAddress() {
    return consigneeAddress;
  }

  public void setConsigneeAddress(String consigneeAddress) {
    this.consigneeAddress = consigneeAddress;
  }

  public Date getLogisticsTime() {
    return logisticsTime;
  }

  public void setLogisticsTime(Date logisticsTime) {
    this.logisticsTime = logisticsTime;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Byte getUserStar() {
    return userStar;
  }

  public void setUserStar(Byte userStar) {
    this.userStar = userStar;
  }

  public String getUserComment() {
    return userComment;
  }

  public void setUserComment(String userComment) {
    this.userComment = userComment;
  }
}
