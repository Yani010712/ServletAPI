package com.yani.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yani.models.Pizza;
import com.yani.services.PizzaService;

public class PizzaController {
	
	  public static PizzaService ps = new PizzaService();
	  public static Gson gson = new Gson();
	  
	  public static void getPizza(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		  response.getWriter().append("Got the Pizza");
		  //1) Handle the request
		  int id = Integer.parseInt(request.getParameter("id"));
		  System.out.println("ID: " + id );
		  
		  //2) Use our services 
		  Pizza p = ps.getPizza(id);
		  
		  //3) Generate a response
//		  response.getWriter().append(p.toString());
		  response.getWriter().append(gson.toJson(p));
	  }
	  
	  public static void addPizza(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  
//		  response.getWriter().append("Added the Pizza");
		  Pizza p = gson.fromJson(request.getReader(), Pizza.class);
		  
		  //add the pizza
		  ps.addPizza(p);
		  
		  //generate a response
		  response.getWriter().append(gson.toJson(p));
		 
	  }
	  
	  public static void updatePizza(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		  response.getWriter().append("Updated Pizza");
		  
		  //Processing the request
		  Pizza change = gson.fromJson(request.getReader(), Pizza.class);
		  
		  //call the service
		  ps.updatePizza(change);
		  
		  //Generate a response
		  response.getWriter().append(gson.toJson(change));
	  }
	  
		public static void deletePizza(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
//			response.getWriter().append("Deleted Pizza");
			
			Map<String, String[]> paramMap = request.getParameterMap();
			if(paramMap.containsKey("id")) {
				int id = Integer.parseInt(request.getParameter("id"));
				boolean worked = ps.deletePizza(id);
				response.getWriter().append(Boolean.toString(worked));
			} else if (paramMap.containsKey("name")) {
				response.getWriter().append(Boolean.toString(ps.deletePizza(request.getParameter("name"))));
			} else {
				response.getWriter().append(Boolean.toString(false));
			}
			
//			String name = request.getParameter("name");
//			 
//			boolean worked = ps.deletePizza(name);
//			
//			response.getWriter().append("Worked: " + worked);
//			response.getWriter().append("" + worked);
//			response.getWriter().append(Boolean.toString(worked));
		}

		public static void getAllPizzas(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			List<Pizza> pizzas = ps.getAllPizzas();
			
			response.getWriter().append(gson.toJson(pizzas));

			
		}

		public static void getPizzaByNameAndPrice(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			String name = request.getParameter("name");
			double price = Double.parseDouble(request.getParameter("price"));
			
			List<Pizza> pizzas = ps.getPizzaByNameAndPrice(name, price);
			
			response.getWriter().append(gson.toJson(pizzas));

			
		}


	  

}
