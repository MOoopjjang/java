package com.mooop.def.exception;

public class DataException extends Exception{
	
	private String error_code;
	
	public DataException() {
		super();
	}
	
	
	public DataException(String error_code , String error_msg) {
		super(error_msg);
		this.error_code = error_code;
	}
	
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	public String getErrorCode() {
		return this.error_code;
	}

}
