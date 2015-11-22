package com.struts.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coffees")
public class Coffee {
	
	@Id
	private String cof_name;
	
	@Column(name = "sup_id")
	private int sup_id;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "sales")
	private int sales;
	
	@Column(name = "total")
	private int total;
	
	public Coffee() { }
	
	public Coffee(String cof_name, int sup_id, double price, int sales, int total) {
		super();
		this.cof_name = cof_name;
		this.sup_id = sup_id;
		this.price = price;
		this.sales = sales;
		this.total = total;
	}
	
	public String getCof_name() {
		return cof_name;
	}
	public void setCof_name(String cof_name) {
		this.cof_name = cof_name;
	}
	public int getSup_id() {
		return sup_id;
	}
	public void setSup_id(int sup_id) {
		this.sup_id = sup_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	

	

}
