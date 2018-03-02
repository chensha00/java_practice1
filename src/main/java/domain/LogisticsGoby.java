package domain;/**
 * Created by Roger_yu on 2018/3/2.
 */


/**
 * @author jiangxiangwen
 * @ClassName LogisticsGoby
 * @Description 物流过程表
 * @date 2018/3/2
 */
public class LogisticsGoby {
  /**
   * id 主键id
   */
  private Long id;

  /**
   * logistics_info_id 物流信息表 外键
   */
  private Long logistics_info_id;

  /**
   * goby_address 经过地址
   */
  private String goby_address;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getLogistics_info_id() {
    return logistics_info_id;
  }

  public void setLogistics_info_id(Long logistics_info_id) {
    this.logistics_info_id = logistics_info_id;
  }

  public String getGoby_address() {
    return goby_address;
  }

  public void setGoby_address(String goby_address) {
    this.goby_address = goby_address;
  }
}
