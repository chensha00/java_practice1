package service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package service
 * @author yanyong
 * @date 2018/1/20 0020 16:58
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import dao.GoodsDao;
import domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.GoodsTypeEnum;
import tools.TimeFormat;

import java.util.List;

/**
 * @author yanyong
 * @ClassName GoodsServiceImpl
 * @Description 商品 操作类 实现GoodsService 接口
 * @date 2018/1/20 0020
 */
@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;// = new GoodsDaoImpl();
    /**
     * @Title: findGoodsById
     * @Description: 查找指定id商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 商品对象
     */
    @Override
    public Goods findGoodsById(Long id){
        return goodsDao.findGoodsById(id);
    }
//    public Goods findGoodsById(Long id) {
//        Goods goods=null;
//
//        return goodsDao.findGoodsById(id);
//
//        return goods;


//        //定义商品独享
//        Goods goods = null;
//        //定义连接对象
//        Connection conn = null;
//        //定义预编译Statement对象
//        PreparedStatement preparedStatement = null;
//        // 1.创建自定义连接池对象
//        DataSource dataSource = new DataSourceUtils();
//        try {
//            //获取连接对象
//            conn = dataSource.getConnection();
//            //关闭连接 自动提交
//            conn.setAutoCommit(false);
//            goods = goodsDao.findGoodsById(id, conn, preparedStatement);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            //释放连接资源
//            JdbcUtils.release(conn, preparedStatement, null);
//            //返回商品对象
//            return goods;
//        }
//    }
    public List<Goods> findGoodsAll(){
        return goodsDao.findGoodsAll();
    }


    /**
     * @Title: saveGoods
     * @Description: 保存商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: goods 商品信息
     * @return: 受影响行数
     */
    @Override
    public Integer saveGoods(Goods goods){
        return goodsDao.saveGoods(goods);
    }
//    public Integer saveGoods(Goods goods) {
//        //定义商品独享
//        Integer number = 0;
//        //定义连接对象
//        Connection conn = null;
//        //定义预编译Statement对象
//        PreparedStatement preparedStatement = null;
//        // 1.创建自定义连接池对象
//        DataSource dataSource = new DataSourceUtils();
//        try {
//            //获取连接对象
//            conn = dataSource.getConnection();
//            //关闭连接 自动提交
//            conn.setAutoCommit(false);
//            number = goodsDao.saveGoods(goods);
//        } catch (SQLException e) {
//            //回滚
//            conn.rollback();
//            e.printStackTrace();
//        } finally {
//            //释放连接资源
//            JdbcUtils.release(conn, preparedStatement, null);
//            //返回受影响行数
//            return number;
//        }
//    }

    /**
     * @Title: deleteGoodsById
     * @Description: 删除指定id的商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 受影响行数
     */
    @Override
    public Integer deleteGoodsById(Long id) {
        return goodsDao.deleteGoodsById(id);
    }
//    public Integer deleteGoodsById(Long id) {
//        //定义商品独享
//        Integer number = 0;
//        //定义连接对象
//        Connection conn = null;
//        //定义预编译Statement对象
//        PreparedStatement preparedStatement = null;
//        // 1.创建自定义连接池对象
//        DataSource dataSource = new DataSourceUtils();
//        try {
//            //获取连接对象
//            conn = dataSource.getConnection();
//            //关闭连接 自动提交
//            conn.setAutoCommit(false);
//            number = goodsDao.deleteGoodsById(id);
//
//        } catch (SQLException e) {
//            //回滚
//            conn.rollback();
//            e.printStackTrace();
//        } finally {
//            //释放连接资源
//            JdbcUtils.release(conn, preparedStatement, null);
//            //返回受影响行数
//            return number;
//        }
//    }

    /**
     * @Title: updateGoodsById
     * @Description: 更新指定id商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @param: goods 商品信息
     * @return: 受影响行数
     */
    @Override
    public Integer updateGoods(Goods goods){
        return goodsDao.updateGoods(goods);
    }
