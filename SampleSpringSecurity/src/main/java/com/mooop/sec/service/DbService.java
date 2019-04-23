package com.mooop.sec.service;

import java.util.List;
import java.util.Map;

public interface DbService {
	
	
	public Map<String , Object> getUserAuthInfo(String userid) throws Exception;

}
