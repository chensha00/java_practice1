<%--
  Created by IntelliJ IDEA.
  User: HS
  Date: 2018/1/30
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<html>
<head>
    <title>表头</title>
    <script src="js/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" href="${basePath}../css/head_page_css.css">
</head>
<body>
<div id="K_SiteNav" class="site-nav">
    <div id="K_SiteNavBd" class="site-nav-bd">
        <ul class="site-nav-bd-one">
            <li><a href="../login_page.jsp" target="_top">登录/注册</a></li>
            <li><a href="../person.jsp" target="_blank">用户：${person.name}</a></li>
            <li>
                <a href="${pageContext.request.contextPath}/action/userOrderAction!findOrderAll.do?peopleId=${person.id}"
                   target="_blank">查看订单</a></li>
            <li><a href="/${basePath}storeAction!storeHome.do?peopleId=${person.id}" target="_blank">卖家中心</a></li>
            <%--<li><a href="/mainAction!main.do" target="_blank">商品分类</a></li>--%>
            <li><a href="javascript:void(0)"
               onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">
                商品分类</a></li>
            <li><a href="/mainAction!cart.do?op=list" target="_blank">购物车</a></li>
            <li><a href="/mainAction!main.do">商城首页</a></li>
        </ul>
    </div>
    <div class="site-nav-two">
        <marquee scrollAmount=2 width=100% direction="left" behavior="scroll" onmouseover=stop() onmouseout=start()>
            <li style="color: #6C6C6C">欢迎${person.name}光临星光购物平台，祝您生活愉快，购物开心！</li>
        </marquee>
    </div>
</div>
<br>
<br>

<%--分类悬浮框--%>
<div id="light" class="white_content">
    <ul class="ul-sort">
        <li><p><a href="/mainAction!classify.do?type=0">电脑</a></p></li>
        <li><p><a href="/mainAction!classify.do?type=1">清洁用品</a></p></li>
        <li><p><a href="/mainAction!classify.do?type=3">服装</a></p></li>
        <li><p><a href="/mainAction!classify.do?type=2">运动器材</a></p></li>
    </ul>
    <p class="close"><a href="javascript:void(0)"
       onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">点击关闭本窗口</a></p>
</div>
<div id="fade" class="black_overlay"></div>

<!--搜索框-->
<div class="search-entirety">
    <div class="search-logo">
        <img src="${basePath}../img/logo.jpg"/>
    </div>
    <div class="search-container">
        <!--搜索框表单-->
        <div id="search_tab" class="search-list">
            <ul>
                <li id="tab_1" class="selected">
                    <a href="#">宝贝|店铺</a>
                </li>
            </ul>
        </div>
        <!--搜索框主体-->
        <div class="search-pannel">
            <form action="/mainAction!search.do" method="post" target="_blank">
                <div class="search-button">
                    <button class="btn-search" id="submit">
                        <li style="color: #cccccc">搜索</li>
                    </button>
                </div>
                <div class="search-common-panel">
                    <input type="text" x-webkit-speech=" " name="search" id="search">
                    <i class="iconfont">ő</i>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
</body>

</html>
