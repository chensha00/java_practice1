package domain;/********************************************************************
 /**
 * @Project: java_practice
 * @Package domain
 * @author liukang
 * @date 2018/1/25 16:56
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author liukang
 * @ClassName Inventory
 * @Description 库存实体类
 * @date 2018/1/25
 */
public class Invertory {

    /**
     * id 主键
     */
    private Long id;
    /**
     * storeId 店铺外键
     */
    private Long storeId;
    /**
     * store 店铺（对象）
     */
    private Store store;
    /**
     * goodsId 商品外键
     */
    private Long goodsId;
    /**
     * goods 商品（对象）
     */
    private Goods goods;
    /**
     * price 单价 单位（元）
     */
    private Double price;
    /**
     * number 库存数量
     */
    private Double number;

    //封装

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    //构造

    public Invertory() {
    }

    public Invertory(Long id, Long storeId, Store store, Long goodsId, Goods goods, Double price, Double number) {
        this.id = id;
        this.storeId = storeId;
        this.store = store;
        this.goodsId = goodsId;
        this.goods = goods;
        this.price = price;
        this.number = number;
    }

    public Invertory(Long storeId, Store store, Long goodsId, Goods goods, Double price, Double number) {
        this.storeId = storeId;
        this.store = store;
        this.goodsId = goodsId;
        this.goods = goods;
        this.price = price;
        this.number = number;
    }

    public Invertory(Store store, Goods goods, Double price, Double number) {
        this.storeId = store.getId();
        this.store = store;
        this.goodsId = goods.getId();
        this.goods = goods;
        this.price = price;
        this.number = number;
    }

    public Invertory(Long storeId, Long goodsId, Double price, Double number) {
        this.storeId = storeId;
        this.goodsId = goodsId;
        this.price = price;
        this.number = number;
    }
}