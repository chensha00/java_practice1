package tools;/********************************************************************
 /**
 * @Project: hellow_test
 * @Package com.test0111
 * @author yanyong
 * @date 2018/1/13 0013 17:15
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author yanyong
 * @ClassName GoodsException
 * @Description 类描述
 * @date 2018/1/13 0013
 */
public class GoodsException extends Exception {
    //商品异常
    public GoodsException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public GoodsException() {
        super();
    }
}