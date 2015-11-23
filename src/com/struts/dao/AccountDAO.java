package com.struts.dao;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.struts.bean.Account;

import com.struts.interf.IAccountDAO;

public class AccountDAO implements IAccountDAO {
	
	private MessageSource messageSource;
	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	private static SessionFactory factory;
	
	public AccountDAO(){
		try{
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex){
			System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
		}
	}
	
	public boolean createAccount(Account act){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			Account account = new Account();
			account = act;
			tx = session.beginTransaction();
			session.save(account);
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
	public boolean authenticate(String email, String password){
		System.out.println(this.messageSource.getMessage("authenticate", null, "Default Authentication", null));
		System.out.println(this.messageSource.getMessage("authenticate.account", new Object[] {email, password}, "Default Account", null));
		boolean status = false;
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Account.class)
                    .add(Restrictions.eq("email", email))
                    .add(Restrictions.eq("password", password));
			tx.commit();
						
			 Object result = criteria.uniqueResult();
	            if (result != null) {
	                status = true;
	            }
				
		} catch(HibernateException ex ){
			if (tx!=null)
				tx.rollback();
			ex.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return status;
	}
	public boolean checkUserNameExist(String email){
		boolean status = false;
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Account.class)
                    .add(Restrictions.eq("email", email));
			tx.commit();
						
			 Object result = criteria.uniqueResult();
	            if (result != null) {
	                status = true;
	            }
				
		} catch(HibernateException ex ){
			if (tx!=null)
				tx.rollback();
			ex.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return status;
	}
	public Account getUserDetail(String email){
		Account user = new Account();
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			String hql = "from Account where email = " + email;
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			user = (Account) query.list();
			tx.commit();
			
		} catch(HibernateException ex ){
			if (tx!=null)
				tx.rollback();
			ex.printStackTrace();
			
		} finally {
			session.close();
		}
		return user;
	}

}
