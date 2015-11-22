package com.struts.factory;

import com.struts.dao.AccountDAO;
import com.struts.interf.IAccountDAO;

public class AccountDAOFactory {
	public static IAccountDAO getAccountDAO(){
		return new AccountDAO();
	}

}
