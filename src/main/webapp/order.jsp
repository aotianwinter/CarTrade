<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单中心</title>
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
	var customerId_query = document.getElementById('customerId_query');
	var carNo_query = document.getElementById('carNo_query');
	var result_one = document.getElementById('result_one');
	var result_two = document.getElementById('result_two');
	var order_submit = document.getElementById('order_submit');
	

	$(one).css("background","rgb(34,80,129)");
	
	var one;
	var two;
	var amount;
	
	$(customerId_query).change(function(){
		$.ajax({
			type:"POST",
			url:"order_queryCustomerId",
			data:{
				"customerId":$(customerId_query).val()
			},
			dataType:"json",
			success:function(data){
				one = data['result'];
				if(one == "Yes"){
					$(result_one).html("有效客户ID");
					$(result_one).css({color:"green"});
				}
				else{
					$(result_one).html("无效客户ID");
					$(result_one).css({color:"red"});
				}
			},
			error:function(){
				alert("系统错误");
			},
			
		});
	});
	
	$(carNo_query).change(function(){
		$.ajax({
			type:"POST",
			url:"order_queryCarNo",
			data:{
				"carNo":$(carNo_query).val()
			},
			dataType:"json",
			success:function(data){
				two = data['result'];
				amount = data['amount'];
				if(two == "Yes"){
					$(result_two).html("有效产品编号	"+"数量："+amount);
					$(result_two).css({color:"green"});
				}
				else{
					$(result_two).html("无效产品编号");
					$(result_two).css({color:"red"});
				}
			},
			error:function(){
				alert("系统错误");
			},
			
		});
	});
	
	$(order_submit).click(function(check){
		if(two == "No"){
			$(carNo_query).focus();
			check.preventDefault();	//此处阻止提交表单
		}
		if(one == "No"){
			$(customerId_query).focus();
			check.preventDefault();	//此处阻止提交表单
		}
		if(amount == "0"){
			alert("数量为0，无法添加！");
			$(carNo_query).focus();
			check.preventDefault();	//此处阻止提交表单
		}
                 
        //$(customerId_query).focus();
    });  
	
});
</script>

<body>
	<jsp:include page="head.jsp"/>

	<div id="body">
		<jsp:include page="menu.jsp"/>

		<div id="body-right">
			<h2>查询</h2>
			<hr />
			
			<s:form action="order_query" method="post" namespace="/" theme="simple">
			<table id="table_order_query" cellpadding="5" cellspacing="0" border="0">
				<tr>
					<td>
						<input name="keyword" type="text" placeholder="请输入关键词" required="required"/>
						<select name="field" required="required">
							<option  value="" style="color: #b6b6b6" disabled selected>
								查询类型</option>
							<option value="orderId">订单号</option>
							<option value="customerId">客户ID</option>
							<option value="carNo">产品编号</option>
							<option value="orderCreateTime">订单时间</option>
						</select>
						<input type="submit" value="查询" />
					</td>
				</tr>
			</table>
			</s:form>
			

			<h2>订单信息</h2>
			<hr />
			<table id="table_order_all" cellpadding="10" cellspacing="0"
				border="1">
				<thead>
					<tr>
						<td>订单号</td>
						<td>备注</td>
						<td>客户ID</td>
						<td>产品编号</td>
						<td>创建时间</td>
						<td>修改时间</td>
						<td>详情</td>
						<td>修改</td>
						<td>删除</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.orders">
						<tr>
							<td>${orderId }</td>
							<td>${orderNote }</td>
							<td>${customerId }</td>
							<td>${carNo }</td>
							<td>${orderCreateTime }</td>
							<td>${orderLastEditTime }</td>
							<td><a href="order_details?orderId=${orderId}">详情</a></td>
							<td><a href="order_edit?orderId=${orderId}">修改</a></td>
							<td><a href="order_delete?orderId=${orderId}"
							onClick="if(!confirm('确定删除该信息？'))return false;else return true">删除</a></td>
						</tr>
					</s:iterator>
					
				</tbody>
			</table>
			
			<div id="order_pager">
			<s:set name="pager" value="#request.order_pager"></s:set>
			
			<s:if test="#pager.hasFirst">
				<a href="order_list?pager.pageNow=1">首页</a>
			</s:if>
			<s:if test="#pager.hasPre">
				<a href="order_list?pager.pageNow=<s:property value="#pager.pageNow-1"/>">上一页</a>
			</s:if>
			<s:if test="#pager.hasNext">
				<a href="order_list?pager.pageNow=<s:property value="#pager.pageNow+1"/>">下一页</a>
			</s:if>
			<s:if test="#pager.hasLast">
				<a href="order_list?pager.pageNow=<s:property value="#pager.totalPage"/>">尾页</a>
			</s:if>
			
			第<s:property value="#pager.pageNow"/>页
			共<s:property value="#pager.totalPage"/>页
			
			</div>
			
			<h2>添加订单</h2>
			<hr />
			<s:form action="order_save" method="post" namespace="/" theme="simple">
				<table id="table_order_add" cellpadding="5" cellspacing="0"
					border="0">
					<tr>
						<td>客户ID</td>
						<td>
							<input type="number" id="customerId_query" 
							name="customerId" required="required" />
						</td>
						<td>
							<span id="result_one"></span>
						</td>
					</tr>
					<tr>
						<td>产品编号</td>
						<td>
							<input type="text" name="carNo" id="carNo_query"
							required="required"/>
						</td>
						<td>
							<span id="result_two"></span>
						</td>
					</tr>
					<tr>
						<td>备注</td>
						<td><input type="text" name="orderNote" /></td>
					</tr>
					<tr>
						<td>
							<input id="order_submit" type="submit" value="添加" />
							<input type="reset"	 value="重置" />
						</td>
					</tr>
				</table>
			</s:form>

		</div>
	</div>
</body>
</html>
