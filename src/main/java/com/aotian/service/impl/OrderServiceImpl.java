package com.aotian.service.impl;

import java.util.List;
import java.util.Map;

import com.aotian.dao.CarDao;
import com.aotian.dao.CustomerDao;
import com.aotian.dao.OrderDao;
import com.aotian.domain.Car;
import com.aotian.domain.Customer;
import com.aotian.domain.Order;
import com.aotian.domain.Result;
import com.aotian.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;
	private CarDao carDao;
	private CustomerDao customerDao;
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public void addOrder(Order order) {
		orderDao.addOrder(order);
	}


	public void deleteOrder(int orderId) {
		orderDao.deleteOrder(orderDao.selectOrder(orderId));

	}


	public void updateOrder(Order order) {
		orderDao.updateOrder(order);

	}

	public Order selectOrder(int orderId) {
		return orderDao.selectOrder(orderId);
	}


	public List<Order> getOrder(int pageNow, int pageSize) {
		return orderDao.getOrder(pageNow, pageSize);
	}


	public int countOrder() {
		return orderDao.countOrder();
	}


	public List<Order> queryOrder(String keyword, String field) {
		return orderDao.queryOrder(keyword, field);
	}

	public boolean queryCustomerId(int customerId) {
		if(orderDao.queryCustomerId(customerId) == 0)
			return false;
		else 
			return true;
	}

	public boolean queryCarNo(String carNo) {
		if(orderDao.queryCarNo(carNo) == 0)
			return false;
		else 
			return true;
	}

	public int querryCarAmount(String carNo) {
		return orderDao.querryCarAmount(carNo);
	}

	public void reduce_CarCount(String carNo) {
		Car car = new Car();
		car = carDao.selectCar_byNo(carNo);
		car.setCarAmount(car.getCarAmount() - 1);
		carDao.updateCar(car);
	}

	public Result details_Order(int orderId) {
		Result result = new Result();
		Order order = orderDao.selectOrder(orderId);
		
		result.setOrder(order);
		result.setCustomer(customerDao.selectCustomer(order.getCustomerId()));
		result.setCar(carDao.selectCar_byNo(order.getCarNo()));
		
		return result;
	}


}
