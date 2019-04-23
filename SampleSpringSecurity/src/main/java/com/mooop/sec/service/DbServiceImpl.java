package com.mooop.sec.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mooop.sec.dao.AuthDao;

@Component
public class DbServiceImpl implements DbService{
	
	
	@Autowired
	private AuthDao authDao;

	@Override
	public Map<String , Object> getUserAuthInfo(String userid) throws Exception {
		return authDao.getUserAuthInfo(userid);
	}

}
