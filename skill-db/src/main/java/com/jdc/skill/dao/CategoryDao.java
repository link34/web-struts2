package com.jdc.skill.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdc.skill.data.Category;

public class CategoryDao extends Dao {

	private static String GET_ALL_SQL = "sql.category.selectAll";
	private static String INSERT = "sql.category.insert";
	private static String FIND_BY_ID = "sql.category.findById";
	private static String UPDATE = "sql.category.update";
	private static String DELETE = "sql.category.delete";

	public CategoryDao() throws IOException {
		super();
	}

	public List<Category> getAll() {
		List<Category> result = null;

		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement()) {
			String sql = getSql(GET_ALL_SQL);
			ResultSet rs = stmt.executeQuery(sql);
			result = new ArrayList<Category>();

			while (rs.next()) {
				Category c = new Category();
				c.setCategory_id(rs.getInt("category_id"));
				c.setCategory(rs.getString("category"));

				result.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void insert(Category c) {
		String sql = String.format(getSql(INSERT), c.getCategory());
		updateSql(sql);
	}

	public Category findById(int id) {
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement()) {
			String sql = String.format(getSql(FIND_BY_ID), id);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Category c = new Category();
				c.setCategory_id(rs.getInt("category_id"));
				c.setCategory(rs.getString("category"));

				return c;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(int id) {
		String sql = String.format(getSql(DELETE), id);
		updateSql(sql);
	}

	public void update(int id, String category) {
		String sql = String.format(getSql(UPDATE), category, id);
		updateSql(sql);
	}
	
	private void updateSql(String sql) {
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement()) {

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
