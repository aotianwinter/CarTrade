package com.aotian.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.aotian.domain.Customer;
import com.aotian.service.CustomerService;
import com.aotian.tools.Pager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>, RequestAware {

	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
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

	private CustomerService customerService;
	
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public String save() {
		Date day = new Date();     
		customer.setCustomerCreateTime(day);
		customerService.addCustomer(customer);
		return SUCCESS;
	}
	
	public String list() {
		pager.setTotalSize(customerService.countCustomer());
		pager.setTotalPage(pager.getTotalPage());
		request.put("customer_pager", pager);
		request.put("customers", customerService.getCustomer(pager.getPageNow(),pager.getPageSize()));
		return "list";
	}
	
	public String update() {
		Date day = new Date();     
		customer.setCustomerLastEditTime(day);
		customerService.updateCustomer(customer);
		return SUCCESS;
	}
	
	public String edit() {
		customer = customerService.selectCustomer(customer.getCustomerId());
		request.put("customer",	customer);
		return "edit";
	}
	
	public String delete() {
		customerService.deleteCustomer(customer.getCustomerId());
		return SUCCESS;
	}
	
	public String query() {
		request.put("customer_query", customerService.queryCustomer(keyword,field));
		return "query";
	}

	private Map<String, Object> request;
	
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;

	}

	
}
