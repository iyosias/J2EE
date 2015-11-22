package com.struts.sl;

import java.util.List;

import com.struts.bean.Supplier;
import com.struts.dao.SupplierDAO;

import com.struts.interf.ISupplierServiceLib;

public class SupplierServiceLib implements ISupplierServiceLib{
	
		private SupplierDAO supplierDao;

		public void setSupplierDao(SupplierDAO supplierDao) {
			this.supplierDao = supplierDao;
		}

		public List<Supplier> getAllSuppliers(){
			return supplierDao.getAllSupplier();
		}
		
		public List<Integer> getAllSupplierId(){
			return supplierDao.getAllSupplierId();
		}
		
		public boolean createSupplier(Supplier supplier){
			return supplierDao.createSupplier(supplier);	
		}
}
