package com.jdc.payroll.db.entity;

import java.sql.ResultSet;

import com.jdc.db.GeneratedEntity;
import com.jdc.db.Param;

public class Leave implements GeneratedEntity{
	
	@Override
	public Param getIdParam() {
		return Param.getInstance().put("id", id);
	}
	@Override
	public Param getInsertParams() {
		return Param.getInstance()
				.put("leave_type",leave_type )
				.put("leave_days",leave_days )
				.put("description",description );
	}
	
	public static Leave convert(ResultSet rs)
	{
		Leave l=null;
		try {
			
			l=new Leave();
			l.setId(rs.getInt("id"));
			l.setLeave_type(rs.getString("leave_type"));
			l.setLeave_days(rs.getFloat("leave_days"));
			l.setDescription(rs.getString("description"));
			
		} catch (Exception e) {
			
		}
		return l;
	}
	private int id;
	private String leave_type;
	private float leave_days;
	private String description;
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	public float getLeave_days() {
		return leave_days;
	}
	public void setLeave_days(float leave_days) {
		this.leave_days = leave_days;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
