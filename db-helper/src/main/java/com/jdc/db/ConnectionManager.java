package com.jdc.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	private static Properties props;
	
	static {
		try {
			props = new Properties();
			props.load(ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				props.getProperty("db.url"),
				props.getProperty("db.user"), 
				props.getProperty("db.pass"));
	}

}
