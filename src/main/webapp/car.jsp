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
			<h2>查询</h2>
			<hr />
			
			<s:form action="car_query" method="post" namespace="/" theme="simple">
			<table id="table_good_query" cellpadding="5" cellspacing="0" border="0">
				<tr>
					<td>
						<input name="keyword" type="text" placeholder="请输入关键词" required="required"/>
						<select name="field" required="required">
							<option  value="" style="color: #b6b6b6" disabled selected>
								查询类型</option>
							<option value="carNo">编号</option>
							<option value="carName">名称</option>
							<option value="carModel">类型</option>
							<option value="carPrice">价格</option>
							<option value="carAdress">产地</option>
						</select>
						<input type="submit" value="查询" />
					</td>
				</tr>
			</table>
			</s:form>
			

			<h2>产品信息</h2>
			<hr />
			<table id="table_good_all" cellpadding="10" cellspacing="0"
				border="1">
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
					<s:iterator value="#request.cars">
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
			
			<div id="car_pager">
			<s:set name="pager" value="#request.car_pager"></s:set>
			
			<s:if test="#pager.hasFirst">
				<a href="car_list?pager.pageNow=1">首页</a>
			</s:if>
			<s:if test="#pager.hasPre">
				<a href="car_list?pager.pageNow=<s:property value="#pager.pageNow-1"/>">上一页</a>
			</s:if>
			<s:if test="#pager.hasNext">
				<a href="car_list?pager.pageNow=<s:property value="#pager.pageNow+1"/>">下一页</a>
			</s:if>
			<s:if test="#pager.hasLast">
				<a href="car_list?pager.pageNow=<s:property value="#pager.totalPage"/>">尾页</a>
			</s:if>
			
			第<s:property value="#pager.pageNow"/>页
			共<s:property value="#pager.totalPage"/>页
			
			</div>
			
			<h2>添加产品</h2>
			<hr />
			<s:form action="car_save" method="post" namespace="/" theme="simple">
				<table id="table_good_add" cellpadding="5" cellspacing="0"
					border="0">
					<tr>
						<td>编号</td>
						<td>
							<input type="text" name="carNo" required="required"/>
						</td>
					</tr>
					<tr>
						<td>名称</td>
						<td><input type="text" name="carName" required="required"/></td>
					</tr>
					<tr>
						<td>类型</td>
						<td><select name="carModel" required="required">
								<option value="" style="color: #b6b6b6" 
								disabled selected >请选择型号</option>
								<option >Tesla Model S</option>
								<option >Tesla Model X</option>
								<option >Tesla Model 3</option>
								<option >Tesla RoadSter</option>
						</select></td>
					</tr>
					<tr>
						<td>价格</td>
						<td><input type="number" name="carPrice" required="required" /></td>
					</tr>
					<tr>
						<td>产地</td>
						<td><input type="text" name="carAdress" required="required"/></td>
					</tr>
					<tr>
						<td>数量</td>
						<td><input type="number" name="carAmount" required="required"/></td>
					</tr>
					<tr>
						<td>生产时间</td>
						<td><input type="date" name="carCreateTime" required="required"/></td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="添加" />
							<input type="reset"	 value="重置" />
						</td>
					</tr>
				</table>
			</s:form>

		</div>
	</div>
</body>
</html>
