package com.struts.factory;

import com.struts.dao.CoffeeDAO;
import com.struts.interf.ICoffeeDAO;

public class CoffeeDAOFactory {
	public static ICoffeeDAO getCoffeeDAO(){
		return new CoffeeDAO();
	}
}
