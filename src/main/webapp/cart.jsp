<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lionk
  Date: 2018/1/31
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <script src="${basePath}../js/jquery-1.7.2.min.js"></script>
    <script src="${basePath}../js/jquery-1.7.2.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${basePath}../css/cart_css.css">
</head>

<body>

<jsp:include page="head_page.jsp" flush="true"/>

<div class="cart_div">
    <form action="/pay_money_jsp.jsp" method="post" class="form">
        <fieldset>
            <legend><img src="${basePath}../img/cart.jpg"></legend>
            <table class="cart_table" id="tab" border="1">
                <thead class="cart_thea">

                <ul class="th_ul">
                    <li><span class="th_str">商品名称</span></li>

                    <li><span class="th_str">单价</span></li>

                    <li><span class="th_str">数量</span></li>

                    <li><span class="th_str">操作</span></li>
                </ul>

                </thead>
                <tbody>
                <input type="hidden" name="peopleName" value="${person.id}">
                <c:forEach items="${cartList}" var="cart">
                    <tr>
                        <td>
                            <p class="name">${cart.name}</p>
                            <span class="price">${cart.price}</span>
                                <%--为JS获取值--%>
                            <input type="hidden" name="idName" value="${cart.invertoryId}">
                            <input type="hidden" name="numberName" value="${cart.number}">
                                <%--加减按钮--%>
                            <input class="product_id" type="hidden" name="product_id" value="value"/>
                            <input class="min" name="" type="button" value="-"/>
                            <input class="text_box" name="name2" type="text" value="1"/>
                            <input class="max" name="" type="button" value="+"/>
                            <a href="javascript:void(0);" class="delete">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <tfoot>
            <p class="to">所有商品价格总计：<label id="total" class="total" name="total"></label> 元</p>
            <input type="reset" value="数量重置" class="reset"/>
            <input type="submit" value="全部提交" class="submit" id="submit" onclick="submit"/>
            </tfoot>
        </fieldset>
    </form>

    <script>
        $(function () {
            var _url = $('#siteurl').val();
            var t = $(this).parent('td').find('input[class*=text_box]');
            t.val(1);
            //删除购物车的商品
            $('.delete').click(function () {
                var t = $(this).parent('td').parent('tr');
                var tt = $(this).parent('td').find('input[class*=text_box]');
                tt.val(0);
                setTotal();
                t.hide();
            });

            //增加商品数量
            $(".max").click(function () {
                var t = $(this).parent('td').find('input[class*=text_box]');
                t.val(parseInt(t.val()) + 1);
                setTotal();
            });

            //减少商品数量
            $(".min").click(function () {
                var t = $(this).parent('td').find('input[class*=text_box]');
                t.val(parseInt(t.val()) - 1)
                if (parseInt(t.val()) < 1) {
                    t.val(1);
                }
                setTotal();
            });

            $('.text_box').keyup(function () {
                setTotal();
            });


            function setTotal() {
                var s = 0;
                $("#tab td").each(function () {
                    //判断输入的商品数量合符规范
                    var numbers = parseInt($(this).find('input[class*=text_box]').val());
                    if ($.isNumeric(numbers)) {
                        numbers = parseInt(numbers);
                    } else {
                        numbers = 0;
                    }

                    //循环检查输入的商品数量和库存比较
//                    var array = document.getElementById("tr").rows;//所有tr
//                    var numberstr1 = document.getElementsByName("numberName")[0].value;//所有商品库存
//                    var numberstr2 = $(this).find('span[class*=price]').text();//所有输入的商品数量
//                    for (var i = 0; i < array.length; i++) {
//                        if (numberstr2[i] > numberstr1[i]) {
//                            alert("第" + i+1 + "行超出商品库存");
//                        }
//                    }

                    //计算购物车总价格
                    $(this).find('input[class*=text_box]').val(numbers);
                    s += numbers * parseFloat($(this).find('span[class*=price]').text());

                    // bof 用ajax在_url中删除指定的购物车中$_SESSION相关信息
                    var pid = $(this).find('input[class*=product_id]');
                    $.ajax({
                        url: _url,
                        type: 'post',
                        data: {proid: pid.val()},
                        success: function (data) {
                            // 回应
                        }
                    });
                    // end
                });
                $("#total").html(s.toFixed(2));
            }

            setTotal();

        });
    </script>

    <script type="text/javascript" language="JavaScript">
        //向支付页面传输数据
        $('#submit').live("click", function () {
            var peopleStr = document.getElementsByName("peopleName")[0].value;
                var idStr = "";
                var number = "";
                $("input[name='idName']").each(
                        function () {
                            idStr = idStr + ($(this).val()) + ",";
                        }
                );
                $("input[name='name2']").each(
                        function () {
                            number = number + ($(this).val()) + ",";
                        }
                );
                $.ajax({
                    type: "POST",
                    url: '/pay/pay.htm',
                    data: {
                        peopleId: peopleStr,
                        idName: idStr,
                        number: number
                    },
                    dataType: 'json',
                    success: function (response) {
                        if (response.errno == 0) {
                            alert(response.errmsg);
                        }else{
                            alert("亲，您还没登录哟！")
                        }
                    }
                })
        })
    </script>

</div>
</body>
</html>