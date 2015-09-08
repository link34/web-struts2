package com.jdc.payroll.db.entity;

import java.util.Date;

import com.jdc.db.GeneratedEntity;
import com.jdc.db.Param;

public class Request_info implements GeneratedEntity{
	private int id;
	private Date req_date;
	private String emp_cd;
	private int request_id;
	private float amount;
	private Date use_date;
	private Date pay_date;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getReq_date() {
		return req_date;
	}

	public void setReq_date(Date req_date) {
		this.req_date = req_date;
	}

	public String getEmp_cd() {
		return emp_cd;
	}

	public void setEmp_cd(String emp_cd) {
		this.emp_cd = emp_cd;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getUse_date() {
		return use_date;
	}

	public void setUse_date(Date use_date) {
		this.use_date = use_date;
	}

	public Date getPay_date() {
		return pay_date;
	}

	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
