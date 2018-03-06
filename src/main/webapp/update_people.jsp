<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/28 0028
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="${basePath}../js/jquery-1.7.2.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="head_page.jsp"/>

<div id="all_div" align="center">
    <table align="center" border="1" class="table_update_people">
        <thead>
        <tr>
            <th colspan="2">人员信息</th>
        </tr>
        <tr>
            <th>属性</th>
            <td>值</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>ID</td>
            <td><input type="text" class="people_id" value="${updPeople.id}"></td>
        </tr>
        <tr>
            <td>NAME</td>
            <td><input type="text" class="people_name" value="${updPeople.name}"></td>
        </tr>
        <tr>
            <td>CARD_ID</td>
            <td><input type="text" class="people_card_id" value="${updPeople.cardId}"></td>
        </tr>
        <tr>
            <td>SEX</td>
            <td><input type="text" class="people_sex" value="${updPeople.sex}"></td>
        </tr>
        <tr>
            <td>AGE</td>
            <td><input type="text" class="people_age" value="${updPeople.age}"></td>
        </tr>
        <tr>
            <td>MONEY</td>
            <td><input type="text" class="people_money" value="${updPeople.money}"></td>
        </tr>
        <tr>
            <td>ADDRESS</td>
            <td><input type="text" class="people_address" value="${updPeople.address}"></td>
        </tr>
        <tr>
            <td>USERNAME</td>
            <td><input type="text" class="people_user_name" value="${updPeople.usreName}"></td>
        </tr>
        <tr>
            <td>PASSWORD</td>
            <td><input type="text" class="people_password" value="${updPeople.passWord}"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><button id="upd_people_btn">确认修改</button> </td>
        </tr>
        </tbody>
    </table>
</div>
<script type="text/javascript">

    $("#upd_people_btn").click(function(){
        var id=$(".people_id").val();
        var name=$(".people_name").val();
        var cardId=$(".people_card_id").val();
        var sex=$(".people_sex").val();
        var age=$(".people_age").val();
        var money=$(".people_money").val();
        var address=$(".people_address").val();
        var username=$(".people_user_name").val();
        var password=$(".people_password").val();
        alert(id+" "+name);
        $.ajax({
            type:'POST',
            url:"${pageContext.request.contextPath}/test/updatePeople.htm",
//            data:{peopleId:id,name:name,cardId:cardId,sex:sex,age:age},
//            data:{peopleId:id},
            data:{peopleId:id,name:name,cardId:cardId,sex:sex,
                age:age,money:money,address:address,username:username,
                password:password},
            dataType:'json',
            success:function(){
                window.location.href="${pageContext.request.contextPath}/administrator_page.jsp";
            },
            error:function(){
                alert("修改失败");
            }
        });
    });
</script>

</body>
</html>
