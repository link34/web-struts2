package com.jdc.payroll.db.entity;

public class Leave {
	private int id;
	private String leave_type;
	private float leave_days;
	private String description;
	public int getId() {
		return id;
	}
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
