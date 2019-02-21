package com.aotian.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ls.LSInput;

import com.aotian.domain.Customer;
import com.aotian.domain.Order;
import com.aotian.domain.Result;
import com.aotian.service.CarService;
import com.aotian.service.OrderService;
import com.aotian.tools.Pager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import netscape.javascript.JSObject;


public class OrderAction extends ActionSupport implements ModelDriven<Order>,RequestAware{
	private Order order = new Order();
	
	public Order getModel() {
		return order;
	}

	private String keyword;
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	private String field;
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	
	private Pager pager;

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	private OrderService orderService;
	
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	public String save() {
		Date day = new Date();
		order.setOrderCreateTime(day);
		orderService.addOrder(order);
		orderService.reduce_CarCount(order.getCarNo());
		return SUCCESS;
	}
	
	public String list() {
		pager.setTotalSize(orderService.countOrder());
		pager.setTotalPage(pager.getTotalPage());
		request.put("order_pager", pager);
		request.put("orders", orderService.getOrder(pager.getPageNow(),pager.getPageSize()));
		return "list";
	}
	
	public String update() {
		Date day = new Date();
		order.setOrderLastEditTime(day);
		orderService.updateOrder(order);
		return SUCCESS;
	}
	
	public String edit() {
		order = orderService.selectOrder(order.getOrderId());
		request.put("order",order);
		return "edit";
	}
	
	public String delete() {
		orderService.deleteOrder(order.getOrderId());
		return SUCCESS;
	}
	
	public String query() {
		request.put("order_query", orderService.queryOrder(keyword, field));
		return "query";
	}
	
	private Map<String, String> data;
	
	public Map<String,String> getData() {
		return data;
	}

	public void setData(Map<String,String> data) {
		this.data = data;
	}
	
	public String queryCustomerId() {
		data = new HashMap<String,String>();
		
		if(orderService.queryCustomerId(order.getCustomerId()))
			data.put("result", "Yes");
		else
			data.put("result", "No");
		
		return "result";
	}
	
	public String queryCarNo() {
		data = new HashMap<String,String>();
		
		if(orderService.queryCarNo(order.getCarNo())) {
			data.put("result", "Yes");
			int amount = orderService.querryCarAmount(order.getCarNo());
			data.put("amount", String.valueOf(amount));
		}
		else
			data.put("result", "No");
		
		return "result";
	}
	
	public String details() {
		Result result = orderService.details_Order(order.getOrderId());
		request.put("order", result.getOrder());
		request.put("customer", result.getCustomer());
		request.put("car", result.getCar());
		return "details";
	}
	

	private Map<String, Object> request;
	
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
		
	}



	

}
