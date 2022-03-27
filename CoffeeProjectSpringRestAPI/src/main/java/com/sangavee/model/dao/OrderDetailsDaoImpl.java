package com.sangavee.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sangavee.model.bean.AddOn;
import com.sangavee.model.bean.OrderDetails;

@Repository("OrderDetailsDao")
public class OrderDetailsDaoImpl implements OrderDetailsDao {

	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public OrderDetails CreateOrder(int orderId,int customerId, int voucherId) {
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		OrderDetails order=null;
		order=new OrderDetails(orderId,customerId,getCurrentDate(),voucherId);
 		int rows=(int) session.save(order);
		transaction.commit();
 		session.close();
 		return order;
	}


	@Override
	public int getMaxOrderId() {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		int orderId=0;
		Query query=session.createQuery("select Max(order_Id) from OrderDetails");
		if(query.uniqueResult()!=null) {
			orderId=(int) query.uniqueResult();
		}
		
 		transaction.commit();
 		session.close();
 		return orderId;
	}


}
