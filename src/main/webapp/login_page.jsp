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
    <title>登录界面</title>
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
            <br>&nbsp;&nbsp;
            <%--<button type="button" id="login_button" >登录</button>--%>
            <%--<input formaction="../registration_page.jsp" type="submit1" value="注册"/>--%>
            <input type="button" onclick='location.href=("../registration_page.jsp")' value="注册"/>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <input type="submit" name="login" value="登录" id="submit" onclick="submit"/>
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
    <%--function toVaild() {--%>
    <%--var test = ${LoginMessage}--%>
    <%--if (test == "error") {--%>
    <%--alert("用户名不存在或密码错误!\n请重新输入或注册");--%>
    <%--} else {--%>
    <%--alert("成功登录");--%>
    <%--}--%>
    <%--}--%>
    $(function () {
        $('#submit').live("click", function ()  {
            var username = $("input[name='username']").val();
            var password = $("input[name='password']").val();
            $.ajax({
                type: "post",
                dataType: "json",
                data: {
                    username: username, password: password
                },
                url: "${pageContext.request.contextPath}/servlet/loginPage.htm",
                //                contentType:"text",
                success: function (x) {
                    alert("登陆成功！！！");
                    window.location.replace("/mainAction!main.do");
                },
                error: function (XMLResponse) {
                    alert("登陆失败！！！")
                }
            })
        })
    })

</script>

</body>
</html>
