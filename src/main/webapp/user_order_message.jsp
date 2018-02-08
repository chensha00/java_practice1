<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/29 0029
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp"%>
<html>
<head>
    <link href="css/order_page_css.css" rel="stylesheet" type="text/css"/>
    <title>用户订单信息</title>
</head>
<body>
<jsp:include page="head_page.jsp"></jsp:include>
<div align="center">
    <%--用户筛选按钮--%>
    <div id="order-button" >
        <br/><span style="background-color: cornflowerblue">我的订单信息</span>
        <button type="button" id="all-order"><a href="/order/order.htm?way=all&&peopleId=1">全  部</a></button>
        <button type="button" id="pend-payment-order"><a href="/order/order.htm?way=not_payment&&peopleId=1">待付款</a></button>
        <button type="button" id="pend-delivery-order"><a href="/order/order.htm?way=not_delivery&&peopleId=1">待发货</a></button>
        <button type="button" id="pend-receive-order"><a href="/order/order.htm?way=not_receive&&peopleId=1">待收货</a></button>
    </div>
    <div id="shopping-message-all">
        <table class="order-table" align="center" border="1" cellspacing="0">
            <thead>
            <th>我的订单信息 ${fn:length(goodsOrderList)}</th>
            <th>${fn:length(orderDetailList)}</th>
            </thead>
            <c:forEach var="order" items="${goodsOrderList}" varStatus="index">
                <tbody>
                <tr bgcolor="silver">
                    <td width="30%">订单编号:${order.orderNum}</td>
                    <c:choose>
                        <%--0--未支付，1--支付成功，2--支付失败"--%>
                        <c:when test="${order.orderStatus ==0}">
                            <td width="30%">订单状态: 未支付</td>
                        </c:when>
                        <c:when test="${order.orderStatus ==1}">
                            <td width="30%">订单状态: 支付成功</td>
                        </c:when>
                        <c:otherwise>
                            <td width="30%">订单状态: 支付失败</td>
                        </c:otherwise>
                    </c:choose>
                    <%--<td width="30%">订单状态:${order.orderStatus}</td>--%>
                    <td width="30%">总金额:${order.totalMoney}</td>
                </tr>
                <c:forEach var="detail" items="${orderDetailList}" varStatus="detail_index">
                    <c:choose>
                        <c:when test="${detail.goodsOrderId eq order.id}">
                            <tr>
                                <td>订单详情编号：${detail.orderNum}</td>
                                <td>订单详情编号:${detail.goods.name}</td>
                                <td>价格:${detail.goodsPrice}</td>
                                <td>数量:${detail.number}</td>
                                <td>商品总价:${detail.goodsAmount}</td>
                            </tr>
                        </c:when>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <%--0--未支付，1--支付成功，2--支付失败"--%>
                    <c:when test="${order.orderStatus ==0}">
                        <tr>
                            <td colspan="5" align="center">
                                <button class="btn-pay"><a href="http://localhost:8080/pay/pay.htm?peopleId=${person.id}&&orderNum=${orderNum}&&isPay=true">支    付</a></button>
                                <button class="btn-cancel">取消订单</button>
                            </td>
                        </tr>
                    </c:when>
                    <c:when test="${order.orderStatus ==1}">
                        <tr>
                            <td colspan="5" align="center">
                                <button class="btn-evalute">评    价</button>
                                <button class="btn-delete">删除订单</button>
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <button class="btn-pay"><a href="http://localhost:8080/pay/pay.htm?peopleId=${person.id}&&orderNum=${orderNum}&&isPay=true">支    付</a></button>
                        <button class="btn-cancel">取消订单</button>
                    </c:otherwise>
                </c:choose>
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
                    <td height="10px" colspan="3"></td>
                </tr>
                </tbody>
            </c:forEach>
            
            <%--<c:forEach var="orderDetail" items="orderDetailList" varStatus="detail_index">--%>
                <%--<tr bgcolor="white">--%>
                    <%--<td>${orderDetail.goodsOrderId}</td>--%>
                    <%--<td>订单详情编号:${orderDetail.orderNum}</td>--%>
                    <%--<td>价格:${orderDetail.goodsPrice}</td>--%>
                    <%--<td>数量:${orderDetail.number}</td>--%>
                    <%--<td>商品总价:${orderDetail.goodsAmount}</td>--%>
                <%--</tr>--%>
                <%--&lt;%&ndash;<c:choose>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<c:when test="${orderDetail.goodsOrderId eq 1}">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<tr bgcolor="white">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<td>订单详情编号:${orderDetail.orderNum}</td>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<td>价格:${orderDetail.goodsPrice}</td>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<td>数量:${orderDetail.number}</td>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<td>商品总价:${orderDetail.goodsAmount}</td>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</c:when>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</c:choose>&ndash;%&gt;--%>
            <%--</c:forEach>--%>
            <tbody>
            <%--<tr>--%>
                <%--<td>订单详情总数：${fn:length(orderDetailList)}</td>--%>
            <%--</tr>--%>
            <%--<c:forEach var="detail" items="${orderDetailList}" varStatus="detail_index">--%>
                <%--<tr>--%>
                    <%--<td>订单详情编号：${detail.orderNum}</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            </tbody>

            <%--<c:forEach var="orderDetail" items="orderDetailList" varStatus="detail_index">--%>
                <%--<tr bgcolor="white">--%>
                     <%--&lt;%&ndash;<td>${orderDetail.goodsOrderId}</td>&ndash;%&gt;--%>
                     <%--<td>订单详情编号:${orderDetail.orderNum}</td>--%>
                     <%--<td>价格:${orderDetail.goodsPrice}</td>--%>
                     <%--<td>数量:${orderDetail.number}</td>--%>
                     <%--<td>商品总价:${orderDetail.goodsAmount}</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>

            <%--<tbody>--%>
            <%--<tr></tr>--%>
            <%--<tr bgcolor="silver">--%>
                <%--<td width="30%">订单编号</td>--%>
                <%--<td width="30%">订单状态</td>--%>
                <%--<td width="30%">总金额</td>--%>
            <%--</tr>--%>
            <%--<tr bgcolor="white">--%>
                <%--<td>商品信息1</td>--%>
                <%--<td>价格</td>--%>
                <%--<td>数量</td>--%>
                <%--<td>状态</td>--%>
            <%--</tr>--%>
            <%--<tr bgcolor="white">--%>
                <%--<td>商品信息2</td>--%>
                <%--<td>价格</td>--%>
                <%--<td>数量</td>--%>
                <%--<td>状态</td>--%>
            <%--</tr>--%>
            <%--<tr bgcolor="white">--%>
                <%--<td>商品信息3</td>--%>
                <%--<td>价格</td>--%>
                <%--<td>数量</td>--%>
                <%--<td>状态</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td colspan="4" align="center">--%>
                    <%--<button class="btn-evalute">评    价</button>--%>
                    <%--<button class="btn-delete">删除订单</button>--%>
                    <%--<button class="btn-pay">支    付</button>--%>
                    <%--<button class="btn-cancel">取消订单</button>--%>
                    <%--<button class="btn-recive">确定收货</button>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--&lt;%&ndash;</tbody>&ndash;%&gt;--%>
        </table>
    </div>
</div>

</body>
</html>
