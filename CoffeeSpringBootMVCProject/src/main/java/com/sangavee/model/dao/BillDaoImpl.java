package com.sangavee.model.dao;


import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sangavee.model.bean.Bill;

@Repository("BillDao")
public class BillDaoImpl implements BillDao {

	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void addBill(int billId,int orderId, double amount, double discount, double netValue, double gst, double serviceTax, double totalAmount)
	{
		SessionFactory sessionFactory=entityManagerFactory.unwrap(SessionFactory.class);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
 		Bill bill=new Bill(billId,orderId,amount,discount,netValue,gst,serviceTax,totalAmount,getCurrentDate());
		int rows=(int) session.save(bill);
 		transaction.commit();
 		session.close();
		
	}

	
	@Override
	public int getMaxBillId() {
		SessionFactory sessionFactory=entityManagerFactory.unwrap(SessionFactory.class);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("select Max(bill_Id) from Bill");
		int billId=(int) query.getSingleResult();
 		transaction.commit();
 		session.close();
 		return billId;
	}

	@Override
	public Bill getInvoiceByOrderId(int orderId){
		SessionFactory sessionFactory=entityManagerFactory.unwrap(SessionFactory.class);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("from Bill where order_Id="+orderId);
		Bill bill=(Bill) query.getSingleResult();
 		transaction.commit();
 		session.close();
 		return bill;
	}




}
