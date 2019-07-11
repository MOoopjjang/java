package com.mooop.def.service;

import java.util.List;
import java.util.Map;

public interface MemberService {
	
	public List<Map<String , Object>> getAllUserInfo() throws Exception;
	
	public Map<String , Object> getUserInfo(String name , int age) throws Exception;
	
	public void deleteUserInfo(String name , int age) throws Exception;
	
	
//	public void updateUserInfo(String userid) throws Exception;

}
