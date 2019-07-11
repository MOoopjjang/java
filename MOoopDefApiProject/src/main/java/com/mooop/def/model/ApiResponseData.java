package com.mooop.def.model;

import lombok.Data;

@Data
public class ApiResponseData<T> {
	
	private String result;
	
	private T responseData;

}
