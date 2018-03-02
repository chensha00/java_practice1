package dao;/**
 * Created by HS on 2018/1/20.
 */

import common.util.base.BaseDaoImpl;
import domain.People;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shangzhiqian
 * @ClassName PeopleDaoImpl
 * @Description 人员数据库表 操作类，实现PeopleDao接口
 * @date 2018/1/20
 */
@Repository("peopleDao")
public class PeopleDaoImpl extends BaseDaoImpl<People> implements PeopleDao {

    /**
     * @Title: findPeopleById
     * @Description: 通过指定Id查找人员
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 人员对象
     */
    @Override
    public People findPeopleById(Long id) {
//        People people=new People();
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getPoepleById",id);
//        return people;
    }

    /**
     * @Title: savePeople
     * @Description: 保存人员信息
     * @author yanyong
     * @date 2018-01-21
     * @param: people 人员对象
     * @return: 受影响行数
     */
    @Override
    public Integer savePeople(People people) {
        return this.sqlSessionTemplate.insert(getMybaitsNameSpace()+"savePeople",people);
    }
    /**
     * @Title: deletePeopleById
     * @Description: 删除指定id 的人员信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 受影响行数
     */
    @Override
    public Integer deletePeopleById(Long id) {
        return this.sqlSessionTemplate.delete(getMybaitsNameSpace()+"deletePeopleById",id);
//        return line;
    }

    /**
     * @Title: updatePeople
     * @Description: 更新指定人员的信息
     * @author yanyong
     * @date 2018-01-21
     * @param: id 指定人员id
     * @param: people 指定人员信息
     * @return: 受影响行数
     */
    @Override
    public Integer updatePeople(People people) {
        return this.sqlSessionTemplate.update(getMybaitsNameSpace()+"updatePeople",people);
//        return line;
    }

    /**
     * @Title: findPeopleByUserName
     * @Description: 查找用户根据用户名和密码
     * @author yanyong
     * @date 2018-01-30
     * @param: userName 用户名
     * @param: password 密码
     * @return: 人员对象
     */
    @Override
    public People findPeopleByUserName(String userName, String password) {
        Map userMap=new HashMap();
        userMap.put("usreName",userName);
        userMap.put("passWord",password);
//        People people=new People();
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"findPeopleByUserName",userMap);
//        return people;
    }

    public List<People> getAllPeople(){
        List<People> peopleList=this.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"getAllPeople");
        return peopleList;
    }


