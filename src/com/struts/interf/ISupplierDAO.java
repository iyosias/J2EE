package com.struts.interf;

import java.util.List;

import com.struts.bean.Supplier;


public interface ISupplierDAO {
	public List<Supplier> getAllSupplier();
	
	public List<Integer> getAllSupplierId();
	
	public boolean createSupplier(Supplier supplier);
}
