package com.jdc.payroll.db.entity;

import java.util.Date;

import com.jdc.db.GeneratedEntity;
import com.jdc.db.Param;

public class Ot_info implements GeneratedEntity{
	private int id;
	private Date date;
	private String emp_cd;
	private Date ot_start;
	private Date ot_end;
	private float ot_time;
	private int confirm_flag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmp_cd() {
		return emp_cd;
	}

	public void setEmp_cd(String emp_cd) {
		this.emp_cd = emp_cd;
	}

	public Date getOt_start() {
		return ot_start;
	}

	public void setOt_start(Date ot_start) {
		this.ot_start = ot_start;
	}

	public Date getOt_end() {
		return ot_end;
	}

	public void setOt_end(Date ot_end) {
		this.ot_end = ot_end;
	}

	public float getOt_time() {
		return ot_time;
	}

	public void setOt_time(float ot_time) {
		this.ot_time = ot_time;
	}

	public int getConfirm_flag() {
		return confirm_flag;
	}

	public void setConfirm_flag(int confirm_flag) {
		this.confirm_flag = confirm_flag;
	}

	@Override
	public Param getIdParam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Param getInsertParams() {
		// TODO Auto-generated method stub
		return null;
	}
}
