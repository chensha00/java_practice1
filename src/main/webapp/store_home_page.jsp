<%@ page import="domain.Store" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: HZQ
  Date: 2018/1/29
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp"%>
<html>
<head>
    <title>store_home_page</title>
    <link href="${basePath}/css/store_home_page_css.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="head_page.jsp"></jsp:include>
<div class="body">
<div class="store_home">
    <div class="store_home_left">
        <div class="store_home_storeInfo">
            <h4>${stores[0].storeName} </h4>
            <br><br>
            <div class="storeInfo_font">
                店主：${person.name}
            </div>
        </div>
        <div class="store_home_delivery">
            <a href="/StoreServletStock.htm"> <h4>我要进货</h4></a>
        </div>
        <div class="store_home_delivery">
            <a href="store_order.jsp"> <h4>我要发货</h4></a>
        </div>
        <div class="store_home_delivery">
            <a href="store_order.jsp"> <h4>历史订单</h4></a>
        </div>
        <div class="store_home_delivery">
             <a href="store_order.jsp"> <h4>最近订单</h4></a>
        </div>
    </div>
    <div class="store_home-right">
        <div class="store_home_goodsListHead">
            商品列表
        </div>
        <div class="store_home_goods">
           <c:if test="${goods==null||fn:length(goods)==0}" >
               <h2>你还没有商品上架！</h2>
           </c:if>
            <c:forEach items="${goods}" var="good" varStatus="status">
                <c:forEach items="${invertorys}" var="invertory" varStatus="status">
                <div class="store_home_good">
                    <div class="store_home_goodImg">
                        <img src="${basePath}/img/1.jpg"></src>
                    </div>
                    <div class="store_home_goodInfo">
                        <div class="store_home_goodName">
                                ${good.name}
                        </div>
                        <div class="store_home_goodPrice">
                                ${invertory.price}
                        </div>
                        <div class="store_home_goodPrice">
                                商品下架
                        </div>
                    </div>
                </div>
                    </c:forEach>
            </c:forEach>
        </div>
    </div>
    <div class="limit">
        <form class="form" name="f1" method="POST" action="index.jsp" onSubmit="return checknum()">
            <table border="0" align="center" class="tb">
                <tr>
                    <td>第1页 共10页 <a href="index.jsp?pages=1">首页</a></td>
                    <td><a href=""> 上一页</a></td>
                    <td><a href=""> 下一页</a></td>
                    <td><a href="">最后一页</a></td>
                    <td>转到第:<input type="text" name="page" size="8">页<input type="submit" value="GO" name="cndok"></td>
                </tr>
            </table>
        </form>
    </div>
    </div>
</div>
</div>
</body>
</html>
