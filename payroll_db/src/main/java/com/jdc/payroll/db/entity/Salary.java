package com.jdc.payroll.db.entity;

import java.util.Date;

import com.jdc.db.GeneratedEntity;
import com.jdc.db.Param;

public class Salary implements GeneratedEntity{
	private int id;
	private String emp_cd;
	private String position_cd;
	private float basic;
	private float allowance;
	private Date start_date;
	private Date end_date;

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

	public String getPosition_cd() {
		return position_cd;
	}

	public void setPosition_cd(String position_cd) {
		this.position_cd = position_cd;
	}

	public float getBasic() {
		return basic;
	}

	public void setBasic(float basic) {
		this.basic = basic;
	}

	public float getAllowance() {
		return allowance;
	}

	public void setAllowance(float allowance) {
		this.allowance = allowance;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
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
