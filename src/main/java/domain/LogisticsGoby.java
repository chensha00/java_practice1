package domain;/**
 * Created by Roger_yu on 2018/3/2.
 */


/**
 * @author jiangxiangwen
 * @ClassName LogisticsGoby.xml
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
  private Long logisticsnfoId;

  /**
   * gobyOrderby 物流过程顺序
   */
  private Integer gobyOrderby;

  /**
   * goby_address 经过地址
   */
  private String gobyAddress;

  //get & set


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getLogisticsnfoId() {
    return logisticsnfoId;
  }

  public void setLogisticsnfoId(Long logisticsnfoId) {
    this.logisticsnfoId = logisticsnfoId;
  }

  public Integer getGobyOrderby() {
    return gobyOrderby;
  }

  public void setGobyOrderby(Integer gobyOrderby) {
    this.gobyOrderby = gobyOrderby;
  }

  public String getGobyAddress() {
    return gobyAddress;
  }

  public void setGobyAddress(String gobyAddress) {
    this.gobyAddress = gobyAddress;
  }
}
