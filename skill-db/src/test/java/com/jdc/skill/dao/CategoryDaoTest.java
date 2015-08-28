package com.jdc.skill.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.skill.data.Category;
import com.jdc.skill.data.Param;

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
	
	@Test
	public void test3() {
		
		Category c = dao.findById(Param.getInstance().put("category_id", 1));
		assertNotNull(c);
		
		assertEquals("Test Category", c.getCategory());
		
	}
	
	@Test
	public void test4() {
		dao.update("category = ?", "category_id = ?", Arrays.asList("New Category", 1));
		
		Category c = dao.findById(Param.getInstance().put("category_id", 1));
		assertNotNull(c);
		
		assertEquals("New Category", c.getCategory());
	}
	
	@Test
	public void test5() {
		dao.delete("category_id = ?", Arrays.asList(1));
		Category c = dao.findById(Param.getInstance().put("category_id", 1));
		
		assertNull(c);
	}
	
	@Test
	public void test6() {
		List<Category> list = getTestData(10);
		for(Category c : list) {
			dao.create(c);
		}
		
		List<Category> result = dao.getWhere("category = ?", Arrays.asList("Category 3"));
		assertEquals(1, result.size());
		assertEquals("Category 3", result.get(0).getCategory());
	}
	
	private List<Category> getTestData(int count) {
		List<Category> list = new ArrayList<Category>();
		
		for(int i = 0; i < count; i ++) {
			Category c = new Category();
			c.setCategory("Category " + (i + 1));
			list.add(c);
		}
		return list;
	}

}
