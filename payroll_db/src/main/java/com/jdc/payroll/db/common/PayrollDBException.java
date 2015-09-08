package com.jdc.payroll.db.common;

public class PayrollDBException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public PayrollDBException(String message) {
		super(message);
	}
	
	public PayrollDBException(Throwable e) {
		super(e);
	}

}
