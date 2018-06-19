package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.Spring;

public class TestJdbc {

	public static void main(String[] args) {
		
		String user = "springstudent";
		String jdbcUrl = "jdbc:mysql://localhost/web_customer_tracker?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String pass = "springstudent";
				
		
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conecting to DB: " + jdbcUrl);
			
			Connection myConnection = (Connection)DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection successfull!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
