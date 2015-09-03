package com.jdc.skill.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.skill.entity.Employee;

public class EmployeeModel {
	
	private DataSource ds;
	
	public EmployeeModel(DataSource ds) {
		this.ds = ds;
	}
	
	public void create(Employee emp) {
		// insert sql
		String sql = "insert into employee(name, email, phone, address, memo) values (?, ?, ?, ?, ?)";
		
		// get connection and create statement
		try(Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			// set parameter of statement from emp object
			stmt.setObject(1, emp.getName());
			stmt.setObject(2, emp.getEmail());
			stmt.setObject(3, emp.getPhone());
			stmt.setObject(4, emp.getAddress());
			stmt.setObject(5, emp.getMemo());
			
			// execute update
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> getAll() {
		
		String sql = "select * from employee";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			List<Employee> list = new ArrayList<Employee>();
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setAddress(rs.getString("address"));
				emp.setEmail(rs.getString("email"));
				emp.setEmployee_id(rs.getInt("employee_id"));
				emp.setMemo(rs.getString("memo"));
				emp.setName(rs.getString("name"));
				emp.setPhone(rs.getString("phone"));
				
				list.add(emp);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
