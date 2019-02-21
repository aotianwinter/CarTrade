<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品修改</title>
<link href="assets/css/top.css" rel="stylesheet" />
<link href="assets/css/body.css" rel="stylesheet" />
<link href="assets/css/contain.css" rel="stylesheet" />
</head>
<script src="assets/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	// 自身要写的jQuery代码
	"use strict";

	var select = document.getElementsByTagName('select');
	var title = $(select).attr("title");
	
	var two = document.getElementById('product_inf');
	$(two).css("background","rgb(34,80,129)");

	switch (title) {
	case "Tesla Model S":
		$(select).val("Tesla Model S");
		break;
	case "Tesla Model X":
		$(select).val("Tesla Model X");
		break;
	case "Tesla Model 3":
		$(select).val("Tesla Model 3");
		break;
	case "Tesla RoadSter":
		$(select).val("Tesla RoadSter");
		break;
	}
	
});
</script>
<body>
	<jsp:include page="head.jsp"/>

	<div id="body">
		<jsp:include page="menu.jsp"/>

		<div id="body-right">
			<h2>修改产品</h2>
			<hr />
			<s:form action="car_update" method="post" namespace="/"
				theme="simple">
				<table id="table_good_edit" cellpadding="5" cellspacing="0"
					border="0">
					<tr>
						<td><input type="hidden" name="carId"
							value="${request.car.carId}" /></td>
					</tr>
					<tr>
						<td>编号</td>
						<td><input type="text" name="carNo"
							value="${request.car.carNo}" required="required" /></td>
					</tr>
					<tr>
						<td>名称</td>
						<td><input type="text" name="carName"
							value="${request.car.carName}" required="required" /></td>
					</tr>
					<tr>
						<td>类型</td>
						<td><select name="carModel" title="${request.car.carModel}">
								<option value="Tesla Model S">Tesla Model S</option>
								<option value="Tesla Model X">Tesla Model X</option>
								<option value="Tesla Model 3">Tesla Model 3</option>
								<option value="Tesla RoadSter">Tesla RoadSter</option>
						</select></td>
					</tr>
					<tr>
						<td>价格</td>
						<td><input type="number" name="carPrice"
							value="${request.car.carPrice}" required="required"/></td>
					</tr>
					<tr>
						<td>产地</td>
						<td><input type="text" name="carAdress"
							value="${request.car.carAdress}" required="required"/></td>
					</tr>
					<tr>
						<td>数量</td>
						<td><input type="number" name="carAmount"
							value="${request.car.carAmount}" required="required"/></td>
					</tr>
					<tr>
						<td>生产时间</td>
						<td><input type="text" name="carCreateTime"
							value="${request.car.carCreateTime}" required="required"/></td>
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