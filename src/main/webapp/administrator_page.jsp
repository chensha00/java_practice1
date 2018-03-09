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
    <title>管理账户</title>
    <link href="${basePath}/css/admin_page_css.css" rel="stylesheet" />
    <script src="${basePath}../js/jquery-1.7.2.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="head_page.jsp"/>
<div id="all_div">
    <div id="button_div">
        <ul>
            <%--<a href="/test/adminUser.htm?command=findPeople">--%>
                <%--<a href="/test/adminUser.htm?command=findStore">--%>
            <li><button id="admin-user">管理人员</button></li>
            <li><button id="admin-seller">管理卖家</button></li>
        </ul>
    </div>
    <br/><br/>
    <div id="message_div">
        <div>
            <c:if test="${not empty peopleList}">
                <table align="center" border="1" id="table_people">
                    <thead>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>CARD_ID</th>
                    <th>SEX</th>
                    <th>AGE</th>
                    <th>MONEY</th>
                    <th>ADDRESS</th>
                    <th>USERNAME</th>
                    <th>PASSWORD</th>
                    <th>${fn:length(peopleList)}</th>
                    </thead>
                    <tbody>
                    <c:forEach var="people" items="${peopleList}" varStatus="people_index">
                        <tr>
                            <td class="people_id">${people.id}</td>
                            <td>${people.name}</td>
                            <td>${people.cardId}</td>
                            <td>${people.sex}</td>
                            <td>${people.age}</td>
                            <td>${people.money}</td>
                            <td>${people.address}</td>
                            <td>${people.usreName}</td>
                            <td>${people.passWord}</td>
                            <td><button class="del_btn">删除</button><button class="upd_btn">修改</button></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <div>
            <c:if test="${not empty storeList}">
                <table border="1" align="center" id="table_store">
                    <thead>
                    <tr>
                        <th>店铺信息管理</th>
                    </tr>
                    <tr>
                        <th>ID</th>
                        <th>STORE_NUM</th>
                        <th>STORE_NAME</th>
                        <th>CREDIT</th>
                        <th>PEOPLE_ID</th>
                        <th>${fn:length(storeList)}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="store" items="${storeList}" varStatus="store_index">
                        <tr>
                            <td class="store_id">${store.id}</td>
                            <td>${store.storeNum}</td>
                            <td>${store.storeName}</td>
                            <td>${store.credit}</td>
                            <td>${store.peopleId}</td>
                            <td><button class="del_btn">删除</button><button class="upd_btn">修改</button></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    <div id="result">

    </div>
</div>
<script type="text/javascript">
    $("#admin-user").click(function(){
        window.location.href="${basePath}/action/adminUserAction!findPeopleAll.do";
    });
    $("#admin-seller").click(function(){
        window.location.href="${basePath}/action/adminUserAction!findStoreAll.do";
    });
    $("#table_people").find(".del_btn").click(function(){
        alert("del_btn");
        var people_id=$(this).parent("td").siblings(".people_id").text();
        alert(people_id);
        window.location.href="${basePath}/action/adminUserAction!deletePeople.do?peopleId="+people_id;
    });
    $("#table_people").find(".upd_btn").click(function(){
        alert("upd_btn");
        var people_id=$(this).parent("td").siblings(".people_id").text();
        alert(people_id);
        window.location.href="${basePath}/action/adminUserAction!updatePeople.do?peopleId="+people_id
    });
    $("#table_store").find(".del_btn").click(function(){
        alert("del_btn");
        var store_id=$(this).parent("td").siblings(".store_id").text();
        alert(store_id);
        window.location.href="${basePath}/action/adminUserAction!deleteStore.do?storeId="+store_id;
    });
    $("#table_store").find(".upd_btn").click(function(){
        alert("upd_btn");
        var store_id=$(this).parent("td").siblings(".store_id").text();
        alert(store_id);
        window.location.href="${basePath}/action/adminUserAction!updateStore.do?storeId="+store_id;
    });
</script>

