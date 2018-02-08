<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zuorui
  Date: 2018/1/29
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>大明星商城之登录界面</title>
    <script src="${basePath}../js/jquery-1.7.2.min.js"></script>
    <script src="${basePath}../js/jquery-1.7.2.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${basePath}../css/login_page_css.css">
</head>
<body>

<jsp:include page="head_page.jsp"></jsp:include>

<div class="ground">
    <div class="div">
        <span class="title">&nbsp;大明星在线商城</span>

        <form id="login" name="Login" action="/servlet/loginPage.htm" method="post" class="form">
            <table border="0" class="table">
                <tr>
                    <td>账号：</td>
                    <td><input autofocus="autoFocus" type="text" name="username"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password">
                    </td>
                </tr>
            </table>
            <br>
            <input type="submit" name="login" value="登录" onsubmit="return toVaild"/>
            <input formaction="../registration_page.jsp" type="submit" value="注册"/>
        </form>
        <%--<c:choose>--%>
        <%--<c:when test="${LoginMessage eq 'error'}">--%>
        <%--<span>用户名不存在或密码错误</span>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
        <%--<span>登录成功</span>--%>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>
    </div>
</div>

<script type="text/javascript">
    function toVaild() {
        var test= ${LoginMessage}
        if (test=="error") {
            alert("用户名不存在或密码错误!\n请重新输入或注册");
        } else {
            alert("成功登录");
        }
    }
</script>

</body>
</html>
