package com.mooop.def.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mooop.def.model.ApiErrorResponseData;

@ControllerAdvice
public class DataExceptionHandler {
	
	@ExceptionHandler(DataException.class)
	public ResponseEntity<ApiErrorResponseData> handleException(DataException ex){
		
		ApiErrorResponseData resErr = new ApiErrorResponseData();
		resErr.setCode(ex.getErrorCode());
		resErr.setReason(ex.getMessage());
		return new ResponseEntity<>(resErr , HttpStatus.OK);
	}

}
