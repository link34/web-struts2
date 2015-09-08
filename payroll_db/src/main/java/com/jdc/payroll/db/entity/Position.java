package com.jdc.payroll.db.entity;

import java.sql.ResultSet;

import com.jdc.db.Entity;
import com.jdc.db.Param;

public class Position implements Entity{
	
	@Override
	public Param getIdParam() {
		return Param.getInstance().put("position_cd",position_cd );
	}

	@Override
	public Param getInsertParams() {
		return Param.getInstance()
				.put("position_cd",position_cd )
				.put("description", description);
	}
	
	public static Position convert(ResultSet rs){
		Position p=null;
		try {
			p=new Position();
			p.setPosition_cd(rs.getString("position_cd"));
			p.setDescription(rs.getString("description"));
			
		} catch (Exception e) {
			
		}
		return p;
	}
	private String position_cd;
	private String description;

	public String getPosition_cd() {
		return position_cd;
	}

	public void setPosition_cd(String position_cd) {
		this.position_cd = position_cd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
