package com.jdc.db;

import java.sql.Date;
import java.sql.Timestamp;

public interface Entity {
	Param getIdParam();
	Param getInsertParams();
	
	public default Date getDate(java.util.Date date) {
		return new Date(date.getTime());
	}
	
	public default Timestamp getTimeStamp(java.util.Date date) {
		return new Timestamp(date.getTime());
	}
	
	public static java.util.Date getJavaDate(Date date) {
		return new java.util.Date(date.getTime());
	}
	
	public static java.util.Date getJavaDate(Timestamp date) {
		return new java.util.Date(date.getTime());
	}
}
