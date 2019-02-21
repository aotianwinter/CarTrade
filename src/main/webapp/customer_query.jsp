<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户管理</title>
<link href="assets/css/top.css" rel="stylesheet" />
<link href="assets/css/body.css" rel="stylesheet" />
<link href="assets/css/contain.css" rel="stylesheet" />
</head>
<script src="assets/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	// 自身要写的jQuery代码
	"use strict";
	var three = document.getElementById('customer_manage');
	$(three).css("background","rgb(34,80,129)");
	
});
</script>
<body>
	<jsp:include page="head.jsp"/>

	<div id="body">
		<jsp:include page="menu.jsp"/>

		<div id="body-right">
			<h2>查询结果</h2>
			<hr />
			
				<table id="table_customer_query" cellpadding="10" cellspacing="0"
				border="1">
				<thead>
					<tr>
						<td>ID</td>
						<td>姓名</td>
						<td>年龄</td>
						<td>性别</td>
						<td>电话</td>
						<td>住址</td>
						<td>创建时间</td>
						<td>修改时间</td>
						<td>修改</td>
						<td>删除</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.customer_query">
						<tr>
							<td>${customerId }</td>
							<td>${customerName }</td>
							<td>${customerAge }</td>
							<td>${customerSex }</td>
							<td>${customerTel }</td>
							<td>${customerAdress }</td>
							<td>${customerCreateTime }</td>
							<td>${customerLastEditTime }</td>
							<td><a href="customer_edit?customerId=${customerId}">修改</a></td>
							<td><a href="customer_delete?customerId=${customerId}"
							onClick="if(!confirm('确定删除该信息？'))return false;else return true">删除</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>

		</div>
	</div>

</body>
</html>