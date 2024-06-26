<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>游戏管理</title>
	<%@include file="/pages/common/header.jsp"%>
	<script type="text/javascript">
		$(function () {
			//给删除的a标签绑定单击事件，用于删除提示
			$("a.deleteClass").click(function () {
				/**
				 * 返回true表示确认
				 */
				return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】?");

			})
		})
	</script>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo1.jpg" >
			<span class="wel_word">游戏管理</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
	</div>

	<div id="main">
		<table style="height: 350px">
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}" var="game">
				<tr>
					<td>${game.name}</td>
					<td>${game.price}</td>
					<td>${game.author}</td>
					<td>${game.sales}</td>
					<td>${game.stock}</td>
					<td><a href="manager/gameServlet?&action=getGame&id=${game.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td><a class="deleteClass" href="manager/gameServlet?action=delete&id=${game.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/Game_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加游戏</a></td>
			</tr>
		</table>
		<%@include file="/pages/common/page_nav.jsp"%>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
