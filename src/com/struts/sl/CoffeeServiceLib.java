package com.struts.sl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.struts.bean.Coffee;
import com.struts.dao.CoffeeDAO;
import com.struts.interf.ICoffeeServiceLib;

public class CoffeeServiceLib implements ICoffeeServiceLib {
	private CoffeeDAO coffeeDao;
	
	@Autowired
	@Qualifier("coffeeServiceRelated")
	public void setCoffeeDao(CoffeeDAO coffeeDao) {
		this.coffeeDao = coffeeDao;
	}

	public List<Coffee> getAllCofees(){
		return coffeeDao.getAllCoffee();
	}
	
	public Coffee getCoffeeByName(String cname){
		return coffeeDao.getCoffeeByName(cname);
	}
	
	public ArrayList<String> getAllCoffeeNames() {
		return coffeeDao.getAllCoffeeNames();
	}
	
	public boolean createCoffee(Coffee coffee){
		return coffeeDao.createCoffee(coffee);
	}

}
