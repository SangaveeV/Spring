package com.sangavee.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sangavee.model.bean.AddOn;

@Repository("AddOnDao")
public class AddOnDaoImpl implements AddOnDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public ArrayList<AddOn> getAllAddOn() {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query<AddOn> query=session.createQuery("from AddOn");
		List<AddOn> addOnList=query.getResultList();
		addOnList.stream().forEach(System.out::println);
 		transaction.commit();
 		session.close();
		return (ArrayList<AddOn>) addOnList;
}
	public double getAddOnPriceByName(String name) {
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("Select price from AddOn where addOnName="+"'"+name+"'");
		double price=(double) query.getSingleResult();
		transaction.commit();
 		session.close();
 		return price;
}
	@Override
	public double getAddOnPriceById(int id){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("Select price from AddOn where addOn_Id="+id);
		double price=(double) query.getSingleResult();
		transaction.commit();
 		session.close();
 		return price;
	}
	@Override
	public int getAddOnId(String name)  {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("Select addOn_Id from AddOn where addOnName="+"'"+name+"'");
		int id=(int) query.getSingleResult();
		transaction.commit();
 		session.close();
 		return id;
	}
	@Override
	public AddOn getAddonById(int id) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("from AddOn where addOn_Id="+id);
		Object addOn=query.getSingleResult();
		transaction.commit();
 		session.close();
		return (AddOn) addOn;
	}
}
