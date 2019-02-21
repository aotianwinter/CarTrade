package com.aotian.service;

import java.util.List;
import java.util.Map;

import com.aotian.domain.Car;
import com.aotian.domain.Order;
import com.aotian.domain.Result;

public interface OrderService {
	// 保存订单信息
	public void addOrder(Order order);
	// 删除订单信息
	public void deleteOrder(int orderId);
	// 修改订单信息
	public void updateOrder(Order order);
	// 查询订单信息
	public Order selectOrder(int orderId);
	// 获取订单信息
	public List<Order> getOrder(int pageNow,int pageSize);
	// 获取所有订单总数
	public int countOrder();
	// 模糊查询
	public List<Order> queryOrder(String keyword,String field);
	
	// 查询客户ID是否存在
	public boolean queryCustomerId(int customerId);
	// 查询产品编号是否存在
	public boolean queryCarNo(String carNo);
	// 查询产品数量
	public int querryCarAmount(String carNo);
	
	// 减少产品数量
	public void reduce_CarCount(String carNo);
	// 显示详细信息
	public Result details_Order(int orderId);
}
