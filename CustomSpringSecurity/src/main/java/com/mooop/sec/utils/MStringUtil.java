package com.mooop.sec.utils;

public class MStringUtil {
	
	
	private MStringUtil() {}
	
	
	public static String defaultEmptyString(String org , String defaultString) {
		if(org == null || org.length() == 0) {
			return defaultString;
		}
		return org;
	}

}
