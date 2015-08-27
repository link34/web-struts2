package com.jdc.skill.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee implements Entity{
	
	private int employee_id;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String memo;

	@Override
	public Param getId() {
		return Param.getInstance().put("employee_id", employee_id);
	}
	@Override
	public Param getInsertParams() {
		return Param.getInstance()
				.put("name", name)
				.put("phone", phone)
				.put("email", email)
				.put("address", address)
				.put("memo", memo);
	}
	
	public static Employee convert(ResultSet rs) {
		Employee e = null;
		
		try {
			e = new Employee();
			e.setEmployee_id(rs.getInt("employee_id"));
			e.setName(rs.getString("name"));
			e.setAddress(rs.getString("address"));
			e.setEmail(rs.getString("email"));
			e.setMemo(rs.getString("memo"));
			e.setPhone(rs.getString("phone"));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return e;
	}
	
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}


}
