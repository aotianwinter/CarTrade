<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品信息</title>
<link href="assets/css/top.css" rel="stylesheet" />
<link href="assets/css/body.css" rel="stylesheet" />
<link href="assets/css/contain.css" rel="stylesheet" />
</head>
<script src="assets/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	// 自身要写的jQuery代码
	"use strict";
	var two = document.getElementById('product_inf');
	$(two).css("background","rgb(34,80,129)");
	
});
</script>
<body>
	<jsp:include page="head.jsp"/>

	<div id="body">
		<jsp:include page="menu.jsp"/>

		<div id="body-right">
			<h2>查询结果</h2>
			<hr />
			
				<table id="table_good_query" cellpadding="10" cellspacing="0" border="1">
				<thead>
					<tr>
						<td>编号</td>
						<td>名称</td>
						<td>类型</td>
						<td>价格</td>
						<td>产地</td>
						<td>数量</td>
						<td>生产时间</td>
						<td>修改</td>
						<td>删除</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.car_query">
						<tr>
							<td>${carNo }</td>
							<td>${carName }</td>
							<td>${carModel }</td>
							<td>${carPrice }</td>
							<td>${carAdress }</td>
							<td>${carAmount }</td>
							<td>${carCreateTime }</td>
							<td><a href="car_edit?carId=${carId}">修改</a></td>
							<td><a href="car_delete?carId=${carId}"
							onClick="if(!confirm('确定删除该信息？'))return false;else return true">删除</a></td>
						</tr>
					</s:iterator>
					
				</tbody>
			</table>

		</div>
	</div>

</body>
</html>