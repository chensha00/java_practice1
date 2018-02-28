package javabean;/********************************************************************
 /**
 * @Project: bigstar_online_mall
 * @Package domain
 * @author liukang
 * @date 2018/1/31 21:10
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author liukang
 * @ClassName MainPage
 * @Description 虚拟实体类
 * @date 2018/1/31
 */
public class MainPage {

    /**
     * price 商品价格
     */
    private Double price;

    /**
     * name 商品名称
     */
    private String name;

    /**
     * number 商品库存
     */
    private Double number;

    /**
     * storeName 店铺名称
     */
    private String storeName;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public MainPage() {
    }
}