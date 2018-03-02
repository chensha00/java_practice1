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
  private String logistics_num;

  /**
   * logistics_state 物流状态
   */
  private Long logistics_state;

  /**
   * order_detail_id 订单详情表
   */
  private Long order_detail_id;

  /**
   * deliver_name 发货人姓名
   */
  private String deliver_name;

  /**
   * deliver_phone 发货人电话
   */
  private String deliver_phone;

  /**
   * deliver_address 发货地址
   */
  private String deliver_address;

  /**
   * consignee_name 收货人姓名
   */
  private String consignee_name;

  /**
   * consignee_phone 收货人电话
   */
  private String consignee_phone;

  /**
   * consignee_address 收货人地址
   */
  private String consignee_address;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogistics_num() {
    return logistics_num;
  }

  public void setLogistics_num(String logistics_num) {
    this.logistics_num = logistics_num;
  }

  public Long getLogistics_state() {
    return logistics_state;
  }

  public void setLogistics_state(Long logistics_state) {
    this.logistics_state = logistics_state;
  }

  public Long getOrder_detail_id() {
    return order_detail_id;
  }

  public void setOrder_detail_id(Long order_detail_id) {
    this.order_detail_id = order_detail_id;
  }

  public String getDeliver_name() {
    return deliver_name;
  }

  public void setDeliver_name(String deliver_name) {
    this.deliver_name = deliver_name;
  }

  public String getDeliver_phone() {
    return deliver_phone;
  }

  public void setDeliver_phone(String deliver_phone) {
    this.deliver_phone = deliver_phone;
  }

  public String getDeliver_address() {
    return deliver_address;
  }

  public void setDeliver_address(String deliver_address) {
    this.deliver_address = deliver_address;
  }

  public String getConsignee_name() {
    return consignee_name;
  }

  public void setConsignee_name(String consignee_name) {
    this.consignee_name = consignee_name;
  }

  public String getConsignee_phone() {
    return consignee_phone;
  }

  public void setConsignee_phone(String consignee_phone) {
    this.consignee_phone = consignee_phone;
  }

  public String getConsignee_address() {
    return consignee_address;
  }

  public void setConsignee_address(String consignee_address) {
    this.consignee_address = consignee_address;
  }
}
