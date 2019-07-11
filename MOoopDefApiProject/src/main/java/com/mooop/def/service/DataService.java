package com.mooop.def.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.mooop.def.model.RequestInsertUserDataParam;


public interface DataService {
	
	
//	public List<Map<String , Object>> getAllUserData() throws Exception;
	
	public CompletableFuture<List<Map<String , Object>>> getAllUserData() throws Exception;
	
	public Map<String , Object> getUserData(String name , int age) throws Exception;
	
	public void deleteUserData(String name , int age) throws Exception;
	
	public void updateUserData(RequestInsertUserDataParam newData) throws Exception;

}
