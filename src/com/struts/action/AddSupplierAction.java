package com.struts.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.bean.Supplier;
import com.struts.interf.ISupplierServiceLib;
import com.struts.sl.SupplierServiceLib;


public class AddSupplierAction extends ActionSupport {

	private static final long serialVersionUID = -5275025358156433081L;
	
	private Supplier supplierBean;

	public Supplier getSupplierBean() {
		return supplierBean;
	}

	public void setSupplierBean(Supplier supplierBean) {
		this.supplierBean = supplierBean;
	}
	
	@Override
	public String execute() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ISupplierServiceLib ssl = (SupplierServiceLib) context.getBean("supplier");
		//SupplierServiceLib ssl = new SupplierServiceLib();
		boolean status = ssl.createSupplier(getSupplierBean());
		if (status)
			return SUCCESS;
		else
			return INPUT;
	}
	

}
