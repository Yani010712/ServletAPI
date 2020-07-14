package com.yani.serf;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yani.controllers.PizzaController;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		/*
		 * This method will delegate to other methods on the controller layer of our
		 * application to process this request.
		 */
//		response.getWriter().append("Handling your request");
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
//		response.getWriter().append("\nURL: " + url + "\nURI: " + uri + "\n");
		System.out.println("URL: " + url + "\nURI: " + uri);
		
		/*
		 * We are going to use this switch to handle our various requests
		 */
		switch (uri) {

		case "/ServletAPI/test.do": {
			response.getWriter().append("Test");
			response.setStatus(200);
			break;
		}
		
		case "/ServletAPI/getPizza.do": {
			PizzaController.getPizza(request, response);
			break;
		}
		
		case "/ServletAPI/getPizzaNamePrice.do":{
			PizzaController.getPizzaByNameAndPrice(request, response);
			break;
		}
		
		case "/ServletAPI/allPizzas.do":{
			PizzaController.getAllPizzas(request, response);
			break;
		}
		
		
		case "/ServletAPI/addPizza.do": {
			PizzaController.addPizza(request, response);
			break;
		}
		
		case "/ServletAPI/updatePizza.do": {
			PizzaController.updatePizza(request, response);
			break;
		}
		
		case "/ServletAPI/deletePizza.do": {
			PizzaController.deletePizza(request, response);
			break;
		}
		
		default: {
			response.sendError(451, "Get off my lawn!");
			break;
		}

		}

	} 

}
