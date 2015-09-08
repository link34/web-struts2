package com.jdc.clh;

public enum DataType {
	
	VARCHAR("varchar", "String"), 
	LONGTEXT("longtext", "String"),
	DATE("date", "Date"), 
	TIMESTAMP("timestamp", "Date"),
	FLOAT("float", "float"),
	INT("int", "int"),
	TINYINT("tinyint", "int");
	
	private String sqlType;
	private String javaType;
	
	private DataType(String sqlType, String javaType) {
		this.sqlType = sqlType;
		this.javaType = javaType;
	}

	public String getSqlType() {
		return sqlType;
	}

	public String getJavaType() {
		return javaType;
	}

}
