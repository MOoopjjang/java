package com.mooop.sec.service;

import java.util.Map;

public interface DbService {
	
	
	public Map<String , Object> getUserAuthInfo(String userid) throws Exception;
	
	public void insertUserInfo(Map<String , Object> params ) throws Exception;

}
