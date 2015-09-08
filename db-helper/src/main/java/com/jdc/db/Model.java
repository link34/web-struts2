package com.jdc.db;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.List;
import java.util.function.Function;

import javax.sql.DataSource;

public interface Model<T extends Entity> {

	List<T> getAll();

	void create(T t);

	void delete(String where, List<Object> params);

	T findById(Param id);

	void update(String set, String where, List<Object> params);

	List<T> getWhere(String where, List<Object> params);

	public static <T extends Entity> Model<T> getModel(Class<T> entity,
			Function<ResultSet, T> converter) {
		return new BaseModel<T>(entity, converter);
	}

	public static <T extends Entity> Model<T> getModel(Class<T> entity,
			Function<ResultSet, T> converter, DataSource ds,
			InputStream configuration) {
		return new BaseModel<T>(entity, converter, ds, configuration);
	}
}
