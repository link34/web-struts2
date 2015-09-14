package com.jdc.payroll.db.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jdc.db.DbHelper;
import com.jdc.db.Model;
import com.jdc.db.Param;
import com.jdc.payroll.db.entity.Position;

public class PositionDaoTest {
	Model<Position> model;

	public static void setUpBeforeClass() throws Exception {
		DbHelper.truncateTables(TableAssist.getTables());
	}

	@Before
	public void setUpClass() throws Exception {
		model = Model.getModel(Position.class, Position::convert);

	}

	@Test
	public void test1() {
		Position p = new Position();
		p.setPosition_cd("PO001");
		p.setDescription("Manager");

		model.create(p);

		List<Position> list = model.getAll();
		assertEquals(1, list.size());
	}

	@Test
	public void test2() {
		Position p = model.findById(Param.getInstance().put("position_cd", "PO001"));
		assertEquals("Manager", p.getDescription());

	}

	@Test
	public void test3() {
		model.update("description = ?", "position_cd = ?", Arrays.asList("Director", "PO001"));
		Position p = model.findById(Param.getInstance().put("position_cd", "PO001"));
		assertEquals("Director", p.getDescription());

	}

	@Test
	public void test4() {
		List<Position> list = model.getWhere("description like ?", Arrays.asList("D%"));
		assertEquals(1, list.size());
	}
	
	@Test
	public void test5(){
		model.delete("position_cd = ?", Arrays.asList("PO001"));
		assertNull(model.findById(Param.getInstance().put("position_cd", "PO001")));
		
	}
	

}
