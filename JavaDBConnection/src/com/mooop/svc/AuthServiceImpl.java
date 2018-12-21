package com.mooop.svc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


public class AuthServiceImpl implements AuthService{
	private SqlSession session;
	
	public AuthServiceImpl( SqlSession session){
		this.session = session;
	}

	@Override
	public Map<String, Object> getUserAuthInfo(String userid) throws Exception {
		return session.selectOne("getUserAuthInfo", userid);
	}

	@Override
	public List<Map<String, Object>> getAllUserAuthInfo() throws Exception {
		return session.selectList("getAllUserAuthInfo");
	}

	@Override
	public void insertUserInfo(Map<String, Object> params) throws Exception {
		session.insert("insertUserInfo", params);
		session.commit();
	}

	@Override
	public void deleteUserInfo(String userid) throws Exception {
		session.delete("deleteUserInfo" , userid);
		session.commit();
	}

}
