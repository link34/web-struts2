package com.jdc.payroll.db.entity;

import java.util.Date;

import com.jdc.db.GeneratedEntity;
import com.jdc.db.Param;

public class Transportation implements GeneratedEntity{
	private int id;
	private String emp_cd;
	private Date start_date;
	private String valid_flag;

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

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public String getValid_flag() {
		return valid_flag;
	}

	public void setValid_flag(String valid_flag) {
		this.valid_flag = valid_flag;
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
