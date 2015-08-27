package com.jdc.skill.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Category implements Entity{

	private int category_id;
	private String category;

	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public static Category convert(ResultSet rs) {
		Category c = null;
		try {
			c = new Category();
			c.setCategory_id(rs.getInt("category_id"));
			c.setCategory(rs.getString("category"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public Param getId() {
		return Param.getInstance().put("category_id", category_id);
	}
	@Override
	public Param getInsertParams() {
		return Param.getInstance().put("category", category);
	}
	
}
