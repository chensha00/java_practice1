<%--
  Created by IntelliJ IDEA.
  User: HZQ
  Date: 2018/2/1
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<link href="${basePath}/css/store_home_page_css.css" rel="stylesheet" />
<html>
<head>
    <title>开店页面</title>
</head>
<body>
<jsp:include page="head_page.jsp"></jsp:include>
<div class="people_open_store">
    <%
        //获得peopleId
        Long peopleId = (Long) session.getAttribute("peopleId");
        session.setAttribute("peopleId",1L);
    %>
    <form name="openStore" action="/store/storeHome.htm" method="post" align="center">
        <p>您还未开通店铺，如果需要开通店铺请输入店铺名，点击确认开通即可开通店铺</p>
        <input type="text" name="storeName">
        <input type="submit" value="开通">
        <a href="/store/storeHome.htm"> <input type="button" value="返回"></a>
    </form>
</div>
</body>
</html>
