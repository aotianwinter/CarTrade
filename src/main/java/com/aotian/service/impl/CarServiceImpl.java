package com.aotian.service.impl;

import java.util.List;

import com.aotian.dao.CarDao;
import com.aotian.domain.Car;
import com.aotian.service.CarService;

public class CarServiceImpl implements CarService {
	private CarDao carDao;
	
	public CarDao getCarDao() {
		return carDao;
	}

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}


	public void addCar(Car car) {
		carDao.addCar(car);

	}
	

	public List<Car> getCar(int pageNow ,int pageSize) {
		return carDao.getCar(pageNow,pageSize);
	}


	public void deleteCar(Integer carId) {
		carDao.deleteCar(carDao.selectCar(carId));

	}


	public void updateCar(Car car) {
		carDao.updateCar(car);
	}


	public Car selectCar(Integer carId) {
		return carDao.selectCar(carId);
	}


	public int countCar() {
		return carDao.countCar();
	}


	public List<Car> queryCar(String keyword, String field) {
		return carDao.queryCar(keyword, field);
	}

	
}
