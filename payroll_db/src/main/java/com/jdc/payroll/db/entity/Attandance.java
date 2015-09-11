package com.jdc.payroll.db.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jdc.db.Entity;
import com.jdc.db.GeneratedEntity;
import com.jdc.db.Param;
import com.jdc.payroll.db.common.PayrollDBException;

public class Attandance implements GeneratedEntity {

	@Override
	public Param getInsertParams() {
		return Param.getInstance().put("emp_cd", att_date)
				.put("att_date", att_date).put("start_time", start_time)
				.put("end_time", end_time);
	}

	@Override
	public Param getIdParam() {
		return Param.getInstance().put("id", id);
	}

	public static Attandance convert(ResultSet rs) {
		Attandance a = null;
		try {
			a = new Attandance();
			a.setAtt_date(Entity.getJavaDate(rs.getDate("att_date")));
			a.setEmp_cd(rs.getString("emp_cd"));
			a.setEnd_time(Entity.getJavaDate(rs.getTimestamp("end_time")));
			a.setId(rs.getInt("id"));
			a.setStart_time(Entity.getJavaDate(rs.getTimestamp("start_time")));
		} catch (SQLException e) {
			throw new PayrollDBException(e);
		}
		return a;
	}

	private int id;
	private String emp_cd;
	private Date att_date;
	private Date start_time;
	private Date end_time;

	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getEmp_cd() {
		return emp_cd;
	}

	public void setEmp_cd(String emp_cd) {
		this.emp_cd = emp_cd;
	}

	public Date getAtt_date() {
		return att_date;
	}

	public void setAtt_date(Date att_date) {
		this.att_date = att_date;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

}
