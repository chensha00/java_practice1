package tools;/********************************************************************
 /**
 * @Project: java_practice
 * @Package tools
 * @author yanyong
 * @date 2018/1/21 0021 22:55
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author yanyong
 * @EnumName GoodsTypeEnum
 * @Description 商品类型枚举
 * @date 2018/1/21 0021
 */
public enum GoodsTypeEnum {

    //    ype 商品类型 0--电脑 1--清洁用品 2--运动器材 3--服装
    COMPUTER((byte) 0, "电脑"), CLEAN((byte) 1, "清洁用品"), SPORT((byte) 2, "运动器材"), CLOTH((byte) 3, "服装");

    /**
     * index 商品类型值
     */
    private Byte index;

    /**
     * type 商品类型
     */
    private String type;

    //封装
    public Byte getIndex() {
        return index;
    }

    public void setIndex(Byte index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //构造方法


    GoodsTypeEnum(Byte index, String type) {
        this.index = index;
        this.type = type;
    }

    GoodsTypeEnum() {

    }

    public static String findGoodsTypeByIndex(Byte index) {
        for (GoodsTypeEnum goodsTypeEnum : GoodsTypeEnum.values()) {
            if (goodsTypeEnum.getIndex() == index) {
                return goodsTypeEnum.getType();
            }
        }
        return null;
    }
}