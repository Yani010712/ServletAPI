package com.yani.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yani.models.Pizza;
import com.yani.util.JDBCConnection;

public class PizzaDAORealImpl implements PizzaDAO {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public Pizza getPizza(int id) {
		
		try {
			
			String sql = "SELECT * FROM pizza WHERE p_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Pizza(rs.getInt("P_ID"),
						rs.getString("NAME"),
						rs.getString("TOPPINGS"),
						rs.getDouble("PRICE"));
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public Pizza getPizza(String name) {
		try {
			
			String sql = "SELECT * FROM pizza WHERE name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Pizza(rs.getInt("P_ID"),
						rs.getString("NAME"),
						rs.getString("TOPPINGS"),
						rs.getDouble("PRICE"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public List<Pizza> getAllPizzas() {

		try {
			
			String sql = "SELECT * FROM pizza";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			List<Pizza> pizzas = new ArrayList<Pizza>();
			
			while(rs.next()) {
				pizzas.add(new Pizza(rs.getInt("P_ID"),
						rs.getString("NAME"),
						rs.getString("TOPPINGS"),
						rs.getDouble("PRICE")));
			}
			
			return pizzas;
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addPizza(Pizza p) {

		try {
			String sql = "INSERT INTO pizza VALUES (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(p.getP_id()));
			ps.setString(2, p.getName());
			ps.setString(3, p.getToppings());
			ps.setString(4, Double.toString(p.getPrice()));

			ResultSet rs = ps.executeQuery();
			return true;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePizza(Pizza change) {

		try {
			
			String sql = "UPDATE pizza SET name = ?, toppings = ?, price = ? WHERE p_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getName());
			ps.setString(2, change.getToppings());
			ps.setString(3, Double.toString(change.getPrice()));
			ps.setString(4, Integer.toString(change.getP_id()));
			
			ResultSet rs = ps.executeQuery();
			return true;			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public boolean deletePizza(int id) {

		try {
			
			String sql = "DELETE pizza WHERE p_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


}
