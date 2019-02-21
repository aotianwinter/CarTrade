package com.aotian.dao;

import java.util.List;

import com.aotian.domain.Car;
import com.aotian.domain.Order;

public interface OrderDao {
	// 保存订单信息
	public void addOrder(Order order);
	// 删除订单信息
	public void deleteOrder(Order order);
	// 修改订单信息
	public void updateOrder(Order order);
	// 查询订单信息
	public Order selectOrder(Integer orderId);
	// 获取分页订单信息
	public List<Order> getOrder(int pageNow,int pageSize);
	// 获取所有订单总数
	public int countOrder();
	// 模糊查询
	public List<Order> queryOrder(String keyword,String field);
	// 查询客户ID是否存在
	public int queryCustomerId(int customerId);
	// 查询产品编号是否存在
	public int queryCarNo(String carNo);
	// 查询产品数量
	public int querryCarAmount(String carNo);
	
}
