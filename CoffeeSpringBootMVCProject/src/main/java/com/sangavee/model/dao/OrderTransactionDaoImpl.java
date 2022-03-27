package com.sangavee.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sangavee.model.bean.OrderTransaction;

@Repository("OrderTransactionDao")
public class OrderTransactionDaoImpl implements OrderTransactionDao {


	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public int createOrderTran(int orderTranId , int orderId, int coffeeId, int addOnId) {
		SessionFactory sessionFactory=entityManagerFactory.unwrap(SessionFactory.class);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
 		OrderTransaction trans=new OrderTransaction(orderTranId,orderId,coffeeId,addOnId);
		int rows=(int) session.save(trans);
 		transaction.commit();
 		session.close();
 		return rows;
	}

	@Override
	public ArrayList<OrderTransaction> getOrderTranByCustOrderID(int orderId){
		SessionFactory sessionFactory=entityManagerFactory.unwrap(SessionFactory.class);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("from OrderTransaction where order_Id="+orderId);
		List<OrderTransaction> transList=query.getResultList();
 		transaction.commit();
 		session.close();
 		return (ArrayList<OrderTransaction>) transList;
	}

	@Override
	public int getMaxOrderTranId() {
		SessionFactory sessionFactory=entityManagerFactory.unwrap(SessionFactory.class);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("select Max(transaction_Id) from OrderTransaction");
		int transId=(int) query.getSingleResult();
 		transaction.commit();
 		session.close();
 		return transId;
	}

}
