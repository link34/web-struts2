package com.jdc.skill.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Skill implements Entity {

	@Override
	public Param getId() {
		return Param.getInstance().put("skill_id", skill_id);
	}

	@Override
	public Param getInsertParams() {
		return Param.getInstance().put("skill", skill)
				.put("category_id", category_id);
	}
	
	public static Skill convert(ResultSet rs) {
		Skill s = null;
		
		try {
			s = new Skill();
			s.setCategory_id(rs.getInt("category_id"));
			s.setSkill(rs.getString("skill"));
			s.setSkill_id(rs.getInt("skill_id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}

	private int skill_id;
	private String skill;
	private int category_id;

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

}
