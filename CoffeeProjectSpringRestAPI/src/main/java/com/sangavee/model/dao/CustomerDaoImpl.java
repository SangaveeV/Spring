package com.sangavee.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sangavee.model.bean.Coffee;
import com.sangavee.model.bean.Customer;

@Repository("CustomerDao")
public class CustomerDaoImpl implements CustomerDao {

private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Customer addCustomer(int customerId, String customerName, long phoneNumber) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Customer customer=null;
		customer=new Customer(customerId,customerName,phoneNumber);
		session.save(customer);
 		transaction.commit();
 		session.close();
 		return customer;

	}

	@Override
	public Customer getCustomerbyPhone(long phone) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Object customer=null;
		Query query=session.createQuery("from Customer where phone="+phone);
		if(query.uniqueResult()!=null) {
			customer=query.uniqueResult();
		}
 		transaction.commit();
 		session.close();
 		return (Customer) customer;
	}

	@Override
	public int getMaxCustomerId() {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("select Max(customer_Id) from Customer");
		int custId=(int) query.getSingleResult();
 		transaction.commit();
 		session.close();
 		return custId;
	}



}
