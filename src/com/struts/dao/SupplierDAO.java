package com.struts.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.struts.bean.Supplier;
import com.struts.interf.ISupplierDAO;


public class SupplierDAO implements ISupplierDAO {
	
private static SessionFactory factory;
	
	public SupplierDAO(){
		try{
			factory = new Configuration().configure().
					addPackage("com.struts.bean")
					.addAnnotatedClass(Supplier.class)
					.buildSessionFactory();
		} catch (Throwable ex){
			System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
		}
	}
	

	@SuppressWarnings("unchecked")
	public List<Supplier> getAllSupplier() {
		Session session = factory.openSession();
	    Transaction tx = null;
	    List<Supplier> stlist = null;
	    
	    try{
	    	tx = session.beginTransaction();
	    	stlist = session.createQuery("from Supplier").list();
	    	System.out.println(stlist.get(0).getSup_id());

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
	
	@SuppressWarnings("unchecked")
	public List<Integer> getAllSupplierId()  {
		Session session = factory.openSession();
	    Transaction tx = null;
	    List<Integer> stlist = null;
	    
	    try{
	    	tx = session.beginTransaction();
	    	stlist = session.createQuery("select sup_id from Supplier").list();
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
	public boolean createSupplier(Supplier supplier){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			Supplier supplier1 = new Supplier();
			supplier1 = supplier;
			tx = session.beginTransaction();
			session.save(supplier1);
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
