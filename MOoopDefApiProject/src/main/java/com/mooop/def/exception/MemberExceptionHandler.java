package com.mooop.def.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mooop.def.constants.MemberError;
import com.mooop.def.model.ApiErrorResponseData;

@ControllerAdvice
public class MemberExceptionHandler {
	
	
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<ApiErrorResponseData> handleException(MemberException ex){
		
		ApiErrorResponseData res = new ApiErrorResponseData();
		res.setCode(ex.getErrorCode());
		res.setReason(ex.getMessage());
		return new ResponseEntity<ApiErrorResponseData>(res , HttpStatus.OK);
	}

}
