<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户修改</title>
<link href="assets/css/top.css" rel="stylesheet" />
<link href="assets/css/body.css" rel="stylesheet" />
<link href="assets/css/contain.css" rel="stylesheet" />
</head>
<script src="assets/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	// 自身要写的jQuery代码
	"use strict";

	var select = document.getElementById('male');
	var female = document.getElementById('female');
	var title = $(select).attr("title");

	var three = document.getElementById('customer_manage');
	$(three).css("background","rgb(34,80,129)");
	
	switch (title) {
	case "女":
		$(female).attr("checked",true);
		break;
	}
	
});
</script>
<body>
	<jsp:include page="head.jsp"/>

	<div id="body">
		<jsp:include page="menu.jsp"/>

		<div id="body-right">
			<h2>修改客户</h2>
			<hr />
			<s:form action="customer_update" method="post" namespace="/"
				theme="simple">
				<table id="table_customer_edit" cellpadding="5" cellspacing="0"
					border="0">
					<tr>
						<td><input type="hidden" name="customerId"
							value="${request.customer.customerId}" /></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="customerName"
							value="${request.customer.customerName}" required="required"/></td>
					</tr>
					<tr>
						<td>年龄</td>
						<td><input type="number" name="customerAge"
							value="${request.customer.customerAge}" required="required"/></td>
					</tr>
					<tr>
						<td>性别</td>
						<td>
							男：<input id="male" type="radio" checked="checked"
							title="${request.customer.customerSex}" name="customerSex" value="男" />
							女：<input id="female" type="radio" name="customerSex" value="女" />
						</td>
					</tr>
					<tr>
						<td>电话</td>
						<td><input type="number" name="customerTel"
							value="${request.customer.customerTel}" required="required"/></td>
					</tr>
					<tr>
						<td>住址</td>
						<td><input type="text" name="customerAdress"
							value="${request.customer.customerAdress}" required="required"/></td>
					</tr>
					<tr>
						<td><input type="hidden" name="customerCreateTime"
							value="${request.customer.customerCreateTime}" /></td>
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