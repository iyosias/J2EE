package com.struts.sl;

import com.struts.bean.Account;
import com.struts.dao.AccountDAO;
import com.struts.interf.IAccountServiceLib;


public class AccountServiceLib implements IAccountServiceLib{
	
	private AccountDAO accountDao;
	
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

}
