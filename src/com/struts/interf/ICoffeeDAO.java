package com.struts.interf;

import java.util.ArrayList;
import java.util.List;

import com.struts.bean.Coffee;

public interface ICoffeeDAO {
	public List<Coffee> getAllCoffee();
	
	public Coffee getCoffeeByName(String cname);
	
	public ArrayList<String> getAllCoffeeNames();
	
	public boolean createCoffee(Coffee coffee);
}
