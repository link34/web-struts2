package com.jdc.skill.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.skill.data.Employee;

public class EmployeeTest {

	private Model<Employee> model;
	
	@BeforeClass
	public static void start() {
		DbHelper db = new DbHelper();
		db.truncateTables("employee");
	}

	@Before
	public void setUp() throws Exception {
		model = new BaseModel<Employee>(Employee.class, Employee::convert);
	}

	@Test
	public void test1() {
		Employee e = new Employee();
		e.setName("Aung Aung");
		e.setAddress("Yangon");
		
		model.create(e);
		
		List<Employee> list = model.getAll();
		assertEquals(1, list.size());
		
		Employee result = list.get(0);
		assertEquals("Aung Aung", result.getName());
		assertEquals("Yangon", result.getAddress());
	}

}
