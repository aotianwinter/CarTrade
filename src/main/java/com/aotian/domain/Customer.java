package com.aotian.domain;
import java.util.Date;
import java.util.Set;

public class Customer {
	//ID
	private Integer customerId;
	private String customerName;
	private Integer customerAge;
	//性别
	private String customerSex;
	//电话
	private String customerTel;
	//地址
	private String customerAdress;
	//创建时间
	private Date customerCreateTime;
	//最后一次修改时间
	private Date customerLastEditTime;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerSex() {
		return customerSex;
	}
	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerAdress() {
		return customerAdress;
	}
	public void setCustomerAdress(String customerAdress) {
		this.customerAdress = customerAdress;
	}
	public Date getCustomerCreateTime() {
		return customerCreateTime;
	}
	public void setCustomerCreateTime(Date customerCreateTime) {
		this.customerCreateTime = customerCreateTime;
	}
	public Date getCustomerLastEditTime() {
		return customerLastEditTime;
	}
	public void setCustomerLastEditTime(Date customerLastEditTime) {
		this.customerLastEditTime = customerLastEditTime;
	}
	
	

}
