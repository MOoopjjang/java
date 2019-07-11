package com.mooop.def.exception;


/**
 * 
 * Custom Exception 
 * 
 * @author MOoop
 *
 */
public class MemberException extends Exception{

	private String error_code;
	public MemberException() {
		super();
	}
	
	
	public MemberException(String error_code , String error_msg) {
		super( error_msg );
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
