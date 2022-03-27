package com.sangavee.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sangavee.model.bean.OrderTransaction;

@Repository("OrderTransactionDao")
public class OrderTransactionDaoImpl implements OrderTransactionDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public OrderTransaction createOrderTran(int orderTranId , int orderId, int coffeeId, int addOnId) {
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
 		OrderTransaction trans=new OrderTransaction(orderTranId,orderId,coffeeId,addOnId);
		int rows=(int) session.save(trans);
 		transaction.commit();
 		session.close();
 		return trans;
	}

	@Override
	public ArrayList<OrderTransaction> getOrderTranByCustOrderID(int orderId){

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
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		int transId=0;
		Query query=session.createQuery("select Max(transaction_Id) from OrderTransaction");
		if(query.getSingleResult()!=null) {
			transId=(int) query.getSingleResult();
		}
		
 		transaction.commit();
 		session.close();
 		return transId;
	}

}
