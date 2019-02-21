package com.aotian.service.impl;

import java.util.List;

import com.aotian.dao.CustomerDao;
import com.aotian.domain.Customer;
import com.aotian.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;
	
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}


	public void deleteCustomer(Integer customerId) {
		customerDao.deleteCustomer(customerDao.selectCustomer(customerId));
	}

	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);

	}


	public Customer selectCustomer(Integer customerId) {
		return customerDao.selectCustomer(customerId);
	}


	public List<Customer> getCustomer(int pageNow ,int pageSize) {
		return customerDao.getCustomer(pageNow ,pageSize);
	}


	public int countCustomer() {
		return customerDao.countCustomer();
	}


	public List<Customer> queryCustomer(String keyword, String field) {
		return customerDao.queryCustomer(keyword, field);
	}	

}
