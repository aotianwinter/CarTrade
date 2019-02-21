package com.aotian.domain;

import java.util.Date;

public class Order {
	//订单ID
	private Integer orderId;
	//订单备注
	private String orderNote;
	//创建时间
	private Date orderCreateTime;
	//最后一次修改时间
	private Date orderLastEditTime;
	//客户ID
	private Integer customerId;
	//车型编号
	private String carNo;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderNote() {
		return orderNote;
	}
	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}
	public Date getOrderCreateTime() {
		return orderCreateTime;
	}
	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}
	public Date getOrderLastEditTime() {
		return orderLastEditTime;
	}
	public void setOrderLastEditTime(Date orderLastEditTime) {
		this.orderLastEditTime = orderLastEditTime;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
	

}
