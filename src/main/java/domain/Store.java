package domain;/********************************************************************
 /**
 * @Project: java_practice
 * @Package domain
 * @author 胡志强
 * @date 2018/1/20 16:44
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author 胡志强
 * @ClassName Store
 * @Description 商铺实体类，对应的是数据库的store表
 * @date 2018/1/20
 */
public class Store {
    /**
     * id:主键
     */
    private Long id;
    /**
     * storeNum:商铺编号
     */
    private String storeNum;
    /**
     * storeName:商铺名称
     */
    private String storeName;
    /**
     * credit:商铺信誉度
     */
    private Long credit;
    /**
     * peopleId:人员信息外键
     * people:外键连接的People对象
     */
    private Long peopleId;

    private People people;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
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

    //构造方法

    public Store(Long id, String storeNum, String storeName, Long credit, Long peopleId, People people) {
        this.id = id;
        this.storeNum = storeNum;
        this.storeName = storeName;
        this.credit = credit;
        this.peopleId = peopleId;
        this.people = people;
    }

    public Store(String storeNum, String storeName, Long credit, People people) {
        this.storeNum = storeNum;
        this.storeName = storeName;
        this.credit = credit;
        this.peopleId = people.getId();
        this.people = people;
    }

    public Store(String storeNum, String storeName, Long credit, Long peopleId) {
        this.storeNum = storeNum;
        this.storeName = storeName;
        this.credit = credit;
        this.peopleId = peopleId;
    }

    public Store() {

    }

}