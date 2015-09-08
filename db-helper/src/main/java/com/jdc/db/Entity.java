package com.jdc.db;

import java.sql.Date;
import java.sql.Timestamp;

public interface Entity {
	Param getIdParam();
	Param getInsertParams();
	
	public default Date getDate(java.util.Date date) {
		if(null != date)
			return new Date(date.getTime());
		return null;
	}
	
	public default Timestamp getTimeStamp(java.util.Date date) {
		if(null != date)
			return new Timestamp(date.getTime());
		return null;
	}
	
	public static java.util.Date getJavaDate(Date date) {
		if(null != date)
			return new java.util.Date(date.getTime());
		return null;
	}
	
	public static java.util.Date getJavaDate(Timestamp date) {
		if(null != date)
			return new java.util.Date(date.getTime());
		return null;
	}
}
