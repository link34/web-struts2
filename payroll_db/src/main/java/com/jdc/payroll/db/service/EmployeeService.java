package com.jdc.payroll.db.service;

import java.util.List;

import com.jdc.payroll.db.entity.Employee;

public interface EmployeeService {
	
	void create(Employee e);
	Employee findById(String emp_cd);
	List<Employee> findByName(String name);
	List<Employee> getAllOrderByName();

}
