package com.jdc.payroll.db.entity;

import java.sql.ResultSet;
import java.util.Date;

import com.jdc.db.Entity;
import com.jdc.db.Param;

public class Calendar implements Entity {

	@Override
	public Param getIdParam() {
		return Param.getInstance().put("holiday", holiday)
				.put("holiday_type", holiday_type)
				.put("description", description);
	}

	@Override
	public Param getInsertParams() {
		return Param.getInstance().put("id", id);
	}

	public static Calendar convert(ResultSet rs) {
		Calendar c = null;
		try {
			c = new Calendar();
			c.setId(rs.getInt("id"));
			c.setHoliday_type(rs.getString("holiday_type"));
			c.setDescription(rs.getString("description"));
			c.setHoliday(Entity.getJavaDate(rs.getDate("holiday")));
		} catch (Exception e) {

		}
		return c;

	}

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
