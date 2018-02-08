package domain;/********************************************************************
 /**
 * @Project: java_practice
 * @Package domain
 * @author yanyong
 * @date 2018/1/20 0020 16:54
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author yanyong
 * @ClassName Goods
 * @Description 商品类 实体
 * @date 2018/1/20 0020
 */
public class Goods {

    /**
     * id 主键
     */
    private Long id;

    /**
     * goodsNum 商品编号
     */
    private String goodsNum;

    /**
     * name 商品名字
     */
    private String name;

    /**
     * type 商品类型 0--电脑 1--清洁用品 2--运动器材 3--服装
     */
    private Byte type;

    /**
     * unit 单位
     */
    private String unit;

    /**
     * procedureDate 生产日期 yyyy-MM-dd HH:mm:ss
     */
    private Date procedureDate;

    /**
     * shelfLife 保质期
     */
    private Float shelfLife;

    /**
     * shelfLifeUnit 保质期单位 0--小时 1--天 2--月 3--年
     */
    private Byte shelfLifeUnit;

    //封装


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getProcedureDate() {
        return procedureDate;
    }

    public void setProcedureDate(Date procedureDate) {
        this.procedureDate = procedureDate;
    }

    public Float getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Float shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Byte getShelfLifeUnit() {
        return shelfLifeUnit;
    }

    public void setShelfLifeUnit(Byte shelfLifeUnit) {
        this.shelfLifeUnit = shelfLifeUnit;
    }

    //构造方法

    public Goods(Long id, String goodsNum, String name, Byte type, String unit, Date procedureDate, Float shelfLife, Byte shelfLifeUnit) {
        this.id = id;
        this.goodsNum = goodsNum;
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.procedureDate = procedureDate;
        this.shelfLife = shelfLife;
        this.shelfLifeUnit = shelfLifeUnit;
    }

    public Goods(String goodsNum, String name, Byte type, String unit, Date procedureDate, Float shelfLife, Byte shelfLifeUnit) {
        this.goodsNum = goodsNum;
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.procedureDate = procedureDate;
        this.shelfLife = shelfLife;
        this.shelfLifeUnit = shelfLifeUnit;
    }

    public Goods() {

    }
}