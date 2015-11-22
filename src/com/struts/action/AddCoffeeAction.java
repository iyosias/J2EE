package com.struts.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.bean.Coffee;
import com.struts.interf.ICoffeeServiceLib;
import com.struts.interf.ISupplierServiceLib;
import com.struts.sl.CoffeeServiceLib;
import com.struts.sl.SupplierServiceLib;

public class AddCoffeeAction extends ActionSupport{

	private static final long serialVersionUID = 5471326237128969672L;
	
	private Coffee coffeeBean;
	private List<Integer> supplier_id = null;
	
	public List<Integer> getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(List<Integer> supplier_id) {
		this.supplier_id = supplier_id;
	}

	public Coffee getCoffeeBean() {
		return coffeeBean;
	}

	public void setCoffeeBean(Coffee coffeeBean) {
		this.coffeeBean = coffeeBean;
	}
	
	public String getSupplierList(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");;
		ISupplierServiceLib ssl = (SupplierServiceLib) context.getBean("supplier");
		supplier_id = ssl.getAllSupplierId();
		
		return SUCCESS;
		
	}
	
	@Override
	public String execute() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ICoffeeServiceLib as = (CoffeeServiceLib) context.getBean("coffee");
		boolean status = as.createCoffee(getCoffeeBean());
		if(status)
			return SUCCESS;
		else
			return INPUT;
	}
	
	@Override
	public void validate(){
		
	}

}
