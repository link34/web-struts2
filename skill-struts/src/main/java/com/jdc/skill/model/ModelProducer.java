package com.jdc.skill.model;

import java.io.InputStream;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.jdc.skill.dao.BaseModel;
import com.jdc.skill.dao.Model;
import com.jdc.skill.data.Employee;
import com.jdc.skill.listener.DbConfiguration;
import com.jdc.skill.listener.DbResourse;

public class ModelProducer {
	
	@Inject
	@DbResourse
	private DataSource ds;
	@Inject
	@DbConfiguration
	private InputStream dbConfig;
	
	@Produces
	@DataModel(Employee.class)
	public Model<Employee> getEmployeeModel() {
		return new BaseModel<Employee>(Employee.class, Employee::convert, ds, dbConfig);
	}

}
