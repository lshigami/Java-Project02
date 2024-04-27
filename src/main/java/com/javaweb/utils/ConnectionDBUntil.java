package com.javaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDBUntil {
	private static  String user = "root";
	private static  String paString = "30062004";
	private static  String urlString = "jdbc:mysql://localhost:3306/estatebasic";
	
	public static final Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(urlString,user,paString);
			return connection;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
