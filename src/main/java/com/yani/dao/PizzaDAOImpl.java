package com.yani.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.yani.db.FakeDB;
import com.yani.models.Pizza;

public class PizzaDAOImpl implements PizzaDAO {

	public Pizza getPizza(int id) {
		return FakeDB.pizzaMenu.get(id);
	}

	public List<Pizza> getAllPizzas() {
		
		List<Pizza> pizzas = new ArrayList<Pizza>();
		
		Set<Integer> keySet = FakeDB.pizzaMenu.keySet();
		for(Integer key : keySet) {
			pizzas.add(FakeDB.pizzaMenu.get(key));
		}
		
		return pizzas;
	}

	public boolean addPizza(Pizza p) {
		FakeDB.pizzaMenu.put(p.getP_id(), p);
		return true;
	}

	public boolean updatePizza(Pizza change) {
		FakeDB.pizzaMenu.replace(change.getP_id(), change);
		return true;
	}

	public boolean deletePizza(int id) {
		FakeDB.pizzaMenu.remove(id);
		return true;
	}

	@Override
	public Pizza getPizza(String name) {
		
		Set<Integer> keys = FakeDB.pizzaMenu.keySet();
		
		for(Integer key : keys) {
			if(FakeDB.pizzaMenu.get(key).getName().contains(name)) {
				return FakeDB.pizzaMenu.get(key);
			}
		}
		
		return null;
		
	}

}
