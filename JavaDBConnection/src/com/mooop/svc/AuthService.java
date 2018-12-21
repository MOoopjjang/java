package com.mooop.svc;

import java.util.List;
import java.util.Map;

public interface AuthService {
	
	public Map<String , Object> getUserAuthInfo(String userid) throws Exception;
	
	public List<Map<String , Object>> getAllUserAuthInfo() throws Exception;
	
	public void insertUserInfo(Map<String , Object> params ) throws Exception;
	
	public void deleteUserInfo(String userid) throws Exception;

}
