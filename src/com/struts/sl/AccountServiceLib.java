package com.struts.sl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import com.struts.bean.Account;
import com.struts.dao.AccountDAO;
import com.struts.interf.IAccountServiceLib;

// If i use the component class it will work I don't have to create a bean
// definition inside the spring class but it means i can only have one bean for the class

@Component
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
