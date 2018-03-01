package service;/**
 * Created by HS on 2018/1/20.
 */

import domain.People;
import tools.GoodsException;
import tools.GoodsOrderException;
import tools.PeopleException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author shangzhiqian
 * @InterfaceName PeopleService
 * @Description 接口描述
 * @date 2018/1/20
 */
public interface PeopleService {
//    public List<People> getPeopleAll();

    /**
     * @Title: findPeopleById
     * @Description: 通过指定Id查找人员
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 人员对象
     */
    public People findPeopleById(Long id);


    public List<People> getAllPeople();


    /**
     * @Title: findPeopleByUserName
     * @Description: 查找用户根据用户名和密码
     * @author yanyong
     * @date 2018-01-30
     * @param: userName 用户名
     * @param: password 密码
     * @return: 人员对象
     */
    public People findPeopleByUserName(String userName, String password);


    /**
     * @Title: savePeople
     * @Description: 保存人员信息
     * @author yanyong
     * @date 2018-01-21
     * @param: people 人员对象
     * @return: 受影响行数
     */
    public Integer savePeople(People people);

    /**
     * @Title: showPeople
     * @Description: 查看人员信息
     * @author yanyong
     * @date 2018-01-21
     * @param: people 人员对象
     */
    public void showPeople(People people);

    /**
     * @Title: deletePeopleById
     * @Description: 删除指定id 的人员信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 受影响行数
     */
    public Integer deletePeopleById(Long id);

    /**
     * @Title: updatePeople
     * @Description: 更新指定人员的信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定人员id
     * @param: people 指定人员信息
     * @return: 受影响行数
     */
    public Integer updatePeople(People people);


    /**
     * @Title: receivedGoods
     * @Description: 接收订购商品
     * @author yanyong
     * @date 2018-01-23
     * @param: goods 商品
     * @param: isRecv 是否收货
     * @return: 是否收货
     */
    public Boolean receivedGoods(Long orderDetailId, Boolean isRecv) throws PeopleException;

    /**
     * @Title: buyGoods
     * @Description: 批量购买商品
     * @author yanyong
     * @date 2018-01-23
     * @param: peopleId 购买人员id
     * @param: goodsList 商品集合
     * @param: buyNumList 购买数量集合
     */
    public void buyGoods(long peopleId, List<Long> idList, List<Double> buyNumList) throws PeopleException, GoodsException;

    /**
     * @Title: judgeMoneyIsEnough
     * @Description: 判断人员余额是否足够
     * @author yanyong
     * @date 2018-01-23
     * @param: id 人员id
     * @param: needMoney 需要花费的金额
     * @return: 余额是否足够 false--否，true--是
     */
    public Boolean judgeMoneyIsEnough(Long id, Double needMoney);

    /**
     * @Title: payGoodsMoneyById
     * @Description: 支付指定订单购物金额
     * @author yanyong
     * @date 2018-01-28
     * @param: id 指定id
     * @return:
     */
    public Boolean payGoodsMoneyByOrderId(Long peopleId, Long orderId) throws GoodsException, GoodsOrderException;

    /**
     * @Title: descMoney
     * @Description: 减少金额，对指定人员id
     * @author yanyong
     * @date 2018-01-28
     * @param: peopleId 指定人员id
     * @param: money 金额数
     * @return: 是否减少成功
     */

    public Boolean descMoney(Long peopleId, Double money);

    /**
     * @Title: ascMoney
     * @Description: 增加金额，对指定人员id
     * @author yanyong
     * @date 2018-01-28
     * @param: peopleId 指定人员id
     * @param: money 金额数
     * @return: 是否增加成功
     */
    public Boolean ascMoney(Long peopleId, Double money);
    /**
     * @Title: findPeopleByUnSureCondition
     * @Description: 方法描述
     * @author hzq
     * @date 2018/01/30
     * @param map 条件和值对应key和value
     * @throw SQLException
     */
    public List<People> findPeopleByUnSureCondition(List<Map<String, Object>> map)
            throws SQLException;

}