<%--<script type="text/javascript">--%>
    <%--$("#admin-user").click(function(){--%>
        <%--window.location.href="${basePath}/action/adminUserAction!findPeopleAll.do?"--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/action/adminUserAction!findPeopleAll.do",--%>
<%--//            data:{command:"findPeople"},--%>
            <%--dataType:"text",--%>
            <%--success:function(){--%>
<%--//                alert(data);--%>
                <%--alert("success");--%>
                <%--window.location.reload();--%>
            <%--},--%>
            <%--error:function(data){--%>
                <%--alert(data);--%>
                <%--alert("error");--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
    <%--$("#admin-seller").click(function(){--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/action/adminUserAction!findStoreAll.do",--%>
<%--//            data:{command:"findStore"},--%>
            <%--dataType:"text",--%>
            <%--success:function(){--%>
<%--//                alert(data);--%>
                <%--alert("success");--%>
                <%--window.location.reload();--%>
            <%--},--%>
            <%--error:function(data){--%>
                <%--alert(data);--%>
                <%--alert("error");--%>
            <%--}--%>
        <%--})--%>
    <%--});--%>
    <%--$("#table_people").find(".del_btn").click(function(){--%>
        <%--alert("del_btn");--%>
        <%--var people_id=$(this).parent("td").siblings(".people_id").text();--%>
        <%--alert(people_id);--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/action/adminUserAction!deletePeople.do",--%>
            <%--data:{id:people_id},--%>
            <%--dataType:"text",--%>
            <%--success:function(){--%>
                <%--window.location.reload();--%>
            <%--},--%>
            <%--error:function(){--%>
                <%--alert("信息错误")--%>
            <%--}--%>
        <%--});--%>

    <%--});--%>
    <%--$("#table_people").find(".upd_btn").click(function(){--%>
        <%--alert("upd_btn");--%>
        <%--var people_id=$(this).parent("td").siblings(".people_id").text();--%>
        <%--alert(people_id);--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/action/adminUserAction!updatePeople.do",--%>
            <%--data:{peopleId:people_id},--%>
            <%--dataType:"text",--%>
            <%--success:function(data){--%>

                <%--$("#result").html(data);--%>
                <%--alert("success");--%>
                <%--&lt;%&ndash;window.location.href="${basePath}/update_people.jsp";&ndash;%&gt;--%>
            <%--},--%>
            <%--error:function(data){--%>
                <%--alert(data)--%>
                <%--alert("信息错误")--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
    <%--$("#table_store").find(".del_btn").click(function(){--%>
        <%--alert("del_btn");--%>
        <%--var store_id=$(this).parent("td").siblings(".store_id").text();--%>
        <%--alert(store_id);--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/action/adminUserAction!deleteStore.do",--%>
            <%--data:{useClass:"store",id:store_id,handleWays:"delete"},--%>
            <%--dataType:"text",--%>
            <%--success:function(data){--%>
                <%--alert(data)--%>
                <%--window.location.reload();--%>
            <%--},--%>
            <%--error:function(data){--%>
                <%--alert(data)--%>
                <%--alert("信息错误")--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
    <%--$("#table_store").find(".upd_btn").click(function(){--%>
        <%--alert("upd_btn");--%>
        <%--var store_id=$(this).parent("td").siblings(".store_id").text();--%>
        <%--alert(store_id);--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/test/handleAdmin.htm",--%>
            <%--data:{useClass:"store",id:store_id,handleWays:"update"},--%>
            <%--dataType:"text",--%>
            <%--success:function(data){--%>
<%--//                alert(data)--%>
<%--//                window.location.reload();--%>
                <%--window.location.href="${basePath}/update_store.jsp";--%>
            <%--},--%>
            <%--error:function(data){--%>
                <%--alert(data)--%>
                <%--alert("信息错误")--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>

<%--<script type="text/javascript">--%>
    <%--$("#admin-user").click(function(){--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/test/adminUser.htm",--%>
            <%--data:{command:"findPeople"},--%>
            <%--dataType:"text",--%>
            <%--success:function(){--%>
<%--//                alert(data);--%>
                <%--alert("success");--%>
                <%--window.location.reload();--%>
            <%--},--%>
            <%--error:function(data){--%>
                <%--alert(data);--%>
                <%--alert("error");--%>
            <%--}--%>
        <%--})--%>
    <%--});--%>
    <%--$("#admin-seller").click(function(){--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/test/adminUser.htm",--%>
            <%--data:{command:"findStore"},--%>
            <%--dataType:"text",--%>
            <%--success:function(){--%>
<%--//                alert(data);--%>
                <%--alert("success");--%>
                <%--window.location.reload();--%>
            <%--},--%>
            <%--error:function(data){--%>
                <%--alert(data);--%>
                <%--alert("error");--%>
            <%--}--%>
        <%--})--%>
    <%--});--%>
    <%--$("#table_people").find(".del_btn").click(function(){--%>
        <%--alert("del_btn");--%>
        <%--var people_id=$(this).parent("td").siblings(".people_id").text();--%>
        <%--alert(people_id);--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/test/handleAdmin.htm",--%>
            <%--data:{useClass:"people",id:people_id,handleWays:"delete"},--%>
            <%--dataType:"text",--%>
            <%--success:function(){--%>
                <%--window.location.reload();--%>
            <%--},--%>
            <%--error:function(){--%>
                <%--alert("信息错误")--%>
            <%--}--%>
        <%--});--%>

    <%--});--%>
    <%--$("#table_people").find(".upd_btn").click(function(){--%>
        <%--alert("upd_btn");--%>
        <%--var people_id=$(this).parent("td").siblings(".people_id").text();--%>
        <%--alert(people_id);--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/test/handleAdmin.htm",--%>
            <%--data:{useClass:"people",id:people_id,handleWays:"update"},--%>
            <%--dataType:"text",--%>
            <%--success:function(data){--%>
<%--//                alert(data);--%>
                <%--window.location.href="${basePath}/update_people.jsp";--%>
            <%--},--%>
            <%--error:function(data){--%>
                <%--alert(data)--%>
                <%--alert("信息错误")--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
    <%--$("#table_store").find(".del_btn").click(function(){--%>
        <%--alert("del_btn");--%>
        <%--var store_id=$(this).parent("td").siblings(".store_id").text();--%>
        <%--alert(store_id);--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/test/handleAdmin.htm",--%>
            <%--data:{useClass:"store",id:store_id,handleWays:"delete"},--%>
            <%--dataType:"text",--%>
            <%--success:function(data){--%>
                <%--alert(data)--%>
                <%--window.location.reload();--%>
            <%--},--%>
            <%--error:function(data){--%>
                <%--alert(data)--%>
                <%--alert("信息错误")--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
    <%--$("#table_store").find(".upd_btn").click(function(){--%>
        <%--alert("upd_btn");--%>
        <%--var store_id=$(this).parent("td").siblings(".store_id").text();--%>
        <%--alert(store_id);--%>
        <%--$.ajax({--%>
            <%--type:'POST',--%>
            <%--url:"${basePath}/test/handleAdmin.htm",--%>
            <%--data:{useClass:"store",id:store_id,handleWays:"update"},--%>
            <%--dataType:"text",--%>
            <%--success:function(data){--%>
<%--//                alert(data)--%>
<%--//                window.location.reload();--%>
                <%--window.location.href="${basePath}/update_store.jsp";--%>
            <%--},--%>
            <%--error:function(data){--%>
                <%--alert(data)--%>
                <%--alert("信息错误")--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>


</body>
</html>
