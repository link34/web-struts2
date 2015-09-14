package com.jdc.payroll.db.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.db.DbHelper;
import com.jdc.db.Model;
import com.jdc.db.Param;
import com.jdc.payroll.db.entity.Leave;

public class LeaveDaoTest {
	Model<Leave> model;
	
	@BeforeClass
	public static void SetUpBeforeClass() throws Exception{
		
		DbHelper.truncateTables(TableAssist.getTables());
		
	}

	@Before
	public void setUpClass() throws Exception {
		model = Model.getModel(Leave.class, Leave::convert);

	}
	@Test
	public void test1() {
		Leave l = new Leave();
		l.setLeave_days(1);
		l.setLeave_type("MedicalLeave");
		l.setDescription("FullDay");
		model.create(l);

		List<Leave> list = model.getAll();
		assertEquals(1, list.size());
	}
	
	@Test
	public void test2() {
		Leave l = model.findById(Param.getInstance().put("id", "1"));
		assertEquals("FullDay", l.getDescription());

	}
	@Test
	public void test3() {
		model.update("description= ?", "id = ?", Arrays.asList("HalfDay", "1"));
		Leave l = model.findById(Param.getInstance().put("id", "1"));
		assertEquals("HalfDay", l.getDescription());

	}
	@Test
	public void test4() {
		List<Leave> list = model.getWhere("description like ?", Arrays.asList("H%"));
		assertEquals(1, list.size());
	}
	
	@Test
	public void test5(){
		model.delete("id = ?", Arrays.asList("1"));
		assertNull(model.findById(Param.getInstance().put("id", "1")));
		
	}
	


}
