package com.struts.interf;

import java.util.List;

import com.struts.bean.Supplier;


public interface ISupplierServiceLib {
	public List<Supplier> getAllSuppliers();
	
	public List<Integer> getAllSupplierId();
	
	public boolean createSupplier(Supplier supplier);
}
