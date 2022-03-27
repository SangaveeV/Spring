package com.sangavee.model.dao;


import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("DiscountDao")
public class DiscountDaoImpl implements DiscountDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public double getDiscountByVoucher(String voucher){
		SessionFactory sessionFactory=entityManagerFactory.unwrap(SessionFactory.class);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query6=session.createQuery("select discount from Discount where voucher="+"'"+voucher+"'");
		double discount=(double) query6.getSingleResult();
		transaction.commit();
 		session.close();
 		return discount;
 		
	}

}
