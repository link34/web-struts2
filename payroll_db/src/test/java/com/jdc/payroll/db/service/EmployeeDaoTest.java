package com.jdc.payroll.db.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.db.DbHelper;
import com.jdc.db.Model;
import com.jdc.payroll.db.entity.Employee;
import com.jdc.payroll.db.entity.Position;

public class EmployeeDaoTest {
	
	Model<Employee> model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DbHelper.truncateTables(TableAssist.getTables());
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

}
