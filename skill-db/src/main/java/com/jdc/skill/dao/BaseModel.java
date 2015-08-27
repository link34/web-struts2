package com.jdc.skill.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import com.jdc.skill.data.Entity;

public class BaseModel<T extends Entity> implements Model<T>{
	
	private Class<T> entity;
	private Properties props;
	private Function<ResultSet, T> converter;
	
	public BaseModel(Class<T> entity, Function<ResultSet, T> converter) {
		this.entity = entity;
		this.converter = converter;
		props = new Properties();
		try {
			props.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<T> getAll() {
		String sql = String.format(getSql("sql.selectAll"), getTableName());
		List<T> list = new ArrayList<>();
		
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(converter.apply(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void create(T t) {
		String sql = String.format(getSql("sql.insert"), 
				getTableName(), 
				t.getInsertParams().getInsertString());
		
		System.out.println(sql);
		
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			List<Object> params = t.getInsertParams().getValues();
			
			for(int i = 0; i < params.size(); i++) {
				stmt.setObject(i + 1, params.get(i));
			}
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String set, String where, List<Object> param) {
		// TODO Auto-generated method stub
		
	}
	
	private String getSql(String id) {
		return props.getProperty(id);
	}
	
	private String getTableName() {
		return entity.getSimpleName().toLowerCase();
	}

}
