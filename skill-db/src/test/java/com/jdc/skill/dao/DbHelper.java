package com.jdc.skill.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelper {

	public void truncateTables(String ... tables) {
		try(Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			
			stmt.execute("set foreign_key_checks = 0");
			
			for(String table : tables) {
				String sql = String.format("truncate table %s", table);
				stmt.executeUpdate(sql);
			}
			
			stmt.execute("set foreign_key_checks = 1");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
