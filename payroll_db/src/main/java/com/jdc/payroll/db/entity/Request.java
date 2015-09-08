package com.jdc.payroll.db.entity;

import java.sql.ResultSet;

import com.jdc.db.Entity;
import com.jdc.db.Param;

public class Request implements Entity {

	@Override
	public Param getIdParam() {
		return Param.getInstance().put("name", name).put("type", type);
	}

	@Override
	public Param getInsertParams() {
		return Param.getInstance().put("id", id);
	}

	public static Request convery(ResultSet rs) {
		Request r = null;
		try {
			r = new Request();
			r.setId(rs.getInt("id"));
			r.setName(rs.getString("name"));
			r.setType(rs.getString("type"));

		} catch (Exception e) {
			
			
		}
		return r;

	}

	private int id;
	private String name;
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
