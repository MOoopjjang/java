package com.mooop.def.utils;

import java.util.List;
import java.util.Map;

public class MStringUtil {
	
	private MStringUtil() {}
	
	
	/**
	 * 
	 * 객체의 유효성 체크
	 * 
	 * @param value
	 * @return
	 */
	public static boolean validCheck(Object value) {
		
		
		boolean isValid = true;
		
		if(value == null) {
			return false;
		}
		
		if(value instanceof String) {
			String org = (String)value;
			if("".equals(org.trim()) || org.trim().length() == 0) {
				isValid = false;
			}
		}else if(value instanceof List) {
			List org = (List) value;
			if(!org.isEmpty()) {
				isValid = false;
			}
		}else if(value instanceof Map) {
			Map org = (Map) value;
			if(!org.isEmpty()) {
				isValid = false;
			}
		}else if(value instanceof String[]) {
			String[] org = (String[])value;
			if(org.length == 0) {
				isValid = false;
			}
		}
		
		
		return isValid;
	}

}
