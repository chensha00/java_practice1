package tools;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package tools
 * @author kang
 * @date 2018/3/9 11:23
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kang
 * @ClassName limitMethod
 * @Description 分页
 * @date 2018/3/9
 */
@Transactional
public class LimitMethod {

    /**
     * @param present1 当前页面
     * @param total1   总页数
     * @param page     点击参数
     * @param totalNum 查询表总条数
     * @Title: limitMethod
     * @Description: 分页方法
     * @author kang
     * @date 2018-03-09
     * @throw YnCorpSysException
     */
    public static Map limitMethods(String present1, String total1, String page, Integer totalNum) {
        Map map = new HashMap<>();
        Long start = 0l;
        Long end = 0l;
        Integer present = Integer.valueOf(present1);
        Integer total = Integer.valueOf(total1);
        out:
        if (page.equals("start")) {
            end = 20l;
            break out;
        } else if (page.equals("last")) {
            if (present > 1) {
                start = Long.valueOf((present - 2) * 20);
                end = Long.valueOf((present - 1) * 20);
                break out;
            } else {
                end = 20l;
                break out;
            }
        } else if (page.equals("next")) {
            if (present < total - 1) {
                start = Long.valueOf(present * 20);
                end = Long.valueOf((present + 1) * 20);
                break out;
            } else {
                start = Long.valueOf((total - 1) * 20);
                end = Long.valueOf(totalNum);
                break out;
            }
        } else if (page.equals("end")) {
            start = Long.valueOf((total - 1) * 20);
            end = Long.valueOf(totalNum);
            break out;
        } else {
            Integer number = Integer.valueOf(page);
            if (number < total && number > 0) {
                start = Long.valueOf((number - 1) * 20);
                end = Long.valueOf(number * 20);
                break out;
            } else if (number == total) {
                start = Long.valueOf((total - 1) * 20);
                end = Long.valueOf(totalNum);
                break out;
            } else {
                start = Long.valueOf((present - 2) * 20);
                end = Long.valueOf((present - 1) * 20);
                break out;
            }
        }
        Long aLong = start / 20 + 1;
        present = Integer.parseInt(String.valueOf(aLong));
        map.put("start", start);
        map.put("end", end);
        map.put("total", total);
        map.put("present", present);
        return map;
    }
}