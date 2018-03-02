<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--&lt;%&ndash;--%>
<%--Created by IntelliJ IDEA.--%>
<%--User: lionk--%>
<%--Date: 2018/1/29--%>
<%--Time: 17:33--%>
<%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<link rel="stylesheet" href="css/person_css.css">

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>大明星在线商城</title>
    <script src="${basePath}../js/jquery-1.7.2.min.js"></script>
    <script src="${basePath}../js/jquery-1.7.2.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${basePath}../css/person_css.css">
    <meta name="referrer" content="always">
</head>
<jsp:include page="head_page.jsp"></jsp:include>

<body>

<div class="divFormFather">
<div class="divForm">

        <a>id:${person.id}</a>
        <a>姓名:${person.name}</a>
        <a>身份证号:${person.cardId}</a>
        <a>账户:${person.usreName}</a>

        <form id="people" name="People" action="person.jsp" method="post">
            <table border="0">

                <tr>
                    <td>性别：</td>
                    <td><input type="text" name="sex" value="${person.sex}"></td>
                </tr>
                <tr>
                    <td>年龄：</td>
                    <td><input type="text" name="age" value="${person.age}"></td>
                </tr>
                <tr>
                    <td>持有金额：${person.money}</td>
                </tr>
                <tr>
                    <td>收货地址：</td>
                    <td><input type="text" name="address" value="${person.address}"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password" value="${person.passWord}"></td>
                </tr>
                <tfoot>
                <tr>账户充值：</tr><tr>
                <button type="button">修改账户</button>
                <button type="button">退出账户</button></tr>
                </tfoot>
            </table>
        </form>
</div>
</div>
</body>
</html>
