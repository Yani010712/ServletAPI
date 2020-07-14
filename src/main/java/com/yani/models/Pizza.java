package com.yani.models;

public class Pizza {
	
	private int p_id;
	private String name;
	private String toppings;
	private double price;
	
	public Pizza(int p_id, String name, String toppings, double price) {
		super();
		this.p_id = p_id;
		this.name = name;
		this.toppings = toppings;
		this.price = price;
	}

	public Pizza() {
		super();
	}

	public Pizza(String name, String toppings, double price) {
		super();
		this.name = name;
		this.toppings = toppings;
		this.price = price;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToppings() {
		return toppings;
	}

	public void setToppings(String toppings) {
		this.toppings = toppings;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Pizza [p_id=" + p_id + ", name=" + name + ", toppings=" + toppings + ", price=" + price + "]";
	}
	
	

	

}
