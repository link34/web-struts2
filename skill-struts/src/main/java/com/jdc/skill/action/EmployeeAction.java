package com.jdc.skill.action;

import java.util.List;

import javax.inject.Inject;

import com.jdc.skill.dao.Model;
import com.jdc.skill.data.Employee;
import com.jdc.skill.model.DataModel;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<Employee> list;
	
	@Inject
	@DataModel(Employee.class)
	private Model<Employee> empModel;
	
	public String welcome() {
		
		list = empModel.getAll();
		
		return "welcome";
	}

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

}
