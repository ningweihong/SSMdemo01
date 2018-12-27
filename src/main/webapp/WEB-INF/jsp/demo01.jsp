<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品展示</title>
<!-- <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet"> -->
<link href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" />
	
<script src="resources/bootstrap-3.3.7-dist/jquery/jquery.min.js"></script>
<script type="text/javascript">
	function doSubmit(id) {
		var flag = confirm("是否确认删除?");
		if (flag) {
			window.location.href = "${basePath}item/del.action?id=" + id
		}
		return flag

	}
	function dodelete(id) {
		var uid=id;
		$.ajax({
			url:"${basePath}item/test/" + uid,
			type:"get",
			dataType:"json",
			success:function (data) {
				$("#tr_"+uid).remove();
			}
		});
	}
</script>

</head>
<body>
	<c:out value="${basePath}"></c:out>
	<div class="container">
		<p>
			<a href="${basePath}item/addItem.action" class="btn btn-default">添加</a>
		</p>
		<form action="${basePath}item/delmore.action" method="post"
			onsubmit="return doSubmit()">

			<table class="table table-bordered table-hover">
				<tr>
					<th>多选</th>
					<th>编号</th>
					<th>名称</th>
					<th>价格</th>
					<th>图片</th>
					<th>详细信息</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${itemList}" var="items">
					<tr id="tr_${items.id}">
						<td><input name="ids" value="${items.id}" type="checkbox"></td>
						<td>${items.id }</td>
						<td>${items.name }</td>
						<td>${items.price }</td>
						<td>${items.pic }</td>
						<td>${items.detail }</td>
						<%-- <fmt:formatDate value="${items.createtime}" type="yyyy-MM-dd HH:mm:ss"/> --%>

						<td><fmt:formatDate value="${items.createtime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><a href="item/demo02.action?id=${items.id}"
							class="btn btn-default">修改</a>
							<a href="javascript: void(0)" onclick="javascript: dodelete(${items.id})" class="btn btn-default">异步删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<a href="item/doupdate.action" class="btn btn-default">批量修改</a>
			<a href="item/dadelete.action" class="btn btn-default">批量删除</a>
		</form>
	</div>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>