package tools;/********************************************************************
 /**
 * @Project: hellow_java
 * @Package src.tools
 * @author liukang
 * @date 2018/1/18 21:29
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liukang
 * @ClassName TimeConversion
 * @Description 时间转换工具
 * @date 2018/1/18
 */
public class TimeConversion {
    /**
     * 设置时间格式为静态常量
     */
    public static final String dateFormat = "yyyy-MM-dd HH:mm:ss";


    /**
     * @param time 输入时间
     * @Title: getNewDate
     * @Description: 时间转换
     * @author liukang
     * @date 2018-1-16 09:26:49
     * @throw Exception
     */
    public static String getNewDate(Date time) throws Exception {
        Exception e = new Exception();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            String dateString = simpleDateFormat.format(time);
            return dateString;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return time.toString();
    }


}