package com.sangavee.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManagerFactory;

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

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public int CreateOrder(int orderId,int customerId, String orderDate, int voucherId) {
		SessionFactory sessionFactory=entityManagerFactory.unwrap(SessionFactory.class);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		OrderDetails order=new OrderDetails(orderId,customerId,getCurrentDate(),voucherId);
 		int rows=(int) session.save(order);
		transaction.commit();
 		session.close();
 		return rows;
	}


	@Override
	public int getMaxOrderId() {
		SessionFactory sessionFactory=entityManagerFactory.unwrap(SessionFactory.class);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("select Max(order_Id) from OrderDetails");
		int orderId=(int) query.uniqueResult();
 		transaction.commit();
 		session.close();
 		return orderId;
	}


}
