package service;/********************************************************************
 /**
 * @Project: bigstar_online_mall
 * @Package service
 * @author liukang
 * @date 2018/2/2 17:29
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import javabean.MainPage;

import java.util.List;

/**
 * @author liukang
 * @ClassName TestMain
 * @Description 类描述
 * @date 2018/2/2
 */
public class TestMain {
    public static void main(String[] args) {
        InvertoryService invertoryService = new InvertoryServiceImpl();
        List<javabean.MainPage> list = invertoryService.findMainPageInvertory();
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}