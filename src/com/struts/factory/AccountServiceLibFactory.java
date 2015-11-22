package com.struts.factory;

import com.struts.interf.IAccountServiceLib;
import com.struts.sl.AccountServiceLib;

public class AccountServiceLibFactory {
	public static IAccountServiceLib getAccountService(){
		return new AccountServiceLib();
	}
}
