package com.jdc.skill.dao;

import java.util.List;

import com.jdc.skill.data.Entity;

public interface Model<T extends Entity> {
	
	List<T> getAll();
	void create(T t);
	void delete(Object id);
	T findById(Object id);
	void update(String set, String where, List<Object> param);

}
