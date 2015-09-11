package com.jdc.payroll.db.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.db.DbHelper;
import com.jdc.db.Model;
import com.jdc.db.Param;
import com.jdc.payroll.db.entity.Employee;
import com.jdc.payroll.db.entity.Position;

public class EmployeeDaoTest {
	
	Model<Employee> model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// truncate tables
		DbHelper.truncateTables(TableAssist.getTables());
		
		// create position for test
		Model<Position> pModel = Model.getModel(Position.class, Position::convert);
		Position p = new Position();
		p.setPosition_cd("PO001");
		p.setDescription("Team Leader");
		pModel.create(p);
	}

	@Before
	public void setUp() throws Exception {
		model = Model.getModel(Employee.class, Employee::convert);
	}

	@Test
	public void test1() {
		Employee e = new Employee();
		e.setName("Mg Mg");
		e.setEmp_cd("E001");
		e.setPosition_cd("PO001");
		model.create(e);
		
		List<Employee> list = model.getAll();
		assertEquals(1, list.size());
	}
	
	@Test
	public void test2() {
		// find by id
		Employee e = model.findById(Param.getInstance().put("emp_cd", "E001"));
		assertEquals("Mg Mg", e.getName());
		assertEquals("PO001", e.getPosition_cd());
	}
	
	@Test
	public void test3() {
		// update
		model.update("name = ?", "emp_cd = ?", Arrays.asList("Ag Ag", "E001"));
		Employee e = model.findById(Param.getInstance().put("emp_cd", "E001"));
		assertEquals("Ag Ag", e.getName());
	}
	
	@Test
	public void test4() {
		// get where
		List<Employee> list = model.getWhere("name like ?", Arrays.asList("A%"));
		assertEquals(1, list.size());
	}
	
	@Test
	public void test5() {
		// delete
		model.delete("emp_cd = ?", Arrays.asList("E001"));
		assertNull(model.findById(Param.getInstance().put("emp_cd", "E001")));
	}

}
