<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<title>添加</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/> -->
</head>
<body>
	<c:out value="${basePath}"></c:out>
	<div class="container">
	<form action="${basePath}item/demo04.action"  method="post">
		
		<table>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>上传图片</td>
				<td><input type="text" name="pic" />
					
				</td>
			</tr>
			<tr>
				<td>详细信息</td>
				<td><input type="text" name="detail" /></td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td><input type="text" name="createtime" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="确认添加">
				</td>
			</tr>
		</table>
	</form>
	</div>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>