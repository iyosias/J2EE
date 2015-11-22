package com.struts.factory;

import com.struts.interf.ICoffeeServiceLib;
import com.struts.sl.CoffeeServiceLib;

public class CoffeeServiceLibFactory {
	public static ICoffeeServiceLib getCoffeeService(){
		return new CoffeeServiceLib();
	}
}
