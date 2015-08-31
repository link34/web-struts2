package com.jdc.skill.model;

import java.util.List;

import javax.sql.DataSource;

import com.jdc.skill.entity.Employee;

public class EmployeeModel {
	
	private DataSource ds;
	
	public EmployeeModel(DataSource ds) {
		this.ds = ds;
	}
	
	public void create(Employee emp) {

	}
	
	public List<Employee> getAll() {
		

		
		return null;
	}

}