//    @Autowired
//    private PeopleService peopleService;
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//
//    public List<People> getPeopleAll(){
//        List<People> peopleList=this.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"getPoeple");
//        return peopleList;
//    }
//    /**
//     * @Title: findPeopleById
//     * @Description: 通过指定Id查找人员
//     * @author shangzhiqian
//     * @date 2018-01-21
//     * @throws: SQLException
//     * @param: id 指定id
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement对象
//     * @return: 人员对象
//     */
//    @Override
//    public People findPeopleById(Long id) throws SQLException {
//        //定义员对象
//        People people = new People();
//        //定义结果集合
//        ResultSet resultSet = null;
//        //查询sql语句
//        String findSql = "SELECT ID,NAME,CARD_ID,SEX,AGE,MONEY,ADDRESS,USERNAME,PASSWORD FROM people WHERE ID=?;";
//        //获取查询数据库的 Statement对象
////        preparedStatement = connection.prepareStatement(findSql);
////        //设置 id的值
////        preparedStatement.setLong(1, id);
//        //获取结果集合
////        resultSet = preparedStatement.executeQuery();
//        //获取人员对象信息
//       List<People> peoples = jdbcTemplate.query(findSql, new ResultSetExtractor<List<People>>() {
//            @Override
//            public List<People> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                List<People> peoples = new ArrayList<People>();
//                while (resultSet.next()) {
//                    People people1 = new People();
//                    people1.setId(resultSet.getLong(1));
//                    people1.setName(resultSet.getString(2));
//                    people1.setCardId(resultSet.getString(3));
//                    people1.setSex(resultSet.getString(4));
//                    people1.setAge(resultSet.getInt(5));
//                    people1.setMoney(resultSet.getDouble(6));
//                    people1.setAddress(resultSet.getString(7));
//                    people1.setUsreName(resultSet.getString(8));
//                    people1.setPassWord(resultSet.getString(9));
//                    peoples.add(people1);
//                }
//                return peoples;
//            }
//        },id);
////        connection.commit();
//        //关闭预编译Statement对象
////        preparedStatement.close();
//        //关闭连接
////        connection.close();
//        //返回人员对象
//        return peoples.get(0);
//    }
//
//    /**
//     * @Title: findPeopleByUserName
//     * @Description: 查找用户根据用户名和密码
//     * @author yanyong
//     * @date 2018-01-30
//     * @param: userName 用户名
//     * @param: password 密码
//     * @return: 人员对象
//     */
//    @Override
//    public People findPeopleByUserName(String userName,String password) throws SQLException{
//        //定义员对象
//        People people = new People();
//        //定义结果集合
//        ResultSet resultSet = null;
//        //查询sql语句
//        String findSql = "SELECT ID,NAME,CARD_ID,SEX,AGE,MONEY,ADDRESS,USERNAME,PASSWORD FROM people WHERE USERNAME=? AND PASSWORD=?;";
//        //获取查询数据库的 Statement对象
////        preparedStatement = connection.prepareStatement(findSql);
//        //设置 id的值
////        preparedStatement.setLong(1, id);
////        preparedStatement.setString(1,userName);
////        preparedStatement.setString(2,password);
//        //获取结果集合
//
////        resultSet = preparedStatement.executeQuery();
//        //获取人员对象信息
//        List<People> peoples = jdbcTemplate.query(findSql, new ResultSetExtractor<List<People>>() {
//            @Override
//            public List<People> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                List<People> peoples = new ArrayList<People>();
//                while (resultSet.next()) {
//                    People people1 = new People();
//                    people1.setId(resultSet.getLong(1));
//                    people1.setName(resultSet.getString(2));
//                    people1.setCardId(resultSet.getString(3));
//                    people1.setSex(resultSet.getString(4));
//                    people1.setAge(resultSet.getInt(5));
//                    people1.setMoney(resultSet.getDouble(6));
//                    people1.setAddress(resultSet.getString(7));
//                    people1.setUsreName(resultSet.getString(8));
//                    people1.setPassWord(resultSet.getString(9));
//                    peoples.add(people1);
//                }
//                return peoples;
//            }
//        },userName,password);
////        connection.commit();
//        //关闭预编译Statement对象
////        preparedStatement.close();
//        //关闭连接
////        connection.close();
//        //返回人员对象
//        return peoples.get(0);
////        connection.commit();
//        //关闭预编译Statement对象
////        preparedStatement.close();
//        //关闭连接
////        connection.close();
//        //返回人员对象
//    }
//    /**
//     * @Title: savePeople
//     * @Description: 保存人员信息
//     * @author shangzhiqian
//     * @date 2018-01-21
//     * @throw SQLException
//     * @param: people 人员信息
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer savePeople(People people, Connection connection, PreparedStatement preparedStatement) throws SQLException {
//        Integer number = 0;
////        String saveSqlAll = "INSERT INTO people(ID,NAME,CARD_ID,SEX,AGE,MONEY,ADDRESS,USERNAME,PASSWORD) VALUES(?,?,?,?,?,?,?,?,?);";
//        String saveSqlDefault = "INSERT INTO people(ID,NAME,CARD_ID,SEX,AGE,MONEY,ADDRESS,USERNAME,PASSWORD) VALUES(DEFAULT,?,?,?,?,?,?,?,?);";
////        if (people.getId() == 0) {
//            preparedStatement = connection.prepareStatement(saveSqlDefault);
//            preparedStatement.setString(1, people.getName());
//            preparedStatement.setString(2, people.getCardId());
//            preparedStatement.setString(3, people.getSex());
//            preparedStatement.setInt(4, people.getAge());
//            preparedStatement.setDouble(5, people.getMoney());
//            preparedStatement.setString(6, people.getAddress());
//            preparedStatement.setString(7, people.getUsreName());
//            preparedStatement.setString(8, people.getPassWord());
////        } else {
////            preparedStatement = connection.prepareStatement(saveSqlAll);
////            preparedStatement.setLong(1, people.getId());
////            preparedStatement.setString(2, people.getName());
////            preparedStatement.setString(3, people.getCardId());
////            preparedStatement.setString(4, people.getSex());
////            preparedStatement.setInt(5, people.getAge());
////            preparedStatement.setDouble(6, people.getMoney());
////            preparedStatement.setString(7, people.getAddress());
////            preparedStatement.setString(8, people.getUsreName());
////            preparedStatement.setString(9, people.getPassWord());
////        }
//        number = preparedStatement.executeUpdate();
//        connection.commit();
//        //关闭预编译Statement对象
//        preparedStatement.close();
//        //关闭连接
//        connection.close();
//        return number;
//    }
//
//    /**
//     * @Title: deletePeopleById
//     * @Description: 删除指定id 的人员信息
//     * @author shangzhiqian
//     * @date 2018-01-21
//     * @param: id 指定id
//     * @param: connection 连接对象
//     * @param: prepareStatement 预编译 Statement对象
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer deletePeopleById(Long id, Connection connection, PreparedStatement prepareStatement) throws SQLException {
//        Integer number = 0;
//        String deleteSql = "DELETE FROM people WHERE ID=?;";
//        prepareStatement = connection.prepareStatement(deleteSql);
//        prepareStatement.setLong(1, id);
//        number = prepareStatement.executeUpdate();
//        connection.commit();
//        prepareStatement.close();
//        connection.close();
//        return number;
//    }
//
//    /**
//     * @Title: updatePeopleById
//     * @Description: 更新指定人员的信息
//     * @author shangzhqian
//     * @date 2018-01-21
//     * @param: id 指定人员id
//     * @param: people 指定人员信息
//     * @param: connection 连接对象
//     * @param: prepareStatement 预编译 Statement对象
//     * @return: 受影响行数
//     */
//    @Override
//    public Integer updatePeopleById(Long id, People people, Connection connection, PreparedStatement prepareStatement) throws SQLException {
//        Integer number = 0;
//        String updateSql = "UPDATE people SET NAME=?,CARD_ID=?,SEX=?,AGE=?,MONEY=?,ADDRESS=?,USERNAME=?, PASSWORD=? WHERE ID=?;";
//        prepareStatement = connection.prepareStatement(updateSql);
//        prepareStatement.setString(1, people.getName());
//        prepareStatement.setString(2, people.getCardId());
//        prepareStatement.setString(3, people.getSex());
//        prepareStatement.setInt(4, people.getAge());
//        prepareStatement.setDouble(5, people.getMoney());
//        prepareStatement.setString(6, people.getAddress());
//        prepareStatement.setString(7, people.getUsreName());
//        prepareStatement.setString(8, people.getPassWord());
//        prepareStatement.setLong(9, id);
//        number = prepareStatement.executeUpdate();
//        connection.commit();
//        prepareStatement.close();
//        connection.close();
//        return number;
//    }
//
//    /**
//     * @Title: findPeopleByUnSureCondition
//     * @Description: 方法描述
//     * @author hzq
//     * @date 2018/01/30
//     * @param map 条件和值对应key和value
//     * @param connection 连接对象
//     * @param prepareStatement 预编译 Statement对象
//     * @throw SQLException
//     */
//    public List<People> findPeopleByUnSureCondition(List<Map<String,Object>> map,Connection connection, PreparedStatement prepareStatement)
//            throws SQLException{
//        List<People> peoples = new ArrayList<People>();
//        //通过拼接sql语句来实现动态的不确定条件查询
//        StringBuffer sql = new StringBuffer();
//        sql.append("SELECT ID,NAME,CARD_ID,SEX,AGE,MONEY,ADDRESS,USERNAME,PASSWORD FROM people WHERE 1 =1 ");
//        if(map!=null&&map.size()>0){
//            for(int i = 0;i<map.size();i++){
//                //将条件拼接到sql中
//                Map<String,Object> condition = map.get(i);
//                sql.append(" and " + condition.get("name") + " " + condition.get("rela") + " " + condition.get("value")+" ");
//            }
//        }
//        //输出sql语句并执行sql语句
//        System.out.println(sql.toString());
//        prepareStatement = connection.prepareStatement(sql.toString());
//        ResultSet resultSet = prepareStatement.executeQuery();
//        //将结果放入list中返回
//        while(resultSet.next()){
//            People people = new People();
//            people.setId(resultSet.getLong(1));
//            people.setName(resultSet.getString(2));
//            people.setCardId(resultSet.getString(3));
//            people.setSex(resultSet.getString(4));
//            people.setAge(resultSet.getInt(5));
//            people.setMoney(resultSet.getDouble(6));
//            people.setAddress(resultSet.getString(7));
//            people.setUsreName(resultSet.getString(8));
//            people.setPassWord(resultSet.getString(9));
//
//            peoples.add(people);
//        }
//        return peoples;
//    }

}
