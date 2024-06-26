<%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2024/10/5
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商城首页</title>
    <%@include file="/pages/common/header.jsp"%>
    <script type="text/javascript">
        $(function () {
            //给加入购物车绑定单击事件
            $("button.addToCart").click(function () {
                var gameId = $(this).attr("gameId");
                //发ajax请求添加商品到购物车
                $.getJSON("http://localhost:8080/Game/cartServlet", "action=ajaxAddItem&id=" + gameId, function (data) {
                    $("#cartTotalCount").text("您的购物车中有" + data.totalCount + "件商品");
                    $("#cartLastName").html("您刚刚将【" + data.lastName + "】加入到了购物车中");
                });

            });
        });

    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo1.jpg" >
    <span class="wel_word">Gamestore</span>
    <div class="menu">
        <c:if test="${empty sessionScope.user}">

            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
            <a href="client/gameServlet?action=pageOrder">热榜</a>
        </c:if>

        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临商城</span>
            <a href="client/orderServlet?action=myOrders">我的订单</a>
            <a href="pages/user/userinfo.jsp">个人信息</a>
            <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
        </c:if>

        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div class="game_check">
        <form action="client/gameServlet" method="get">
            <input type="hidden" name="action" value="pageByNameOrAuthor">
            游戏搜索<input id="nameorauthor" type="text" placeholder="请输入游戏名或作者名" name="nameorauthor" value="${param.nameorauthor}">
            <input type="submit" value="查询" />
        </form>
    </div>
    <div id="game">
        <div class="game_cond">
            <form action="client/gameServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询" />
            </form>
        </div>
        <div style="text-align: center">
            <c:if test="${empty sessionScope.cart.items}">
                <span id="cartTotalCount"></span>
                <div>
                    <span style="color: red" id="cartLastName">当前购物车为空</span>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <span id="cartTotalCount">您的购物车中有${sessionScope.cart.totalCount}件商品</span>
                <div>
                    您刚刚将<span style="color: red" id="cartLastName">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </c:if>
        </div>

        <c:forEach items="${requestScope.page.items}" var="game">
            <div class="b_list">
                <div class="img_div">
                    <img class="game_img" alt="" src="${game.imgPath}" />
                </div>
                <div class="game_info">
                    <div class="game_name">
                        <span class="sp1">游戏名:</span>
                        <span class="sp2">${game.name}</span>
                    </div>
                    <div class="game_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${game.author}</span>
                    </div>
                    <div class="game_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${game.price}</span>
                    </div>
                    <div class="game_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${game.sales}</span>
                    </div>
                    <div class="game_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${game.stock}</span>
                    </div>
                    <div class="game_add">
                        <button gameId=${game.id} class="addToCart">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

    <%@include file="/pages/common/page_nav.jsp"%>

</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
