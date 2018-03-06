package tools;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package tools
 * @author kang
 * @date 2018/3/5 19:08
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author kang
 * @ClassName StringToArray
 * @Description 字符串转换为数组
 * @date 2018/3/5
 */
public class StringToArray {

    private String string;

    public static List<Long> toArrayLong(String string) {
        ArrayList<Long> list = new ArrayList<Long>();
        String[] str1 = string.split(",");
        Long[] str2 = new Long[str1.length];
        for (int i = 0; i < str1.length; i++) {
            str2[i] = Long.valueOf(str1[i]);
            list.add(str2[i]);
        }
        return list;
    }

    public static List<Double> toArrayDouble(String string) {
        ArrayList<Double> list = new ArrayList<Double>();
        String[] str1 = string.split(",");
        Double[] str2 = new Double[str1.length];
        for (int i = 0; i < str1.length; i++) {
            str2[i] = Double.valueOf(str1[i]);
            list.add(str2[i]);
        }
        return list;
    }
}