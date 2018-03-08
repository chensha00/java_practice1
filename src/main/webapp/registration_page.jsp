<%--
  Created by IntelliJ IDEA.
  User: zuorui
  Date: 2018/1/29
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="${basePath}../css/registration_page_css.css">
</head>
<body>

<jsp:include page="head_page.jsp"></jsp:include>

<div class="ground">
    <div class="div">
        <span class="span">WELCOME!</span>

        <form id="registration" name="Registration" action="/servlet/registration.htm" method="post">
            <table border="0" class="table">
                <tr>
                    <td>用户名：</td>
                    <td><input autofocus="autoFocus" type="text" name="username" required="required">

                        <p class="p">***(此为必选)</p></td>
                </tr>
                <tr>
                <tr>
                    <td>姓名：</td>
                    <td><input autofocus="autoFocus" type="text" name="name" required="required">

                        <p class="p">***(此为必选)</p></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td><input type="radio" name="sex" value="男">男
                        <input type="radio" name="sex" value="女">女
                    </td>
                </tr>
                <tr>
                    <td>年龄：</td>
                    <td><input type="text" name="age">

                        <p class="p">&nbsp;</p></td>
                </tr>
                <tr>
                    <td>身份证号：</td>
                    <td><input type="text" name="idCard" required="required">

                        <p class="p">***(此为必选)</p></td>
                </tr>
                <tr>
                    <td>居住地址：</td>
                    <td><input type="text" name="address">

                        <p class="p">&nbsp;</p></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td>预存金额：</td>
                    <td><input type="text" name="amount">

                        <p class="p">&nbsp;</p></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password" required="required">

                        <p class="p">***(此为必选)</p>
                    </td>
                </tr>
            </table>
            <br/>
            <hr/>
            <br/>
            <input type="submit" value="免费注册" class="button"/>
        </form>
        <input type="button" onclick="window.location.href='../login_page.jsp'" value="返回登录" class="button"/>
    </div>
</div>

<script type="text/javascript"></script>
</body>
</html>
