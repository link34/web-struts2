package com.jdc.db;

import java.util.List;

public interface Model<T extends Entity> {
	
	List<T> getAll();
	void create(T t);
	void delete(String where, List<Object> params);
	T findById(Param id);
	void update(String set, String where, List<Object> params);
	List<T> getWhere(String where, List<Object> params);

}