//    public Integer updateGoodsById(Long id, Goods goods) {
//        //定义商品独享
//        Integer number = 0;
//        //定义连接对象
//        Connection conn = null;
//        //定义预编译Statement对象
//        PreparedStatement preparedStatement = null;
//        Goods oldGoods = this.findGoodsById(id);
//        if (goods.getName() != null) {
//            oldGoods.setName(goods.getName());
//        }
//        //ID,GOODS_NUM,`NAME`,TYPE,PRICE,UNIT,NUMBER,PROCEDURE_DATE,SHELF_LIFE,SHELF_LIFE_UNIT,STORE_ID
//        if (goods.getType() != null) {
//            oldGoods.setType(goods.getType());
//        }
//        if (goods.getUnit() != null) {
//            oldGoods.setUnit(goods.getUnit());
//        }
//        if (goods.getProcedureDate() != null) {
//            oldGoods.setProcedureDate(goods.getProcedureDate());
//        }
//        if (goods.getShelfLife() != null) {
//            oldGoods.setShelfLife(goods.getShelfLife());
//        }
//        if (goods.getShelfLifeUnit() != null) {
//            oldGoods.setShelfLifeUnit(goods.getShelfLifeUnit());
//        }
//        // 1.创建自定义连接池对象
//        DataSource dataSource = new DataSourceUtils();
//        try {
//            //获取连接对象
//            conn = dataSource.getConnection();
//            //关闭连接 自动提交
//            conn.setAutoCommit(false);
//            number = goodsDao.updateGoodsById(id, oldGoods);
//        } catch (SQLException e) {
//            //回滚
//            conn.rollback();
//            e.printStackTrace();
//        } finally {
//            //释放连接资源
//            JdbcUtils.release(conn, preparedStatement, null);
//            //返回受影响行数
//            return number;
//        }
//    }

    /**
     * @Title: showGoods
     * @Description: 查看商品信息
     * @author yanyong
     * @date 2018-01-21
     * @param: goods 商品对象
     */
    @Override
    public void showGoods(Goods goods) {
        System.out.print("主键ID:" + goods.getId() + " ");
        System.out.print("商品编号:" + goods.getGoodsNum() + " ");
        System.out.print("名称:" + goods.getName() + " ");
        System.out.print("类型:" + GoodsTypeEnum.findGoodsTypeByIndex(goods.getType()) + " ");
        System.out.print("单位:" + goods.getUnit() + " ");
        System.out.print("生产时间:" + new TimeFormat(goods.getProcedureDate()).format() + " ");
        System.out.print("保质期:" + goods.getShelfLife() + " ");
        System.out.print("保质期单位:" + goods.getShelfLifeUnit() + " ");
        System.out.println();
    }

//    /**
//     * @Title: changeGoodsNumberById
//     * @Description: 修改指定id的商品数量
//     * @author yanyong
//     * @date 2018-01-22
//     * @param: id 指定id
//     * @param: number 商品数量
//     * @return: 修改行数
//     */
//    @Override
//    public Integer changeGoodsNumberById(Long id, Double number) {
//        Goods goods = new Goods();
//        Integer num = 0;
//        goods.setNumber(number);
//        num = this.updateGoodsById(id, goods);
//        return num;
//    }

//    /**
//     * @Title: stock
//     * @Description: 商品进货
//     * @author yanyong
//     * @date 2018-01-22
//     * @param: id 对指定id的商品进货
//     * @param: addNum 进货数量
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer stock(Long id, Double addNum) {
//        Goods goods = this.findGoodsById(id);
//        Integer number = this.changeGoodsNumberById(id, goods.getNumber() + addNum);
//        return number;
//    }

//    /**
//     * @Title: sale
//     * @Description: 出售商品
//     * @author yanyong
//     * @date 2018-01-22
//     * @param: id 对指定id的商品出售
//     * @param: saleNum 出售数量
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer sale(Long id, Double saleNum) throws GoodsException {
//        Goods goods = this.findGoodsById(id);
//        Integer number = 0;
//        if (goods == null) {
//            throw new GoodsException("商品不存在");
//        } else {
//            if (goods.getNumber() < saleNum) {
//                throw new GoodsException("商品数量不够，无法售卖");
//            } else {
//                number = this.changeGoodsNumberById(id, goods.getNumber() - saleNum);
//                return number;
//            }
//        }
//    }

//    /**
//     * @Title: calculationMoney
//     * @Description: 计算商品金额
//     * @author yanyong
//     * @date 2018-01-22
//     * @param: goods 商品
//     * @param: num 数量
//     * @return: 计算金额
//     */
//    public Double calculationMoney(Goods goods, Double num) {
//        return goods.getPrice() * num;
//    }

//    /**
//     * @Title: judgeNumberIsEnough
//     * @Description: 判断数量是否足够
//     * @author yanyong
//     * @date 2018-01-23
//     * @param: id 指定id
//     * @param: needNumber 需要数量
//     * @return: 数量是否足够，false--否，true--是
//     */
//    @Override
//    public Boolean judgeNumberIsEnough(Long id, Double needNumber) {
//        Goods goods=this.findGoodsById(id);
//        if (goods.getNumber()>=needNumber){
//            return true;
//        }else {
//            return false;
//        }
//    }
}