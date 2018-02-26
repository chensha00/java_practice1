<%@ page import="domain.OrderDetail" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Roger_yu
  Date: 2018/1/29
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>卖家订单信息</title>
    <style type="text/css">
        .divForm{
            position: absolute;/*绝对定位*/
            width: 100%;
            height: 100%;
            /*border: 1px solid red;*/
            /*text-align: center;(让div中的内容居中)*/
            top: 30%;
            left: 12%;
            margin-top: -200px;
            margin-left: -150px;
        }
        .limit {
            width: 500px;
            height: 60px;
            float: right;
        }
    </style>
</head>
<body>
<div class="divForm">
    <h2 style="background-color: darkturquoise" align="center">本商铺订单信息</h2>
    <div align="center">
        <form action="StoreOrderServletSelect.htm" method="post">
            请输入订单ID:<input type="text" name="select"/>
            <input type="submit" value="点击查询">
        </form>
    </div>
    <div>
        <table border="1" width="1200" align="center">
            <tr bgcolor="#6495ed">
                <th width="100">商铺编码</th>
                <th width="100">买家</th>
                <th width="100">店铺</th>
                <th width="100">商品</th>
                <th width="100">订单编号</th>
                <th width="100">购买数量</th>
                <th width="100">单价</th>
                <th width="100">商品金额</th>
                <th width="100">生成日期</th>
                <th width="100">成功时间</th>
                <th width="100">发货时间</th>
                <th width="100">订单状态</th>
                <th width="100">是否作废</th>
                <th width="100">是否发货</th>
            </tr>
            <%List<OrderDetail> od= (List<OrderDetail>) session.getAttribute("orderDetail");%>
            <%
                if ((request.getParameter("select"))!=null){
                    for (OrderDetail orderD:od) {%>
                        <%--添加查询出的数据--%>
                        <tr>
                            <td width="100">
                                <%=orderD.getStoreId()%>
                            </td>
                            <td width="100">
                                <%=orderD.getPeople().getName()%>
                            </td>
                            <td width="100">
                                <%=orderD.getStore().getStoreName()%>
                            </td>
                            <td width="100">
                                <%=orderD.getGoods().getName()%>
                            </td>
                            <td width="100">
                                <%=orderD.getGoodsOrder().getOrderNum()%>
                            </td>
                            <td width="100">
                                <%=orderD.getNumber()%>
                            </td>
                            <td width="100">
                                <%=orderD.getGoodsPrice()%>
                            </td>
                            <td width="100">
                                <%=orderD.getGoodsAmount()%>
                            </td>
                            <td width="100">
                                <%=orderD.getAddTime()%>
                            </td>
                            <td width="100">
                                <%=orderD.getSuccessTime()%>
                            </td>
                            <td width="100">
                                <%=orderD.getDeliveryTime()%>
                            </td>
                            <td width="100">
                                <%=orderD.getOrderStatus()%>
                            </td>
                            <td width="100">
                                <%=orderD.getIsInvalid()%>
                            </td>
                            <td width="100" align="center">
                                <%if (orderD.getOrderStatus()>1){%>
                                        <p>已发货</p>
                                <%}else if (orderD.getOrderStatus()==0){%>
                                        <p>未付款</p>
                                <%}else {%>
                                        <form action="StoreServletDelivery.htm" method="post">
                                            <input type="text" name="odId" value="<%=orderD.getId()%>" hidden="hidden"/>
                                            <input type="submit" value="点击发货">
                                        </form>

                                        <%--<button type="submit" formaction="StoreServletDelivery.htm" name="odId" value=${orderD.getId()}>点击发货</button>--%>
                                <%}%>
                            </td>
                        </tr>
                    <%}%>
                <%}%>
        </table>
    </div>
</div>
<%--<div class="limit">--%>
    <%--<form class="form" name="f1" method="POST" action="index.jsp" onSubmit="return checknum()">--%>
        <%--<table border="0" align="center" >--%>
            <%--<tr>--%>
                <%--<td>第1页 共10页 <a href="index.jsp?pages=1">首页</a></td>--%>
                <%--<td><a href=""> 上一页</a></td>--%>
                <%--<td><a href=""> 下一页</a></td>--%>
                <%--<td><a href="">最后一页</a></td>--%>
                <%--<td>转到第:<input type="text" name="page" size="8">页<input type="submit" value="GO" name="cndok"></td>--%>
            <%--</tr>--%>
        <%--</table>--%>
    <%--</form>--%>
<%--</div>--%>
</body>
</html>
