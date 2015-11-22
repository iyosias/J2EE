package com.struts.action;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.bean.Coffee;
import com.struts.interf.ICoffeeServiceLib;
import com.struts.sl.CoffeeServiceLib;


public class AllCoffeeAction extends ActionSupport{

	private static final long serialVersionUID = 7005394061898250474L;
	private List<Coffee> coffeelist;
	
	

	public List<Coffee> getCoffeelist() {
		return coffeelist;
	}



	public void setCoffeelist(List<Coffee> coffeelist) {
		this.coffeelist = coffeelist;
	}



	@Override
	public String execute()throws Exception {
		coffeelist = new ArrayList<Coffee>();
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ICoffeeServiceLib cs = (CoffeeServiceLib) context.getBean("coffee");
		
		coffeelist = cs.getAllCofees();
		
		return SUCCESS;
		
	}

}
