<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单修改</title>
<link href="assets/css/top.css" rel="stylesheet" />
<link href="assets/css/body.css" rel="stylesheet" />
<link href="assets/css/contain.css" rel="stylesheet" />
</head>
<script src="assets/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	// 自身要写的jQuery代码
	"use strict";
	var one = document.getElementById('order_center');
	$(one).css("background","rgb(34,80,129)");
	
});
</script>
<body>
	<jsp:include page="head.jsp"/>

	<div id="body">
		<jsp:include page="menu.jsp"/>

		<div id="body-right">
			<h2>修改产品</h2>
			<hr />
			<s:form action="order_update" method="post" namespace="/"
				theme="simple">
				<table id="table_order_edit" cellpadding="5" cellspacing="0"
					border="0">
					<tr>
						<td><input type="hidden" name="orderId"
							value="${request.order.orderId}" /></td>
					</tr>
					<tr>
						<td>客户ID</td>
						<td><input type="number" name="customerId"
							value="${request.order.customerId}" required="required" /></td>
					</tr>
					<tr>
						<td>产品编号</td>
						<td><input type="text" name="carNo"
							value="${request.order.carNo}" required="required" /></td>
					</tr>
					<tr>
						<td>备注</td>
						<td><input type="text" name="orderNote"
							value="${request.order.orderNote}" /></td>
					</tr>
					<tr>
						<td><input type="hidden" name="orderCreateTime"
							value="${request.order.orderCreateTime}" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="修改" /></td>
					</tr>
				</table>
			</s:form>

		</div>
	</div>

</body>
</html>