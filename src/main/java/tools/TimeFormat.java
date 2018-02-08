package tools;/********************************************************************
 /**
 * @Project: hellow_test
 * @Package com.test0111
 * @author yanyong
 * @date 2018/1/15 0015 16:06
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Calendar;
import java.util.Date;

/**
 * @author yanyong
 * @ClassName TimeFormat
 * @Description 类描述
 * @date 2018/1/15 0015
 */
public class TimeFormat {

    /**
     * date 时间
     */
    private Date date;
    /**
     * year 年
     */
    private Integer year;

    /**
     * moth 月
     */
    private Integer month;

    /**
     * day 日
     */
    private Integer day;

    /**
     * hour 时
     */
    private Integer hour;

    /**
     * minute 分
     */
    private Integer minute;
    /**
     * second 秒
     */
    private Integer second;

    /**
     * week星期
     */
    private Integer week;

    private final static String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};


    //封装

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    //构造器
    public TimeFormat(Date date) {
        this.date = date;
        this.getAllTime();
    }

    public TimeFormat() {

    }

    public void getAllTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        this.week = calendar.get(Calendar.DAY_OF_WEEK);


    }

    /**
     * @Title: format
     * @Description: 格式话日期
     * @author yanyong
     * @date 2018-01-15
     * @throw YnCorpSysException
     */

    public String format(String formatStr) {
        String result = null;
        if (formatStr.equals("yyyy-MM-dd HH:mm:ss")) {
            result = this.year + "-" + this.month + "-" + this.day + " " + this.hour + ":" + this.minute + ":" + this.second + " " + weeks[this.week - 1];
            return result;
        } else if (formatStr.equals("yyyy-HH-dd")) {
            result = this.year + "-" + this.month + "-" + this.day;
            return result;
        } else if (formatStr.equals("HH:mm:ss")) {
            result = this.hour + ":" + this.minute + ":" + this.second;
            return result;
        } else {
            result = this.year + "/" + this.month + "/" + this.day + " " + this.hour + ":" + this.minute + ":" + this.second + " " + weeks[this.week - 1];
            return result;
        }
    }

    public String format() {
        String result = null;
        result = this.year + "/" + this.month + "/" + this.day + " " + this.hour + ":" + this.minute + ":" + this.second;
        return result;
    }

    /**
     * @Title: formatDate
     * @Description: 格式化日期 年月日
     * @author yanyong
     * @date 2018-01-15
     */
    public String formatDate() {
        String result = null;
        result = this.year + "-" + this.month + "-" + this.day;
        return result;
    }

    /**
     * @Title: main
     * @Description: 主函数
     * @author yanyong
     * @date 2018-1-15 16:23:33
     * @throw YnCorpSysException
     */

    public static void main(String[] args) {

//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(date));
//        Calendar calendar=Calendar.getInstance();
//        calendar.get
        Date date = new Date();
        TimeFormat timeFormat = new TimeFormat(date);
        String timeStr = timeFormat.format("yyyy/MM/dd HH:mm:ss");
        System.out.println(timeStr);

    }

}