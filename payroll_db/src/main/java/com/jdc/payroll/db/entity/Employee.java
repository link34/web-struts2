package com.jdc.payroll.db.entity;

import java.util.Date;

public class Employee {
	private String emp_cd;
	private String position_cd;
	private String name;
	private Date dob;
	private int gender;
	private String nrc;
	private String religious;
	private Date employed_date;
	private String organization;
	private String education;
	private String qualification;
	private String phone;
	private String mail;
	private String address;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getReligious() {
		return religious;
	}
	public void setReligious(String religious) {
		this.religious = religious;
	}
	public Date getEmployed_date() {
		return employed_date;
	}
	public void setEmployed_date(Date employed_date) {
		this.employed_date = employed_date;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
