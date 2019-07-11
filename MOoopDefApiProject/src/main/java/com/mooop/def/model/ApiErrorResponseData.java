package com.mooop.def.model;

import lombok.Data;

@Data
public class ApiErrorResponseData {
	
	private String result;
	
	private String reason;
	
	private String code;

}
