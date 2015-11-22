package com.struts.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.bean.Coffee;
import com.struts.interf.ICoffeeServiceLib;
import com.struts.sl.CoffeeServiceLib;

public class SearchCoffeeAction extends ActionSupport {

	private static final long serialVersionUID = 1029119697488457293L;
	
	private Coffee cof;
	private String searchcoffee;

	public String getSearchcoffee() {
		return searchcoffee;
	}

	public void setSearchcoffee(String searchcoffee) {
		this.searchcoffee = searchcoffee;
	}

	public Coffee getCof() {
		return cof;
	}

	public void setCof(Coffee cof) {
		this.cof = cof;
	}
	
	@Override
	public String execute() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ICoffeeServiceLib csl = (CoffeeServiceLib) context.getBean("coffee");
		cof = csl.getCoffeeByName(searchcoffee);
		
		return SUCCESS;
	}

}
