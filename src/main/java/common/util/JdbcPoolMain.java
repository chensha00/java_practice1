package common.util;/********************************************************************
 /**
 * @Project: test_maven
 * @Package jdbc
 * @author guohongjin
 * @date 2017/8/28 22:14
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Date;

/**
 * @author guohongjin
 * @ClassName JdbcPoolMain
 * @Description 类描述
 * @date 2017/8/28
 */
public class JdbcPoolMain {

    public static void main111(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        // 1.创建自定义连接池对象
        DataSource dataSource = new DataSourceUtils();
        ResultSet set = null;
//        Field field=new Field();
//        field.get()
//        Date date=new Date()
        try {
            // 2.从池子中获取连接
            conn = dataSource.getConnection();
//            String sql = "insert into tbl_user values(null,?,?)";
            //3.必须在自定义的connection类中重写prepareStatement(sql)方法
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, "吕布1");
//            pstmt.setString(2, "貂蝉1");
            pstmt = conn.prepareStatement("SELECT NAME  FROM test WHERE  ID=?");
            Statement statement = conn.createStatement();

//            statement.execute()
//            pstmt.execute();
            pstmt.setLong(1, 1l);

            set = pstmt.executeQuery();
            conn.setAutoCommit(false);


            conn.commit();

            conn.rollback();

//            set.getString()
//            int rows = pstmt.executeUpdate();
//            if (rows > 0) {
//                System.out.println("添加成功!");
//            } else {
//                System.out.println("添加失败!");
//            }
//            ResultSet rs = null;
//            try {
//                //接收查询数据
////                rs=stmt.executeQuery();
////            stmt.executeUpdate("");
//                //提交事务
////                connection.commit();

////            stmt.executeUpdate("");executeUpdate
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            try {
                while (set.next()) {
//                    String name = set.getString("NAME");
                    String name = set.getString(1);
//                rs.
                    System.out.println("name is:" + name);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(conn, pstmt, set);
        }
    }

    /**
     * @Title: main
     * @Description: 主函数
     * @author yanyong
     * @date 2018-1-19 14:52:25
     * @throw YnCorpSysException
     */

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/shopping?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
        String user = "root";
        String pwd = "123456";
        String insertSql = "INSERT INTO people(ID,NAME,CARD_ID,SEX,AGE,MONEY) VALUES(?,?,?,?,?,?);";
        String deleteSql = "DELETE FROM people WHERE ID=1;";
        String upateSql = "UPDATE people SET `NAME`='wangwu' WHERE ID=1;";
        String selectSql = "SELECT * FROM people;";
        Connection connect = null;
        PreparedStatement preparedStatment = null;
        ResultSet resultset = null;
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url, user, pwd);
            preparedStatment = connect.prepareStatement(selectSql);
            resultset = preparedStatment.executeQuery();
            preparedStatment = connect.prepareStatement(insertSql);
            preparedStatment.setLong(1, 232334L);
            preparedStatment.setString(2, "lisi");
            preparedStatment.setString(3, "30945945a05");
            preparedStatment.setByte(4, (byte) 1);
            preparedStatment.setInt(5, 34);
            preparedStatment.setDouble(6, 48954.4d);
//            while(resultset.next()){
//                System.out.println(resultset.getLong(1));
//                System.out.println(resultset.getString(2));
//                System.out.println(resultset.getString(3));
//                System.out.println(resultset.getByte(4));
//                System.out.println(resultset.getInt(5));
//                System.out.println(resultset.getDouble(6));
//            }
            System.out.println(preparedStatment.executeUpdate());

//            preparedStatment.execute(deleteSql);
//            System.out.println(preparedStatment.executeUpdate());
//            preparedStatment.execute(upateSql);
//            System.out.println(preparedStatment.executeUpdate());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatment.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
