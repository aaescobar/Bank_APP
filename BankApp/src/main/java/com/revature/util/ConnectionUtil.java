package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		
		/* Reusing example 
		 * To establish a connection we need 3 credentials:
		 * url (endpoint), username, password
		 */
		
		if(connection == null) {
			
			//Establish Connection
			String endpoint = "andy2106postgres.cuaiqdjobuym.us-east-1.rds.amazonaws.com";
			
			//URL Format (postgres JDBC):
			//jdbc:postgresql://[endpoint]/[database]
			
			String url = "jdbc:postgresql://" + endpoint + "/postgres";
			String username = "andy";
			String password = "poligono";
			
			try {
				
				connection = DriverManager.getConnection(url, username, password);
				
				//sqlexception
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return connection;
		
	}
	
	/*
	 * THIS IS FOR TESTING PURPOSES ONLY!!!
	 * NOT NEED TO ACTUALLY USE JDBC
	 */
	public static void main(String[] args) {
		
		Connection conn1 = getConnection();
		Connection conn2 = getConnection();
		Connection conn3 = getConnection();
		
		System.out.println(conn1);
		System.out.println(conn2);
		System.out.println(conn3);
	}

	
}
	
