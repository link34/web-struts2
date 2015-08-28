package com.jdc.skill.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee_skill implements Entity{
	
	private int employee_id;
	private int skill_id;
	private int level;
	
	public static Employee_skill convert(ResultSet rs) {
		Employee_skill es = null;
		
		try {
			es = new Employee_skill();
			es.setEmployee_id(rs.getInt("employee_id"));
			es.setLevel(rs.getInt("level"));
			es.setSkill_id(rs.getInt("skill_id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return es;
	}
	
	
	@Override
	public Param getId() {
		return Param.getInstance().put("employee_id", employee_id).put("skill_id", skill_id);
	}

	@Override
	public Param getInsertParams() {
		return getId().put("level", level);
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	

}
