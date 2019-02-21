package com.aotian.domain;

import java.util.Date;

public class Car {
	//ID 主键
	private Integer carId;
	//编号
	private String carNo;
	//名称
	private String carName;
	//类型
	private String carModel;
	//价格
	private Integer carPrice;
	//产地
	private String carAdress;
	//产地
	private Integer carAmount;
	//生产时间
	private Date carCreateTime;
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public Integer getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(Integer carPrice) {
		this.carPrice = carPrice;
	}
	public String getCarAdress() {
		return carAdress;
	}
	public void setCarAdress(String carAdress) {
		this.carAdress = carAdress;
	}
	public Integer getCarAmount() {
		return carAmount;
	}
	public void setCarAmount(Integer carAmount) {
		this.carAmount = carAmount;
	}
	public Date getCarCreateTime() {
		return carCreateTime;
	}
	public void setCarCreateTime(Date carCreateTime) {
		this.carCreateTime = carCreateTime;
	}
	
	
	
	
}
