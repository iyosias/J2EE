package com.struts.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.interf.ICoffeeServiceLib;
import com.struts.sl.CoffeeServiceLib;



public class CoffeeNamesAction extends ActionSupport {

	private static final long serialVersionUID = 2825557554290406098L;
	private List<String> nameslist;
	
	public List<String> getNameslist() {
		return nameslist;
	}
	
	public void setNameslist(List<String> nameslist) {
		this.nameslist = nameslist;
	}
	
	@Override
	public String execute() throws Exception{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ICoffeeServiceLib csl = (CoffeeServiceLib) context.getBean("coffee");
		nameslist = csl.getAllCoffeeNames();
		
		return SUCCESS;
	}

}
