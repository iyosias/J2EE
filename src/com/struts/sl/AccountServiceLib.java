package com.struts.sl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;

import com.struts.bean.Account;
import com.struts.dao.AccountDAO;
import com.struts.interf.IAccountServiceLib;

// If we use the component class it will work we don't have to create a bean
// definition inside the spring class but it means we can only have one bean for the class
// Another stereotype that we can use is controller. It does the same thing as component, but it also
// tells spring that the bean is a controller layer
// for Data access we use @Repository and for service we use @Service
// Advantage of using this annotation is because it tells spring know what role the spring is doing
// Secondly, it add a level of documentation

@Controller
public class AccountServiceLib implements IAccountServiceLib{
	
	private AccountDAO accountDao;
	


	@Autowired 
	@Required
	public void setAccountDao(AccountDAO accounttDao) {
		this.accountDao = accounttDao;
	}

	public boolean createAccount(Account act){
		return accountDao.createAccount(act);
		
	}
	
	public boolean authenticate(String email, String password){
		return accountDao.authenticate(email, password);
	}
	
	public boolean checkUserNameExist(String email){
		return accountDao.checkUserNameExist(email);
	}
	
	public Account getUserDetail(String email){
		return accountDao.getUserDetail(email);
	
	}
	
	@PostConstruct
	public void initalizeAccount(){
		System.out.println("Init of Account");
	}
	
	@PreDestroy
	public void destroyAccount() {
		System.out.println("Destroy Account");
	}

}
