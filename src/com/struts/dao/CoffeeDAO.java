package com.struts.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.struts.bean.Coffee;
import com.struts.interf.ICoffeeDAO;

public class CoffeeDAO implements ICoffeeDAO {
	
	private static SessionFactory factory;
	
	public CoffeeDAO(){
		try{
			factory = new Configuration().configure().
					addPackage("com.struts.bean")
					.addAnnotatedClass(Coffee.class)
					.buildSessionFactory();
		} catch (Throwable ex){
			System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
		}
	}
	
	public List<Coffee> getAllCoffee() {
		Session session = factory.openSession();
	    Transaction tx = null;
	    List<Coffee> stlist = null;
	    
	    try{
	    	tx = session.beginTransaction();
	    	stlist = session.createQuery("from Coffee").list();
	        tx.commit();

		} catch(HibernateException ex ){
			if (tx!=null)
				tx.rollback();
			ex.printStackTrace();
			
		} finally {
			session.close();
		}
		return stlist;
	}
	
	public Coffee getCoffeeByName(String cname){
		Coffee cof = new Coffee();
		Session session = factory.openSession();
		
		try {
			Criteria criteria = session.createCriteria(Coffee.class)
					 .add(Restrictions.eq("cof_name", cname));
			Object result = criteria.uniqueResult();
            if (result != null) {
                cof = (Coffee) result;
            }
			
		} catch(HibernateException ex ){
			ex.printStackTrace();
			
		} finally {
			session.close();
		}
		return cof;
	}
	
	
	public ArrayList<String> getAllCoffeeNames() {
		Session session = factory.openSession();
	    Transaction tx = null;
	    ArrayList<String> coffees = null;
	    try{
	    	tx = session.beginTransaction();
	    	coffees = (ArrayList<String>) session.createQuery("select cof_name from Coffee").list();
	        tx.commit();

		} catch(HibernateException ex ){
			if (tx!=null)
				tx.rollback();
			ex.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return coffees;
	}

	public boolean createCoffee(Coffee coffee){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			Coffee coffee1 = new Coffee();
			coffee1 = coffee;
			tx = session.beginTransaction();
			session.save(coffee1);
			session.getTransaction().commit();
			
		} catch(HibernateException ex ){
			if (tx!=null)
				tx.rollback();
			ex.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return true;
	}

	

}
