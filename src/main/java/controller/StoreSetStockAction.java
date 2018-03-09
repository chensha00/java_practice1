package controller;/**
 * Created by Roger_yu on 2018/3/9.
 */

import common.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 * @author yuweiyang
 * @ClassName StoreSetStockAction
 * @Description 类描述
 * @date 2018/3/9
 */
@Action(value = "storeSetStockAction")
@Results({
        @Result( name="storeSetStock",location="/store_set_stock.jsp")
})
@AllowedMethods({"storeSetStock"})
public class StoreSetStockAction  extends BaseAction {
    /**
     * @Title:
     * @Description: 进货页面方法
     * @author yuweiyang
     * @date
     */
    public String storeSetStock(){
        return "storeSetStock";
    }
}