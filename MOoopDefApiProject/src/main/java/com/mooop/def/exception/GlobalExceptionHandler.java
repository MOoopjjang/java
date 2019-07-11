package com.mooop.def.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mooop.def.constants.GlobalError;
import com.mooop.def.model.ApiErrorResponseData;

/**
 * 
 * 전역적인 Exception Handler.
 * 
 * @author MOoop
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiErrorResponseData> handleException(Exception ex){
		ex.printStackTrace();
		ApiErrorResponseData res = new ApiErrorResponseData();
		res.setCode(GlobalError.GLOBAL_ERROR_1);
		res.setResult("FAILED");
		res.setReason(ex.toString());
		return new ResponseEntity<>(res , HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
