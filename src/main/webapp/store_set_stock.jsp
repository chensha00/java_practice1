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
<div class="divForm">
    <h2 style="background-color: darkturquoise">进货</h2>
    <div>
        <form action="StoreServletSelectGoods.htm" method="post">
            请输入商品ID：<input type="text" name="selectGoods"/>
            <input type="submit" value="点击进货" />
        </form>
    </div>
    <div>
        <table border="1" width="1200" align="center">
            <tr bgcolor="#6495ed">
                <th width="100">商品编号</th>
                <th width="100">商品名字</th>
                <th width="100">商品类型</th>
                <th width="100">单位</th>
                <th width="130">生产日期</th>
                <th width="100">保质期</th>
                <th width="100">保质期单位</th>
                <th width="100">进货商品ID</th>
                <th width="100">进货数量</th>
                <th width="100">进货店铺</th>
                <th width="100">进货金额</th>
            </tr>
            <form action="StoreServletStock.htm" method="post">
            <%
                Goods goods= (Goods) session.getAttribute("goods");
            %>
                <%if ((request.getParameter("selectGoods"))!=null){%>
                        <%--添加查询出的数据--%>
                        <tr>
                            <td>
                                <%=goods.getGoodsNum()%>
                            </td>
                            <td>
                                <%=goods.getName()%>
                            </td>
                            <td>
                                <%=goods.getType()%>
                            </td>
                            <td>
                                <%=goods.getUnit()%>
                            </td>
                            <td>
                                <%=goods.getProcedureDate()%>
                            </td>
                            <td>
                                <%=goods.getShelfLife()%>
                            </td>
                            <td>
                                <%=goods.getShelfLifeUnit()%>
                            </td>
                            <td>
                                <input type="text" name="goodsId" size="10">
                            </td>
                            <td>
                                <input type="text" name="number" size="18">
                            </td>
                            <td>
                                <input type="text" name="storeId" size="18">
                            </td>
                            <td>
                                <input type="text" name="money" size="18">
                            </td>
                        </tr>
                <%}%>
                <input type="submit" value="提交进货">
            </form>
        </table><br/>
    </div>
</div>
</body>
</html>
