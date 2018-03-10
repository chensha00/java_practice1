<%@ page import="domain.OrderDetail" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Goods" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Roger_yu
  Date: 2018/1/29
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>进货</title>
    <script src="${basePath}../js/jquery-1.7.2.min.js"></script>
    <script src="${basePath}../js/jquery-1.7.2.js"></script>
    <link rel="stylesheet" href="${basePath}../css/store_order_css.css">
</head>
<body align="center">
<jsp:include page="head_page.jsp" flush="true"/>
<div class="divForm">
    <h2 style="background-color: darkturquoise">进货</h2>
    <%--<div>--%>
        <%--<form action="StoreServletSelectGoods.htm" method="post">--%>
            <%--请输入商品ID：<input type="text" name="selectGoods"/>--%>
            <%--<input type="submit" value="点击进货" />--%>
        <%--</form>--%>
    <%--</div>--%>
    <div align="center">
        <table border="1" align="center">
            <tr bgcolor="#6495ed">
                <th width="100">商品编号</th>
                <th width="100">商品名字</th>
                <th width="100">商品类型</th>
                <th width="100">单位</th>
                <th width="130">生产日期</th>
                <th width="100">保质期</th>
                <th width="100">保质期单位</th>
                <th width="100">商铺现有库存</th>
                <th width="100">进货数量</th>
            </tr>
            <form>
                <c:if test="${not empty map}">
                    <c:forEach items="${map}" var="iAndGoods">
                        <tr>
                            <td>
                                ${iAndGoods[1].goodsNum}
                            </td>
                            <td>
                                ${iAndGoods[1].name}
                            </td>
                            <td>
                                ${iAndGoods[1].type}
                            </td>
                            <td>
                                ${iAndGoods[1].unit}
                            </td>
                            <td>
                                ${iAndGoods[1].procedureDate}
                            </td>
                            <td>
                                ${iAndGoods[1].shelfLife}
                            </td>
                            <td>
                                ${iAndGoods[1].shelfLifeUnit}
                            </td>
                            <td>
                                ${iAndGoods[0].number}
                            </td>
                            <td>
                                <input type="text" name="inNumber" class="inNumber">
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <input type="submit" value="添加商品">
                <input type="submit" value="提交进货">
            </form>
        </table><br/>
    </div>
</div>
</body>
</html>
