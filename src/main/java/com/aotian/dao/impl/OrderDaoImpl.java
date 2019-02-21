package com.aotian.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aotian.dao.BaseDAO;
import com.aotian.dao.OrderDao;
import com.aotian.domain.Car;
import com.aotian.domain.Order;

public class OrderDaoImpl extends BaseDAO implements OrderDao {

	public void addOrder(Order order) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.save(order);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

	}


	public void deleteOrder(Order order) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.delete(order);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

	}


	public void updateOrder(Order order) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.update(order);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

	}


	public Order selectOrder(Integer orderId) {
		Session session = getSession();
		Order order = session.get(Order.class,orderId);
		session.close();
		return order;
	}


	public List<Order> getOrder(int pageNow, int pageSize) {
		Session session = getSession();
		org.hibernate.query.Query query = session.createQuery("from Order");
		query.setFirstResult((pageNow-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Order> orders = query.list();
		session.close();
		return orders;
	}


	public int countOrder() {
		Session session = getSession();
		org.hibernate.query.Query query = session.createQuery("select count(*) from Order");
		int count = ((Long) query.iterate().next()).intValue();
		session.close();
		return count;
	}


	public List<Order> queryOrder(String keyword, String field) {
		Session session = getSession();
		String sql = "from Order where "+field+" like "+" '%"+keyword+"%' ";
		org.hibernate.query.Query query = session.createQuery(sql);
		List<Order> orders = query.list();
		session.close();
		return orders;
	}


	public int queryCustomerId(int customerId) {
		Session session = getSession();
		String sql = "select count(*) from Customer where customerId = " + customerId;
		org.hibernate.query.Query query = session.createQuery(sql);
		int count = ((Long) query.iterate().next()).intValue();
		session.close();
		return count;
	}


	public int queryCarNo(String carNo) {
		Session session = getSession();
		String sql = "select count(*) from Car where carNo = " + " '" +carNo+ "' ";
		org.hibernate.query.Query query = session.createQuery(sql);
		int count = ((Long) query.iterate().next()).intValue();
		session.close();
		return count;
	}


	public int querryCarAmount(String carNo) {
		Session session = getSession();
		String sql = "select carAmount from Car where carNo = " + " '" +carNo+ "' ";
		org.hibernate.query.Query query = session.createQuery(sql);
		List<Integer> list = query.list();
		session.close();
		return list.get(0);
	}


	
}
