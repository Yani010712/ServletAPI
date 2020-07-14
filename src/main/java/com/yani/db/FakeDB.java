package com.yani.db;

import java.util.HashMap;
import java.util.Map;

import com.yani.models.Pizza;

public class FakeDB {
	
	public static Map<Integer, Pizza> pizzaMenu = new HashMap<Integer, Pizza>();
	
	//create a static block to pre-populate our list.
	static {
		System.out.println("Populating Pizzas");
		Pizza p1 = new Pizza(1, "Pepperoni", "Pepperoni/Cheese/Sauce", 7.50);
		Pizza p2 = new Pizza(2, "Sausage", "Sausage/Cheese/Sauce", 7.50);
		Pizza p3 = new Pizza(3, "Veggies", "Onions/Green Peppers/Mushrooms/Cheese/Sauce", 7.25);
		
		pizzaMenu.put(p1.getP_id(), p1);
		pizzaMenu.put(p2.getP_id(), p2);
		pizzaMenu.put(p3.getP_id(), p3);
		
	}

}
