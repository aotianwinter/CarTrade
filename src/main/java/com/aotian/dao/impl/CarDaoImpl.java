package com.aotian.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.LikeExpression;

import com.aotian.dao.BaseDAO;
import com.aotian.dao.CarDao;
import com.aotian.domain.Car;

public class CarDaoImpl extends BaseDAO implements CarDao {
	public void addCar(Car car) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.save(car);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public List<Car> getCar(int pageNow,int pageSize){
		Session session = getSession();
		org.hibernate.query.Query query = session.createQuery("from Car");
		query.setFirstResult((pageNow-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Car> cars = query.list();
		session.close();
		return cars;
	}
	
	public void deleteCar(Car car) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.delete(car);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

	public void updateCar(Car car) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.update(car);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

	public Car selectCar(Integer carId) {
		Session session = getSession();
		Car car = session.get(Car.class,carId);
		session.close();
		return car;
	}

	public int countCar() {
		Session session = getSession();
		org.hibernate.query.Query query = session.createQuery("select count(*) from Car");
		int count = ((Long) query.iterate().next()).intValue();
		session.close();
		return count;
	}

	public List<Car> queryCar(String keyword, String field) {
		Session session = getSession();
		String sql = "from Car where "+field+" like "+" '%"+keyword+"%' ";
		org.hibernate.query.Query query = session.createQuery(sql);
		List<Car> cars = query.list();
		session.close();
		return cars;
	}

	public Car selectCar_byNo(String carNo) {
		Session session = getSession();
		String sql = "from Car where carNo = " + " '" +carNo+ "' ";
		org.hibernate.query.Query query = session.createQuery(sql);
		Car car = new Car();
		car = (Car) query.list().get(0);
		session.close();
		return car;
	}

}
