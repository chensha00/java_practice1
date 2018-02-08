package tools;/********************************************************************
 /**
 * @Project: hellow_test
 * @Package com.test0111
 * @author yanyong
 * @date 2018/1/13 0013 17:18
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author yanyong
 * @ClassName PersonException
 * @Description 购买商品 异常
 * @date 2018/1/13 0013
 */
public class PeopleException extends Exception {
    //构造器
    public PeopleException() {
        super();
    }

    public PeopleException(String exceptionMessage) {
        super(exceptionMessage);
    }
}