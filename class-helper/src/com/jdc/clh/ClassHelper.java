package com.jdc.clh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ClassHelper {
	
	static final String FORMAT = "private %s %s;%n";
	
	public static void main(String[] args) throws IOException {
		List<String> list = Files.readAllLines(Paths.get("data"));
		list.stream()
			.map(line -> line.trim().split(","))
			.map(ClassHelper::getMemberString)
			.forEach(System.out::print);
	}
	
	public static String getType(String sqlType) {
		
		for(DataType t : DataType.values()) {
			if(sqlType.startsWith(t.getSqlType())) {
				return t.getJavaType();
			}
		}
		
		return null;
	}
	
	public static String getMemberString(String [] array) {
		String type = getType(array[1].trim());
		String name = array[0].trim();
		return String.format(FORMAT, type, name);
	}
	
	

}
