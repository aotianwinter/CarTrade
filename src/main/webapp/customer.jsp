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
			<h2>查询</h2>
			<hr />
			
			<s:form action="customer_query" method="post" namespace="/" theme="simple">
			<table id="table_customer_query" cellpadding="5" cellspacing="0" border="0">
				<tr>
					<td>
						<input name="keyword" type="text" placeholder="请输入关键词" required="required"/>
						<select name="field" required="required">
							<option  value="" style="color: #b6b6b6" disabled selected>
								查询类型</option>
							<option value="customerId">ID</option>
							<option value="customerName">姓名</option>
							<option value="customerTel">电话</option>
							<option value="customerAdress">住址</option>
						</select>
						<input type="submit" value="查询" />
					</td>
				</tr>
			</table>
			</s:form>

			<h2>客户信息</h2>
			<hr />
			<table id="table_customer_all" cellpadding="10" cellspacing="0"
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
					<s:iterator value="#request.customers">
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
			
			<div id="customer_pager">
			<s:set name="pager" value="#request.customer_pager"></s:set>
			
			<s:if test="#pager.hasFirst">
				<a href="customer_list?pager.pageNow=1">首页</a>
			</s:if>
			<s:if test="#pager.hasPre">
				<a href="customer_list?pager.pageNow=<s:property value="#pager.pageNow-1"/>">上一页</a>
			</s:if>
			<s:if test="#pager.hasNext">
				<a href="customer_list?pager.pageNow=<s:property value="#pager.pageNow+1"/>">下一页</a>
			</s:if>
			<s:if test="#pager.hasLast">
				<a href="customer_list?pager.pageNow=<s:property value="#pager.totalPage"/>">尾页</a>
			</s:if>
			
			第<s:property value="#pager.pageNow"/>页
			共<s:property value="#pager.totalPage"/>页
			</div>

			<h2>添加产品</h2>
			<hr />
			<s:form action="customer_save" method="post" namespace="/" theme="simple">
				<table id="table_customer_add" cellpadding="5" cellspacing="0"
					border="0">
					<tr>
						<td>姓名</td>
						<td><input type="text" name="customerName" required="required"/></td>
					</tr>
					<tr>
						<td>年龄</td>
						<td><input type="number" name="customerAge" required="required"/></td>
					</tr>
					<tr>
						<td>性别</td>
						<td>
							男：<input type="radio" checked="checked" name="customerSex" value="男" />
							女：<input type="radio" name="customerSex" value="女" />
						</td>
					</tr>
					<tr>
						<td>电话</td>
						<td><input type="number" name="customerTel" required="required"/></td>
					</tr>
					<tr>
						<td>住址</td>
						<td><input type="text" name="customerAdress" required="required"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="添加" /> 
						<input type="reset" value="重置" /></td>
					</tr>
				</table>
			</s:form>

		</div>
	</div>
</body>
</html>
