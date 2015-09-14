package com.jdc.payroll.db.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.db.DbHelper;
import com.jdc.db.Model;
import com.jdc.payroll.db.entity.Calendar;

public class CalendarDaoTest {
	
	Model<Calendar> model;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DbHelper.truncateTables(TableAssist.getTables());

	}

	@Before
	public void setUp() throws Exception {
		model = Model.getModel(Calendar.class, Calendar::convert);
	}

	@Test
	public void test1() throws ParseException {
		Calendar e = new Calendar();
		SimpleDateFormat df = new SimpleDateFormat("yyyy MMM dd");
		Date d = df.parse("2015-04-14");
		
		e.setHoliday(d);
		e.setHoliday_type("Thingyan");
		e.setDescription("Myanmar New Year!");
		model.create(e);
	}

}

