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
     * @param page     点击参数
     * @param totalNum 查询表总条数
     * @Title: limitMethod
     * @Description: 分页方法
     * @author kang
     * @date 2018-03-09
     * @throw YnCorpSysException
     */
    public static Map limitMethods(String present1, String page, Integer totalNum) {
        Map map = new HashMap<>();
        int start = 0;
        int end = 0;
        int total = 0;
        Integer present = Integer.valueOf(present1);
        if (totalNum <= 20) {
            start = 0;
            end = totalNum;
            total = 1;
            present = 1;
        } else {
            total = totalNum / 20 + 1;
            out:
            if (page.equals("start")) {
                end = 20;
                break out;
            } else if (page.equals("last")) {
                if (present > 1) {
                    start = (present - 2) * 20;
                    end = (present - 1) * 20;
                    break out;
                } else {
                    end = 20;
                    break out;
                }
            } else if (page.equals("next")) {
                if (present < total - 1) {
                    start = present * 20;
                    end = (present + 1) * 20;
                    break out;
                } else {
                    start = (total - 1) * 20;
                    end = totalNum;
                    break out;
                }
            } else if (page.equals("end")) {
                start = (total - 1) * 20;
                end = totalNum;
                break out;
            } else {
                Integer number = Integer.valueOf(page);
                if (number < total && number > 0) {
                    start = (number - 1) * 20;
                    end = number * 20;
                    break out;
                } else if (number == total) {
                    start = (total - 1) * 20;
                    end = totalNum;
                    break out;
                } else {
                    start = (present - 2) * 20;
                    end = (present - 1) * 20;
                    break out;
                }
            }
            int aLong = start / 20 + 1;
            present = Integer.parseInt(String.valueOf(aLong));
        }
        map.put("start", start);
        map.put("end", end);
        map.put("total", total);
        map.put("present", present);
        return map;
    }
}