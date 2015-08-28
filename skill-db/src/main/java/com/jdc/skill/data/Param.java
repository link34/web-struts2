package com.jdc.skill.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Param {
	
	private Map<String, Object> params;
	
	private Param() {
		params = new LinkedHashMap<String, Object>();
	}
	
	public static Param getInstance() {
		return new Param();
	}
	
	public Param put(String key, Object value) {
		params.put(key, value);
		return this;
	}
	
	public String getInsertString() {
		StringBuilder sb = new StringBuilder();
		
		List<String> keys = new ArrayList<String>(params.keySet());
		
		sb.append("(");
		
		for (int i = 0; i < keys.size(); i++) {
			if(i > 0) {
				sb.append(", ");
			}
			
			sb.append(keys.get(i));
		}
		
		sb.append(")");

		sb.append(" values (");
		
		for (int i = 0; i < keys.size(); i++) {
			if( i > 0) {
				sb.append(", ");
			}
			
			sb.append("?");
		}
		
		sb.append(")");
		
		return sb.toString();
	}
	
	public List<Object> getValues() {
		return new ArrayList<Object>(params.values());
	}
	
	public String getKeyString() {
		StringBuilder sb = new StringBuilder();
		List<String> keys = new ArrayList<String>(params.keySet());
		
		sb.append("(");
		
		for (int i = 0; i < keys.size(); i++) {
			if(i > 0) {
				sb.append("and ");
			}
			
			sb.append(keys.get(i));
			
			sb.append(" = ?");
		}
		
		sb.append(")");
		
		return sb.toString();
	}
}
