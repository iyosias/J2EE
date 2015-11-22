package com.struts.factory;

import com.struts.interf.ISupplierServiceLib;
import com.struts.sl.SupplierServiceLib;

public class SupplierServiceLibFactory {
	public static ISupplierServiceLib getSupplierService(){
		return new SupplierServiceLib();
	}
}
