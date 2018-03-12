<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/10
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加物流信息</title>

    <style type="text/css">
        body{
            padding: 0;
            margin:0;
        }
        a{
            text-decoration: none
        }
        ul,li{
            list-style: none;
        }
        .head_div{
            width: 1350px;
            margin:0 auto;
        }
        .logistics_info{
            background-color: antiquewhite;
            text-align: center
        }
        .logistics_info div{
            width: 400px;
            margin-left: 100px;
        }

        #logostics_details{
            width:300px;
            margin: 0 auto;
        }
        #logostics_details div{
            height:30px;
            border: 1px solid darkorange;
            background-color: #ffe0c6;
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
</head>
<body>
<jsp:include page="head_page.jsp"></jsp:include>


<div class="head_div">


    <div class="logistics_info">
        添加物流信息
    </div>


    <div style="background-color: rgba(255,223,198,0.43);height: 400px">
        <div id="logostics_details">
            <form action="${pageContext.request.contextPath}/action/logisticsAction!addLogistics.do" method="post">
            <table >
                <tr>
                    <td>发货人姓名：</td>
                    <td><input type="text" name="deliver_name"></td>
                    <td style="color: red">*</td>
                </tr>
                <tr>
                    <td>发货人电话：</td>
                    <td><input type="text" name="deliver_phone"></td>
                    <td style="color: red">*</td>
                </tr>
                <tr>
                    <td>发货地址：</td>
                    <td><input type="text" name="deliver_address"></td>
                    <td style="color: red">*</td>
                </tr>
                <tr>
                    <td>收货人姓名：</td>
                    <td><input type="text" name="consignee_name"></td>
                    <td style="color: red">*</td>
                </tr>
                <tr>
                    <td>收货人电话：</td>
                    <td><input type="text" name="consignee_phone"></td>
                    <td style="color: red">*</td>
                </tr>
                <tr>
                    <td>收货地址：</td>
                    <td><input type="text" name="consignee_address"></td>
                    <td style="color: red">*</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr >
                    <td ><button type="button" value="sub" style="float: right;width: 50px;" id="sub">提交</button></td>
                    <td >&nbsp;&nbsp;<button type="reset" style="width: 50px">重填</button> </td>
                </tr>
            </table>
            </form>
        </div>
    </div>


</div>
<script type="text/javascript">
    var sub=document.getElementById("sub");
    sub.onclick=function (event) {

        var deliver_name=$("input[name='deliver_name']").val();
        if(deliver_name==null||deliver_name==""){
            alert("发货人未填写！");
            return false;
        }
        var deliver_phone=$("input[name='deliver_phone']").val();
        if(deliver_phone==null||deliver_phone==""){
            alert("发货人电话未填写！");
            return false;
        }
        var deliver_address=$("input[name='deliver_address']").val();
        if(deliver_address==null||deliver_address==""){
            alert("发货地址未填写！");
            return false;
        }
        var consignee_name=$("input[name='consignee_name']").val();
        if(consignee_name==null||consignee_name==""){
            alert("收货人未填写！");
            return false;
        }
        var consignee_phone=$("input[name='consignee_phone']").val();
        if(consignee_phone==null||consignee_phone==""){
            alert("收货人电话未填写！");
            return false;
        }
        var consignee_address=$("input[name='consignee_address']").val();
        if(consignee_address==null||consignee_address==""){
            alert("收货地址未填写！");
            return false;
        }
        $.ajax({
            type:"post",
            data:{
                deliver_name:deliver_name,
                deliver_phone:deliver_phone,
                deliver_address:deliver_address,
                consignee_name:consignee_name,
                consignee_phone:consignee_phone,
                consignee_address:consignee_address
            },
            dataType:"json",
            url:"${pageContext.request.contextPath}/action/logisticsAction!addLogistics.do",
            success:function (x) {
                var message=eval(x);
                alert(message.MESSAGE);
            },
            error:function (err) {
                alert("提交失败");
            }
        })
    }

</script>
</body>
</html>
