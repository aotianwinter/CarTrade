package com.aotian.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.aotian.domain.Car;
import com.aotian.service.CarService;
import com.aotian.tools.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class CarAction extends ActionSupport implements ModelDriven<Car>,RequestAware{
	private Car car = new Car();
	
	public Car getModel() {
		return car;
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

	private CarService carService;
	
	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	public String save() {
		carService.addCar(car);
		return SUCCESS;
	}
	
	public String list() {
		pager.setTotalSize(carService.countCar());
		pager.setTotalPage(pager.getTotalPage());
		request.put("car_pager", pager);
		request.put("cars", carService.getCar(pager.getPageNow(),pager.getPageSize()));
		return "list";
	}
	
	public String update() {
		carService.updateCar(car);
		return SUCCESS;
	}
	
	public String edit() {
		car = carService.selectCar(car.getCarId());
		request.put("car",	car);
		return "edit";
	}
	
	public String delete() {
		carService.deleteCar(car.getCarId());
		return SUCCESS;
	}
	
	public String query() {
		request.put("car_query", carService.queryCar(keyword,field));
		return "query";
	}

	private Map<String, Object> request;
	
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
		
	}

}
