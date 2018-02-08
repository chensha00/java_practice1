package tools;/********************************************************************
 /**
 * @Project: hellow_test
 * @Package com.test0111
 * @author yanyong
 * @date 2018/1/13 0013 16:29
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author yanyong
 * @EnumName StateEnum
 * @Description 状态枚举
 * @date 2018/1/13 0013
 */
public enum StateEnum {

    WAIT_PAY((byte) 0, "未支付"), PAY_SUCCESS((byte) 1, "支付成功"), PAY_FAIL((byte) 2, "支付失败"), SEND((byte) 3, "发货中"), RECEIVE((byte) 4, "订单完成");

    /**
     * index 状态值
     */
    private Byte index;

    /**
     * state 状态
     */
    private String state;

    //封装
    public Byte getIndex() {
        return index;
    }

    public void setIndex(Byte index) {
        this.index = index;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //构造方法

    StateEnum(Byte index, String state) {
        this.index = index;
        this.state = state;
    }

    /**
     * @Title: findStateByIndex
     * @Description: 根据状态值查询状态
     * @param: index 状态值
     * @return: 状态
     * @author yanyong
     * @date 2018-01-13
     * @throw YnCorpSysException
     */
    public static String findStateByIndex(Byte index) {
        for (StateEnum stateEnum : StateEnum.values()) {
            if (stateEnum.getIndex() == index) {
                return stateEnum.getState();
            }
        }
        return null;
    }

}