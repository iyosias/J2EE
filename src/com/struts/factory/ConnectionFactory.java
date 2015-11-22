package com.struts.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "201274");
		return myconn;
	}

}
