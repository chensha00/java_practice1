package domain;/**
 * Created by HS on 2018/1/20.
 */

/**
 * @author shangzhiqian
 * @ClassName People
 * @Description 类描述
 * @date 2018/1/20
 */
public class People {
    /**
     * 人员主键ID
     */
    private Long id;
    /**
     * name姓名
     */
    private String name;
    /**
     * Card_id  身份证明
     */
    private String cardId;
    /**
     * sex 姓名：男，女
     */
    private String sex;
    /**
     * age 年龄
     */
    private Integer age;
    /**
     * money 持有金额
     */
    private Double money;
    /**
     * address 地址
     */
    private String address;

    /**
     * userName 用户名
     */
    private String usreName;

    /**
     * passWord 密码
     */
    private String passWord;

    //封装


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsreName() {
        return usreName;
    }

    public void setUsreName(String usreName) {
        this.usreName = usreName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


//   构造函数

    public People() {
    }

    public People(long id, String name, String cardId, String sex, Integer age, Double money, String address, String usreName, String passWord) {
        this.id = id;
        this.name = name;
        this.cardId = cardId;
        this.sex = sex;
        this.age = age;
        this.money = money;
        this.address = address;
        this.usreName = usreName;
        this.passWord = passWord;
    }

    public People(long id, String name, String cardId, String sex, Integer age, Double money, String address) {
        this.id = id;
        this.name = name;
        this.cardId = cardId;
        this.sex = sex;
        this.age = age;
        this.money = money;
        this.address = address;
        this.usreName = "asdfghjkl";
        this.passWord = "123456";
    }

    public People(String name, String cardId, String sex, Integer age, String address) {
        this.name = name;
        this.cardId = cardId;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.usreName = "asdfghjkl";
        this.passWord = "123456";
    }

    public People(String name, String cardId, String sex, Integer age, Double money, String address) {
        this.name = name;
        this.cardId = cardId;
        this.sex = sex;
        this.age = age;
        this.money = money;
        this.address = address;
        this.usreName = "asdfghjkl";
        this.passWord = "123456";
    }

    public People(String name, long id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public People(String name, String cardId, String sex, Integer age, Double money, String address, String usreName, String passWord) {
        this.name = name;
        this.cardId = cardId;
        this.sex = sex;
        this.age = age;
        this.money = money;
        this.address = address;
        this.usreName = usreName;
        this.passWord = passWord;
    }
}
