package com.yani.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	public static Connection conn = null;
	
	public static Connection getConnection() {
		
		try {
			
			//build a Singleton Connection
			//allow for 1 Connection object at a time
			if(conn == null) {
				
				//Oracle's hotfix
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String endpoint = "jdbc:oracle:thin:@yanidb-2020.ceagdrrvnqvy.us-east-2.rds.amazonaws.com:1521:ORCL";
				String username = "yani";
				String password = "Helloworld1";
				
				conn = DriverManager.getConnection(endpoint, username, password);
				return conn;


			}else {
				return conn;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}

