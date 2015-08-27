package com.jdc.skill.dao;

import java.io.IOException;
import java.util.List;

import com.jdc.skill.data.Category;

public class CategoryDao extends Dao implements Model<Category> {

	private static String GET_ALL_SQL = "sql.category.selectAll";
	private static String INSERT = "sql.category.insert";
	private static String FIND_BY_ID = "sql.category.findById";
	private static String UPDATE = "sql.category.update";
	private static String DELETE = "sql.category.delete";

	public CategoryDao() throws IOException {
		super();
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Category t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String set, String where, List<Object> param) {
		// TODO Auto-generated method stub
		
	}

}
