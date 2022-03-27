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

@Repository("CoffeeDao")
public class CoffeeDaoImpl implements CoffeeDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public ArrayList<Coffee> getAllCoffee() {
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query<Coffee> query=session.createQuery("from Coffee");
		List<Coffee> coffeeList=query.getResultList();
		coffeeList.stream().forEach(System.out::println);
 		transaction.commit();
 		session.close();
		return (ArrayList<Coffee>) coffeeList;
	}

	@Override
	public double getPriceByNameSize(String name, String size) {
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("Select price from Coffee where coffeeName="+"'"+name+"'"+" and coffeeSize="+"'"+size+"'");
		double price=(double) query.getSingleResult();
		transaction.commit();
 		session.close();
 		return price;

	}

	@Override
	public double getPriceById(int id) {

		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("Select price from Coffee where coffee_Id="+id);
		double price=(double) query.getSingleResult();
		transaction.commit();
 		session.close();
 		return price;
	}

	@Override
	public int getCoffeeId(String name, String size) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("Select coffee_Id from Coffee where coffeeName="+"'"+name+"'"+" and coffeeSize="+"'"+size+"'");
		int coffeeId=(int) query.getSingleResult();
		transaction.commit();
 		session.close();
 		return coffeeId;
	}

	@Override
	public Coffee getCoffeeById(int id) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("from Coffee where coffee_Id="+id);
		Object coffee=query.getSingleResult();
		transaction.commit();
 		session.close();
 		return (Coffee) coffee;
	}

}
