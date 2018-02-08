<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/29 0029
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<html>
<head>
    <link href="css/order_page_css.css" rel="stylesheet" type="text/css"/>
    <title></title>
</head>
<body>
<jsp:include page="head_page.jsp"></jsp:include>
<div align="center">
    <div align="center">
    </div>
    <div align="center">
        <br/><br/><br/><br/>

        <table id="pay-table" align="center" border="1">
            <thead>
            <th><button id="pay-self">自己支付</button></th>
            <th>
                <button id="pay-other">
                    <a href="http://localhost:8080/pay/pay.htm?peopleId=1&&orderNum=${orderNum}">
                        替他人支付
                    </a>
                </button>
            </th>
            <th>编号：<input type="text" name="orderNum" value=""/> </th>
            </thead>
            <tbody>
            <tr bgcolor="silver">
                <td width="30%">订单编号:${goodsOrderPay.orderNum}</td>
                <c:choose>
                    <%--0--未支付，1--支付成功，2--支付失败"--%>
                    <c:when test="${goodsOrderPay.orderStatus ==0}">
                        <td width="30%">订单状态: 未支付</td>
                    </c:when>
                    <c:when test="${goodsOrderPay.orderStatus ==1}">
                        <td width="30%">订单状态: 支付成功</td>
                    </c:when>
                    <c:otherwise>
                        <td width="30%">订单状态: 支付失败</td>
                    </c:otherwise>
                </c:choose>
                <%--<td width="30%">订单状态:${order.orderStatus}</td>--%>
                <td width="30%">总金额:${goodsOrderPay.totalMoney}</td>
            </tr>
            <tr><td>订单详情数：${fn:length(orderDetailListPay)}</td></tr>
            <c:forEach var="detailPay" items="${orderDetailListPay}" varStatus="detail_index">
                <tr>
                    <td>订单详情编号：${detailPay.orderNum}</td>
                    <td>订单详情编号:${detailPay.goods.name}</td>
                    <td>价格:${detailPay.goodsPrice}</td>
                    <td>数量:${detailPay.number}</td>
                    <td>商品总价:${detailPay.goodsAmount}</td>
                </tr>
            </c:forEach>
            <%--<tr>--%>
                <%--<td colspan="5" align="center">--%>
                    <%--<button class="btn-evalute">评    价</button>--%>
                    <%--<button class="btn-delete">删除订单</button>--%>
                    <%--<button class="btn-pay">支    付</button>--%>
                    <%--<button class="btn-cancel">取消订单</button>--%>
                    <%--<button class="btn-recive">确定收货</button>--%>
                <%--</td>--%>
            <%--</tr>--%>

            <tr>
                <td height="10px" colspan="5"></td>
            </tr>
            </tbody>



            <%----%>
            <tbody>
            <%--<tr>--%>
                <%--<td colspan="3">支付订单</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>订单编号</td>--%>
                <%--<td>支付金额</td>--%>
                <%--<td>折扣</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td><b>ORD109420</b></td>--%>
                <%--<td><b>390.5</b></td>--%>
                <%--<td><b>10</b></td>--%>
            <%--</tr>--%>
            <tr>
                <td colspan="5">
                    <button id="pay-money">
                        <a href="http://localhost:8080/pay/pay.htm?peopleId=1&&orderNum=${goodsOrderPay.orderNum}&&isPay=true">
                            支付</a>
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
