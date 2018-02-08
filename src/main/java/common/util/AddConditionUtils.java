package common.util;/********************************************************************
 /**
 * @Project: jsp_web
 * @Package common.util
 * @author 胡志强
 * @date 2018/1/30 17:33
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AddConditionUtils
 * @Description 不确定条件查询中添加条件的帮助方法
 * @author 胡志强
 * @date 2018/1/30
*/
public class AddConditionUtils {
    /**
     * @Title: addCondition
     * @Description: 添加条件
     * @author hzq
     * @date 2017/01/30
     */
    public static Map<String,Object> addCondition(String str1,String str2,Object obj){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name",str1);
        map.put("rela",str2);
        map.put("value",obj);
        return map;
    }
}