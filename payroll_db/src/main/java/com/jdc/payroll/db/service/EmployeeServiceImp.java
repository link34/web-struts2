package com.jdc.payroll.db.service;

import java.util.Arrays;
import java.util.List;

import com.jdc.db.BaseModel;
import com.jdc.db.Model;
import com.jdc.db.Param;
import com.jdc.payroll.db.entity.Employee;

public class EmployeeServiceImp implements EmployeeService {

	private Model<Employee> model;
	
	public EmployeeServiceImp() {
		model = new BaseModel<Employee>(Employee.class, Employee::convert);
	}
	
	@Override
	public void create(Employee e) {
		model.create(e);
	}

	@Override
	public Employee findById(String emp_cd) {
		return model.findById(Param.getInstance().put("emp_cd", emp_cd));
	}

	@Override
	public List<Employee> findByName(String name) {
		return model.getWhere("name = ?", Arrays.asList(name));
	}

	@Override
	public List<Employee> getAllOrderByName() {
		return model.getAll();
	}

}
