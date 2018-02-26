package dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package dao
 * @author yanyong
 * @date 2018/1/20 0020 16:56
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.base.BaseDaoImpl;
import domain.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yanyong
 * @ClassName GoodsDaoImpl
 * @Description 商品数据库操作，实现GoodsDao 接口
 * @date 2018/1/20 0020
 */
@Repository("goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao {

    @Override
    public List<Goods> findGoodsById(Long id) {
        //查询所有的商品
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "getAll");
    }

    @Override
    public List<Goods> findGoodsAll() {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "getAll");
    }

    @Override
    public Integer saveGoods(Goods goods) {
        this.sqlSessionTemplate.insert(getMybaitsNameSpace() + "add", goods);
        return null;
    }

    @Override
    public Integer deleteGoodsById(Long id) {


        return null;
    }

    @Override
    public Integer updateGoodsById(Long id, Goods goods) {
        return null;
    }
}


//@Repository("goodsDao")
//public class GoodsDaoImpl implements GoodsDao {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    /**
//     * @Title: findGoodsById
//     * @Description: 查找指定id商品信息
//     * @author yanyong
//     * @date 2018-01-21
//     * @throws: SQLException
//     * @param: id 指定id
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement
//     * @return: 商品对象
//     */
//    @Override
//    public List<Goods> findGoodsById(Long id) throws SQLException {
//        return null;
//    }
//
//
////    public Goods findGoodsById(Long id) throws SQLException {
////        //定义商品对象
////        Goods goods = new Goods();
////        //定义结果集合
////        ResultSet resultSet = null;
////        //sql语句
////        String findSql = "SELECT ID,GOODS_NUM,NAME,TYPE,UNIT,PROCEDURE_DATE,SHELF_LIFE,SHELF_LIFE_UNIT FROM goods WHERE ID=?;";
////
////        List<Goods> goodsList=jdbcTemplate.query(findSql, new ResultSetExtractor<List<Goods>>() {
////
////            @Override
////            public List<Goods> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
////                List<Goods> goodsList=new ArrayList<Goods>();
////                Goods goods=new Goods();
////                while (resultSet.next()){
////                    goods.setId(resultSet.getLong(1));
////                    goods.setGoodsNum(resultSet.getString(2));
////                    goods.setName(resultSet.getString(3));
////                    goods.setType(resultSet.getByte(4));
////                    goods.setUnit(resultSet.getString(5));
////                    goods.setProcedureDate(resultSet.getDate(6));
////                    goods.setShelfLife(resultSet.getFloat(7));
////                    goods.setShelfLifeUnit(resultSet.getByte(8));
////                }
////                goodsList.add(goods);
////                return goodsList;
////            }
////        }, id);
////        return goodsList.get(0);
////
////
//////
//////        //定义商品对象
//////        Goods goods = new Goods();
//////        //定义结果集合
//////        ResultSet resultSet = null;
//////        //sql语句
//////        String findSql = "SELECT ID,GOODS_NUM,NAME,TYPE,UNIT,PROCEDURE_DATE,SHELF_LIFE,SHELF_LIFE_UNIT FROM goods WHERE ID=?;";
//////        //获取预编译Statement对象
//////        preparedStatement = connection.prepareStatement(findSql);
//////        preparedStatement.setLong(1, id);
//////        //执行查询
//////        resultSet = preparedStatement.executeQuery();
//////        while (resultSet.next()) {
//////            goods.setId(resultSet.getLong(1));
//////            goods.setGoodsNum(resultSet.getString(2));
//////            goods.setName(resultSet.getString(3));
//////            goods.setType(resultSet.getByte(4));
//////            goods.setUnit(resultSet.getString(5));
//////            goods.setProcedureDate(resultSet.getDate(6));
//////            goods.setShelfLife(resultSet.getFloat(7));
//////            goods.setShelfLifeUnit(resultSet.getByte(8));
//////        }
//////        preparedStatement.close();
//////        resultSet.close();
//////        return goods;
////    }
//
//    /**
//     * @Title: saveGoods
//     * @Description: 保存商品信息
//     * @author yanyong
//     * @date 2018-01-21
//     * @throws: SQLException
//     * @param: goods 商品信息
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer saveGoods(Goods goods, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        Integer number = 0;
//        String saveSql = "INSERT INTO goods(ID,GOODS_NUM,NAME,TYPE,UNIT,PROCEDURE_DATE,SHELF_LIFE,SHELF_LIFE_UNIT)" +
//                "VALUES(DEFAULT,?,?,?,?,?,?,?);";
//        preparedStatement = connection.prepareStatement(saveSql);
//        preparedStatement.setString(1, goods.getGoodsNum());
//        preparedStatement.setString(2, goods.getName());
//        preparedStatement.setByte(3, goods.getType());
//        preparedStatement.setString(4, goods.getUnit());
//        preparedStatement.setDate(5, new Date(goods.getProcedureDate().getTime()));
//        preparedStatement.setFloat(6, goods.getShelfLife());
//        preparedStatement.setByte(7, goods.getShelfLifeUnit());
//        number = preparedStatement.executeUpdate();
//        connection.commit();
//        preparedStatement.close();
//        return number;
//
//
//    }
//
//    /**
//     * @Title: deleteGoodsById
//     * @Description: 删除指定id的商品信息
//     * @author yanyong
//     * @date 2018-01-21
//     * @throws: SQLException
//     * @param: id 指定id
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer deleteGoodsById(Long id, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        Integer number = 0;
//        String deleteSql = "DELETE FROM goods WHERE ID=?;";
//        preparedStatement = connection.prepareStatement(deleteSql);
//        preparedStatement.setLong(1, id);
//        number = preparedStatement.executeUpdate();
//        connection.commit();
//        preparedStatement.close();
//        return number;
//    }
//
//    /**
//     * @Title: updateGoodsById
//     * @Description: 更新指定id商品信息
//     * @author yanyong
//     * @date 2018-01-21
//     * @throws: SQLException
//     * @param: id 指定id
//     * @param: goods 商品信息
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer updateGoodsById(Long id, Goods goods, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        Integer number = 0;
//        String updateSql = "UPDATE goods SET GOODS_NUM=?,NAME=?,TYPE=?,UNIT=?,PROCEDURE_DATE=?,SHELF_LIFE=?,SHELF_LIFE_UNIT=? " +
//                "WHERE ID=?;";
//        preparedStatement = connection.prepareStatement(updateSql);
//        preparedStatement.setString(1, goods.getGoodsNum());
//        preparedStatement.setString(2, goods.getName());
//        preparedStatement.setByte(3, goods.getType());
//        preparedStatement.setString(4, goods.getUnit());
//        preparedStatement.setDate(5, new Date(goods.getProcedureDate().getTime()));
//        preparedStatement.setFloat(6, goods.getShelfLife());
//        preparedStatement.setByte(7, goods.getShelfLifeUnit());
//        number = preparedStatement.executeUpdate();
//        connection.commit();
//        preparedStatement.close();
//        return number;
//    }
//}