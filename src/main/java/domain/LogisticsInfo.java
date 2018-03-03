package domain;/**
 * Created by Roger_yu on 2018/3/2.
 */


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
}
