package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author yanyong
 * @date 2018/1/21 0021 17:49
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.Goods;
import domain.Invertory;
import domain.People;
import domain.Store;
import tools.GoodsException;
import tools.GoodsOrderException;
import tools.PeopleException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyong
 * @ClassName TestPeopleService
 * @Description 类描述
 * @date 2018/1/21 0021
 */
public class TestPeopleService {

    /**
     * @Title: main
     * @Description: 主函数
     * @author yanyong
     * @date
     * @throw YnCorpSysException
     */

    public static void main(String[] args) {
        PeopleService peopleService = new PeopleServiceImpl();
//        People people=new People(23L,"王五","3894345993","女",23,39549.55,"中国北京");
//        People people1=new People("王四","3894345993","女",23,39549.55,"中国北京");
//        System.out.println(peopleService.savePeople(people1));

//        Long id=1L;
//        People people=peopleService.findPeopleById(id);
//        peopleService.showPeople(people);

//        Long id=1L;
//        System.out.println(peopleService.deletePeopleById(id));

//        People people = new People();
//        people.setName("kagk");
//        people.setMoney(389495.23);
//        people.setAge(99);
//        System.out.println(peopleService.updatePeopleById(27L, people));

//        People people1=new People("zhangsan","8934589291","男",23,100000d,"四川成都");
//        People people2=new People("zhangsan","8957889292","男",23,100000d,"四川成都");
//        People people3=new People("zhangsan","8955892930","女",23,100000d,"四川成都");
//        People people4=new People("zhangsan","8295789294","男",23,100000d,"四川成都");
//        People people5=new People("zhangsan","8925898295","男",23,100000d,"四川成都");
//
//        peopleService.savePeople(people1);
//        peopleService.savePeople(people2);
//        peopleService.savePeople(people3);
//        peopleService.savePeople(people4);
//        peopleService.savePeople(people5);
//        System.out.println(peopleService.savePeople(people1));



        //购买商品
//        List<Long> idList=new ArrayList<Long>();
//        idList.add(1L);
//        idList.add(2L);
//        List<Double> buyNumList =new ArrayList<Double>();
//        buyNumList.add(13d);
//        buyNumList.add(14d);
//        try {
//            peopleService.buyGoods(2,idList,buyNumList);
//        } catch (PeopleException e) {
//            e.printStackTrace();
//        } catch (GoodsException e) {
//            e.printStackTrace();
//        }

//        //支付订单
//        try {
//            //支付订单
//            System.out.println(peopleService.payGoodsMoneyByOrderId(2L,8L));
//        } catch (GoodsException e) {
//            e.printStackTrace();
//        } catch (GoodsOrderException e) {
//            e.printStackTrace();
//        }


        try {
            peopleService.receivedGoods(10L,true);
        } catch (PeopleException e) {
            e.printStackTrace();
        }
//        GoodsService goodsService=new GoodsServiceImpl();
//        Goods goods=goodsService.findGoodsById(2L);
//        goodsService.showGoods(goods);

//        InvertoryService invertoryService=new InvertoryServiceImpl();
//        Invertory invertory=invertoryService.findInvertoryById(2L);
//        invertoryService.showInvertory(invertory);

//        StoreService storeService =new StoreServiceImpl();
//        Store store=storeService.findStoreById(1L);
//        storeService.showStore(store);
//

//

    }

}