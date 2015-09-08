package com.jdc.payroll.db.entity;

import com.jdc.db.GeneratedEntity;
import com.jdc.db.Param;

public class Salary_info implements GeneratedEntity{
	private int id;
	private String emp_cd;
	private String base_month;
	private float salary;
	private float ot_fees;
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmp_cd() {
		return emp_cd;
	}

	public void setEmp_cd(String emp_cd) {
		this.emp_cd = emp_cd;
	}

	public String getBase_month() {
		return base_month;
	}

	public void setBase_month(String base_month) {
		this.base_month = base_month;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getOt_fees() {
		return ot_fees;
	}

	public void setOt_fees(float ot_fees) {
		this.ot_fees = ot_fees;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
