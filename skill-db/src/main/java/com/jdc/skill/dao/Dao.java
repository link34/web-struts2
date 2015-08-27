package com.jdc.skill.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Dao {

	private Properties props;

	public Dao() throws IOException {
		props = new Properties();
		props.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
	}

	protected Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				props.getProperty("db.url"),
				props.getProperty("db.user"), 
				props.getProperty("db.pass"));
	}
	
	protected String getSql(String sqlid) {
		return props.getProperty(sqlid);
	}

}
