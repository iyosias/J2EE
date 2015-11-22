package com.struts.factory;

import com.struts.dao.SupplierDAO;
import com.struts.interf.ISupplierDAO;

public class SupplierDAOFactory {
	public static ISupplierDAO getSupplierDAO(){
		return new SupplierDAO();
	}
}
