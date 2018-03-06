package tools;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package tools
 * @author kang
 * @date 2018/2/28 17:34
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import dao.InvertoryDao;
import dao.InvertoryDaoImpl;

/**
 * @author kang
 * @ClassName test
 * @Description 类描述
 * @date 2018/2/28
 */
public class test {
    public static void main(String[] args) {
        InvertoryDao invertoryDao=new InvertoryDaoImpl();
        Long a=1L;
        invertoryDao.findInvertoryById(a);
    }
}