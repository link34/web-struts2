package com.jdc.payroll.db.entity;

import java.util.Date;

public class Claendar {
	private int id;
	private Date holiday;
	private String holiday_type;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getHoliday() {
		return holiday;
	}
	public void setHoliday(Date holiday) {
		this.holiday = holiday;
	}
	public String getHoliday_type() {
		return holiday_type;
	}
	public void setHoliday_type(String holiday_type) {
		this.holiday_type = holiday_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
