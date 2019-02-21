package com.aotian.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aotian.dao.BaseDAO;
import com.aotian.dao.CustomerDao;
import com.aotian.domain.Car;
import com.aotian.domain.Customer;

public class CustomerDaoImpl extends BaseDAO implements CustomerDao {

	public void addCustomer(Customer customer) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.save(customer);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void deleteCustomer(Customer customer) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.delete(customer);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

	public void updateCustomer(Customer customer) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.update(customer);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

	public Customer selectCustomer(Integer customerId) {
		Session session = getSession();
		Customer customer = session.get(Customer.class,customerId);
		session.close();
		return customer;
	}

	public List<Customer> getCustomer(int pageNow,int pageSize) {
		Session session = getSession();
		org.hibernate.query.Query query = session.createQuery("from Customer");
		query.setFirstResult((pageNow-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Customer> customers = query.list();
		session.close();
		return customers;
	}


	public int countCustomer() {
		Session session = getSession();
		org.hibernate.query.Query query = session.createQuery("select count(*) from Customer");
		int count = ((Long) query.iterate().next()).intValue();
		session.close();
		return count;
	}


	public List<Customer> queryCustomer(String keyword, String field) {
		Session session = getSession();
		String sql = "from Customer where "+field+" like "+" '%"+keyword+"%' ";
		org.hibernate.query.Query query = session.createQuery(sql);
		List<Customer> customers = query.list();
		session.close();
		return customers;
	}

}
