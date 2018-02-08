package dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package dao
 * @author yanyong
 * @date 2018/1/20 0020 16:56
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import domain.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yanyong
 * @InterfaceName GoodsDao
 * @Description 商品数据库操作接口
 * @date 2018/1/20 0020
 */
public interface GoodsDao {

    /**
     * @Title: findGoodsById
     * @Description: 查找指定id商品信息
     * @author yanyong
     * @date 2018-01-21
     * @throws: SQLException
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement
     * @return: 商品对象
     */
    public List<Goods>  findGoodsById(Long id);


    public List<Goods> findGoodsAll();
    /**
     * @Title: saveGoods
     * @Description: 保存商品信息
     * @author yanyong
     * @date 2018-01-21
     * @throws: SQLException
     * @param: goods 商品信息
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement
     * @return: 受影响行数
     */
    public Integer saveGoods(Goods goods);

    /**
     * @Title: deleteGoodsById
     * @Description: 删除指定id的商品信息
     * @author yanyong
     * @date 2018-01-21
     * @throws: SQLException
     * @param: id 指定id
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement
     * @return: 受影响行数
     */
    public Integer deleteGoodsById(Long id);

    /**
     * @Title: updateGoodsById
     * @Description: 更新指定id商品信息
     * @author yanyong
     * @date 2018-01-21
     * @throws: SQLException
     * @param: id 指定id
     * @param: goods 商品信息
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement
     * @return: 受影响行数
     */
    public Integer updateGoodsById(Long id, Goods goods);
}




//public interface GoodsDao {
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
//    public List<Goods>  findGoodsById(Long id) throws SQLException;
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
//    public Integer saveGoods(Goods goods, Connection connection, PreparedStatement preparedStatement) throws SQLException;
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
//    public Integer deleteGoodsById(Long id, Connection connection, PreparedStatement preparedStatement) throws SQLException;
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
//    public Integer updateGoodsById(Long id, Goods goods, Connection connection, PreparedStatement preparedStatement) throws SQLException;
//}