package com.struts.interf;

import com.struts.bean.Account;

public interface IAccountDAO {
	public boolean createAccount(Account act);
	
	public boolean authenticate(String email, String password);
	
	public boolean checkUserNameExist(String email);
	
	public Account getUserDetail(String email);

}
