package com.sangavee.model.dao;


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
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Bill addBill(int billId,int orderId, double amount, double discount, double netValue, double gst, double serviceTax, double totalAmount)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
 		Bill bill=new Bill(billId,orderId,amount,discount,netValue,gst,serviceTax,totalAmount,getCurrentDate());
		int rows=(int) session.save(bill);
 		transaction.commit();
 		session.close();
 		return bill;
		
	}

	
	@Override
	public int getMaxBillId() {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		int billId=0;
		Query query=session.createQuery("select Max(bill_Id) from Bill");
		if(query.getSingleResult()!=null) {
			billId=(int) query.getSingleResult();
		} 
 		transaction.commit();
 		session.close();
 		return billId;
	}

	@Override
	public Bill getInvoiceByOrderId(int orderId){

		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("from Bill where order_Id="+orderId);
		Bill bill=(Bill) query.getSingleResult();
 		transaction.commit();
 		session.close();
 		return bill;
	}




}
