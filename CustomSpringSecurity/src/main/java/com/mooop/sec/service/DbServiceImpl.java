package com.mooop.sec.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mooop.sec.dao.AuthDao;
import com.mooop.sec.utils.BCryptUtils;

@Component
public class DbServiceImpl implements DbService{
	
	
	@Autowired
	private AuthDao authDao;

	@Override
	public Map<String , Object> getUserAuthInfo(String userid) throws Exception {
		return authDao.getUserAuthInfo(userid);
	}

	@Override
	public void insertUserInfo(Map<String, Object> params) throws Exception {
		
		String rawPassword = (String) params.get("password");
		/**
		 * DB에 저장하기전 암호화하여 저장한다
		 */
		params.put("password", BCryptUtils.getInstance().encode(rawPassword));
		authDao.insertUserInfo(params);
		
	}

}
