package com.jdc.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import javax.sql.DataSource;

public class BaseModel<T extends Entity> implements Model<T>{
	
	private Class<T> entity;
	private Properties props;
	private Function<ResultSet, T> converter;
	private DataSource ds;
	
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

	public BaseModel(Class<T> entity, Function<ResultSet, T> converter, DataSource ds, InputStream configuration) {
		this.ds = ds;
		this.entity = entity;
		this.converter = converter;
		try {
			props = new Properties();
			props.load(configuration);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<T> getAll() {
		String sql = String.format(getSql("sql.selectAll"), getTableName());
		List<T> list = new ArrayList<>();
		
		try(Connection conn = getConnection();
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
		
		try(Connection conn = getConnection();
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

	
	private String getSql(String id) {
		return props.getProperty(id);
	}
	

	@Override
	public T findById(Param id) {
		// set sql
		String sql = String.format(getSql("sql.findById"), getTableName(), id.getKeyString());
		
		try(Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			List<Object> params = id.getValues();
			// set params
			for(int i=0; i < params.size(); i++) {
				stmt.setObject(i + 1, params.get(i));
			}
			
			// execute sql
			ResultSet rs = stmt.executeQuery();
			
			// get results
			while(rs.next()) {
				return converter.apply(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(String where, List<Object> params) {
		String sql = String.format(getSql("sql.delete"), getTableName(), where);
		
		try(Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			// set params
			for(int i=0; i < params.size(); i++) {
				stmt.setObject(i + 1, params.get(i));
			}
			
			// execute sql
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void update(String set, String where, List<Object> params) {
		String sql = String.format(getSql("sql.update"), getTableName(), set, where);
		
		try(Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			// set params
			for(int i=0; i < params.size(); i++) {
				stmt.setObject(i + 1, params.get(i));
			}
			
			// execute sql
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<T> getWhere(String where, List<Object> params) {
		String sql = String.format(getSql("sql.getWhere"), getTableName(), where);
		List<T> list = new ArrayList<>();
		
		try(Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			// set params
			for(int i=0; i < params.size(); i++) {
				stmt.setObject(i + 1, params.get(i));
			}
			
			// execute query
			ResultSet rs = stmt.executeQuery();
			
			// get result
			while(rs.next()) {
				list.add(converter.apply(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	private String getTableName() {
		return entity.getSimpleName().toLowerCase();
	}
	
	private Connection getConnection() throws SQLException {
		if(null != ds) {
			return ds.getConnection();
		}
		
		return ConnectionManager.getConnection();
	}

}
