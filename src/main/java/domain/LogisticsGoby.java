package domain;/**
 * Created by Roger_yu on 2018/3/2.
 */


import tools.TimeFormat;

import java.util.Date;

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
   * gobyTime 到达时间
   */
  private String gobyTime;

  /**
   * goby_address 到达地址
   */
  private String gobyAddress;

  /**
   * message 备注信息
   */
  private String message;

  //get & set


  public Date getGobyTime() {
    return new Date(gobyTime);
  }

  public void setGobyTime(Date gobyTime) {
    TimeFormat timeFormat=new TimeFormat(gobyTime);
    timeFormat.format("yyyy-MM-dd HH:mm:ss");
    this.gobyTime = timeFormat.format("yyyy-MM-dd HH:mm:ss");
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

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
