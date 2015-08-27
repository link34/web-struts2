package com.jdc.skill.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.jdc.skill.data.Category;

public class CategoryDaoTest {
	
	Model<Category> dao;
	
	@BeforeClass
	public static void init() throws IOException {
		
		DbHelper db = new DbHelper();
		db.truncateTables("category");
	}

	@Before
	public void setUp() throws Exception {
		dao = new BaseModel<Category>(Category.class, Category::convert);
	}
	
	@Test
	public void test1() {
		List<Category> list = dao.getAll();
		assertEquals(0, list.size());
	}
	
	@Test
	public void test2() {
		Category c = new Category();
		c.setCategory("Test Category");
		
		dao.create(c);
		
		List<Category> list = dao.getAll();
		assertEquals(1, list.size());
		
		Category result = list.get(list.size() -1);
		assertEquals(c.getCategory(), result.getCategory());
	}
	
	@Ignore
	@Test
	public void test3() {
		
		Category c = dao.findById(1);
		assertNotNull(c);
		
		assertEquals("Test Category", c.getCategory());
		
	}
	
	@Ignore
	@Test
	public void test4() {
//s		dao.update(1, "New Category");
		
		Category c = dao.findById(1);
		assertNotNull(c);
		
		assertEquals("New Category", c.getCategory());
	}

}
