package com.yani.services;

import java.util.ArrayList;
import java.util.List;

import com.yani.dao.PizzaDAO;
import com.yani.dao.PizzaDAOImpl;
import com.yani.dao.PizzaDAORealImpl;
import com.yani.models.Pizza;

public class PizzaService {

	PizzaDAO pd = new PizzaDAORealImpl();
	
	//This class is for performing any business logic operations
	//But I will start simply with some basic CRUD operation calls.
	
	
	public Pizza getPizza(int id) {
		return pd.getPizza(id);
	}
	
	public List<Pizza> getAllPizzas() {
		return pd.getAllPizzas();
	}
	
	public boolean addPizza(Pizza p) {
		return pd.addPizza(p);
	}
	
	public boolean updatePizza(Pizza change) {
		return pd.updatePizza(change);
	}
	
	public boolean deletePizza(int id) {
		return pd.deletePizza(id);
	}
	
	public boolean deletePizza(String name) {
		Pizza p = pd.getPizza(name);
		return pd.deletePizza(p.getP_id());
	}

	public List<Pizza> getPizzaByNameAndPrice(String name, double price) {
		
		List<Pizza> pizzas = pd.getAllPizzas();
		List<Pizza> finalList = new ArrayList<Pizza>();
		
		for(Pizza p : pizzas) {
			if(p.getName().contains(name) && p.getPrice() <= price) {
				finalList.add(p);
			}
		}
		
		return finalList;
	}
	
}
