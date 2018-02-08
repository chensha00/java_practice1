package servlet;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package servlet
 * @author yanyong
 * @date 2018/2/6 0006 23:54
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.SpringContextUtil;
import domain.Goods;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yanyong
 * @ClassName GoodsServiceServlet
 * @Description 类描述
 * @date 2018/2/6 0006
 */
public class GoodsServiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        GoodsService goodsService= (GoodsService) SpringContextUtil.getBean("goodsService");
        List<Goods> goodsList=goodsService.findGoodsAll();
        for (int i=0;i<goodsList.size();i++){
            goodsService.showGoods(goodsList.get(i));
        }
    }
}