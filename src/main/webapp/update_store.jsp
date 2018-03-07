<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/28 0028
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="${basePath}/css/admin_page_css.css" rel="stylesheet" />
    <script src="${basePath}../js/jquery-1.7.2.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="head_page.jsp"/>
<div id="all_div" align="center">
    <form action="${pageContext.request.contextPath}/action/updateStoreAction!updateStore.do" method="post" name="subForm" id="subForm">
        <table align="center" border="1" class="table_update_store">
            <thead>
            <tr>
                <th colspan="2">店铺信息</th>
            </tr>
            <tr>
                <th>属性</th>
                <th>值</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>ID</td>
                <td><input type="text" name="storeId" class="store_id" value="${updStore.id}"/></td>
            </tr>
            <tr>
                <td>STORE_NUM</td>
                <td><input type="text" name="storeNum" class="store_store_num" value="${updStore.storeNum}"/></td>
            </tr>
            <tr>
                <td>STORE_NAME</td>
                <td><input type="text" name="storeName" class="store_store_name" value="${updStore.storeName}"/></td>
            </tr>
            <tr>
                <td>CREDIT</td>
                <td><input type="text" name="credit" class="store_credit" value="${updStore.credit}"/></td>
            </tr>
            <tr>
                <td>PEOPLE_ID</td>
                <td><input type="text" name="peopleId" class="store_people_id" value="${updStore.peopleId}"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><button type="submit" id="upd_store_btn">确认修改</button> </td>
            </tr>
            </tbody>
        </table>
    </form>

</div>

<%--<script type="text/javascript">--%>
    <%--$("#upd_store_btn").click(function(){--%>
        <%--var storeId=$(".store_id").val();--%>
        <%--var storeNum=$(".store_store_num").val();--%>
        <%--var storeName=$(".store_store_name").val();--%>
        <%--var credit=$(".store_credit").val();--%>
        <%--var peopleId=$(".store_people_id").val();--%>
        <%--alert(id+" "+storeName);--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${pageContext.request.contextPath}/test/updateStore.htm",--%>
            <%--data:{storeId:storeId,storeNum:storeNum,storeName:storeName,credit:credit,peopleId:peopleId},--%>
            <%--dataType:'json',--%>
            <%--success:function(){--%>
                <%--window.location.href="${pageContext.request.contextPath}/administrator_page.jsp";--%>
            <%--},--%>
            <%--error:function(){--%>
                <%--alert("修改失败");--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>

<%--<script type="text/javascript">--%>
<%--$(document).ready(function(){--%>
<%--alert("开始");--%>
<%--});--%>
<%--$("#admin-user").click(function(){--%>
<%--$.ajax({--%>
<%--type:'POST',--%>
<%--url:'/test/adminUser.htm',--%>
<%--data:{command:"findPeople"},--%>
<%--dataType:"text",--%>
<%--success:function(data){--%>
<%--alert(data)--%>
<%--alert("success");--%>
<%--},--%>
<%--error:function(data){--%>
<%--alert(data);--%>
<%--alert("error")--%>
<%--}--%>

<%--});--%>
<%--});--%>
<%--$("admin-seller").click(function(){--%>

<%--});--%>
<%--</script>--%>


</body>
</html>
