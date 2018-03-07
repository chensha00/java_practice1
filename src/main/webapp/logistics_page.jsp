<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/4
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>物流详情</title>

    <style type="text/css">
        body{
            padding: 0;
            margin:0;
        }
        a{text-decoration: none}
        ul,li{
            font-size: 14px;
            list-style: none;
        }
        .head_div{
            width: 1350px;margin:0 auto;
        }
        .logistics_info{
            background-color: antiquewhite;
        }
        .logistics_info div{
            width: 400px;margin-left: 100px;text-align: center
        }
        .logistics_info tr td:first-child{
            text-align: right;
        }

        #logostics_details{
            background-color: #ffed83;
            text-align: center;
            width: 605px;
            margin: 0 auto;
        }
        #logostics_details div{
            height:30px;
            border: 1px solid darkorange;
            background-color: #ffe0c6;
        }
        /*#logostics_details td{*/
            /*border-bottom: 1px solid darkorange;*/
        /*}*/
    </style>
</head>
<body>
<jsp:include page="head_page.jsp"></jsp:include>


<div class="head_div">
    <c:choose>
        <c:when test="${logisticsInfo!=null}">
            <ul class="logistics_info">
                <div>
                    <table>
                        <tr>
                            <td>物流单号：</td>
                            <td>${logisticsInfo.logisticsNum}</td>
                        </tr>
                        <tr>
                            <td>创建时间：</td>
                            <td>${logisticsInfo.logisticsTime}</td>
                        </tr>
                        <tr>
                            <td>物流状态：</td>
                            <td>${logisticsInfo.logisticsState}</td>
                        </tr>
                        <tr>
                            <td>发货方：</td>
                            <td>${logisticsInfo.deliverName}</td>
                        </tr>
                        <tr>
                            <td>收货方：</td>
                            <td>${logisticsInfo.consigneeName}</td>
                        </tr>
                        <tr>
                            <td>收货方电话：</td>
                            <td>${logisticsInfo.consigneePhone}</td>
                        </tr>
                        <tr>
                            <td>收货地址：</td>
                            <td>${logisticsInfo.consigneeAddress}</td>
                        </tr>
                    </table>
                </div>
            </ul>

            <div style="background-color: rgba(255,223,198,0.43);height: 400px">
                <div id="logostics_details">
                    <div style="width: 300px;float: left">时间</div>
                    <div style="width: 300px;float:left;">到达地</div>
                    <c:forEach items="${gobyList}" var="goby" >
                        <div style="width: 300px;float: left">${goby.gobyTime}</div>
                        <div style="width: 300px;float:left;">${goby.gobyAddress}</div>
                    </c:forEach>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <p style="text-align: center;">您的商品还没发货！</p>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
