package com.aotian.service;

import java.util.List;

import com.aotian.domain.Customer;

public interface CustomerService {
	// 保存客户信息
	public void addCustomer(Customer customer);
	// 删除客户信息
	public void deleteCustomer(Integer customerId);
	// 修改客户信息
	public void updateCustomer(Customer customer);
	// 查询客户信息
	public Customer selectCustomer(Integer customerId);
	// 获取所有客户信息
	public List<Customer> getCustomer(int pageNow,int pageSize);
	// 获取所有客戶总数
	public int countCustomer();
	// 模糊查询
	public List<Customer> queryCustomer(String keyword,String field);
	
}
