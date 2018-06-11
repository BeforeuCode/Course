package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost/hb-04-one-to-many-uni?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
				
		
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conecting to DB: " + jdbcUrl);
			
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successfull!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
