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
            <li><a href="/order/order.htm?way=all&&peopleId=${person.id}" target="_blank">查看订单</a></li>
            <li><a href="/${basePath}storeAction!storeHome.do?peopleId=${person.id}" target="_blank">卖家中心</a></li>
            <li><a href="/servlet/mainPage.htm" target="_blank">商品分类</a></li>
            <li><a href="/servlet/cartPage.htm?op=list" target="_blank">购物车</a></li>
            <li><a href="/servlet/mainPage.htm" target="_blank">淘宝网首页</a></li>
        </ul>
    </div>
    <div class="site-nav-two">
        <marquee scrollAmount=2 width=100% direction="left" behavior="scroll" onmouseover=stop() onmouseout=start()>
            <li style="color: #6C6C6C">欢迎${person.name}光临大明星购物平台，祝您生活愉快，激情购物！</li>
        </marquee>
    </div>
</div>
<br>
<br>
<br>
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
                    <a href="#">宝贝</a>
                </li>
                <%--<li id="tab_2" class="selected">--%>
                <%--<a href="#">店铺</a>--%>
                <%--</li>--%>
            </ul>
        </div>
        <!--搜索框主体-->
        <div class="search-pannel">
            <form action="/servlet/mainPageSearch.htm" method="post" target="_blank">
                <div class="search-tips">
                    <%--<a href="#" target="_blank">--%>
                    <%--高级<br>搜索--%>
                    <%--</a>--%>
                </div>
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
<br>
<br>
</body>
<script type="text/javascript">
    var getDOM = function (id) {
        return document.getElementById(id);
    }
    var addEvent = function (id, event, fn) {
        //这里用一个 ||document，为了防止getDOM为null的时候程序会报错
        var el = getDOM(id) || document;
        /*
         el.addEventListener适用于非IE浏览器，el.attachEvent适用于IE浏览器
         */
        if (el.addEventListener) {
            el.addEventListener(event, fn, false);
        } else if (el.attachEvent) {
            el.attachEvent("on" + event, fn);
        }
    }
    var flag = true;
    addEvent("search_tab", "mouseover", function () {
        if (this.className.indexOf("trigger-hover") < 0) {
            this.className += " trigger-hover";
        }
    })
    addEvent("tab_1", "mouseover", function () {
        if (this.className.indexOf("selected") < 0) {
            this.className += " selected";
        }
    })
    addEvent("tab_1", "mouseout", function () {
        if (flag) {
            this.className = " ";
        }
        flag = true;
    })
    addEvent("tab_1", "click", function () {
        getDOM("search_tab").className = "search-list";
        this.className = "selected";
        flag = false;
    })
    //    addEvent("tab_2", "mouseover", function () {
    //        if (this.className.indexOf("selected") < 0) {
    //            this.className += " selected";
    //        }
    //    })
    addEvent("tab_2", "mouseout", function () {
        if (flag) {
            this.className = " ";
        }
        flag = true;
    })
    /*每点击一次，都会出发onmouseout事件，
     所以要设计一个标记来表示是否是出发了点击事件，
     如果是，那么onmouseout将不会清除样式*/
    addEvent("tab_2", "click", function () {
        getDOM("search_tab").className = "search-list";
        this.className = "selected";
        console.log(this.className);
        flag = false;
    })
</script>

<%--搜索框的实现--%>
<script type="text/javascript">
    $('#submit').live("click", function () {
        var condition = document.getElementById("search").value;
        var url = '/servlet/mainPageSearch.htm';
        var data = {
            condition: condition
        };
        var success = function (response) {
            if (response.errno == 0) {
                alert(response.errmsg);
            }
        };
        $.post(url, data, success, 'json');
    });
</script>
</html>
