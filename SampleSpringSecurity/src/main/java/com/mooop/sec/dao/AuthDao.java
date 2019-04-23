package com.mooop.sec.dao;

import java.util.List;
import java.util.Map;

public interface AuthDao {
	
	/** 사용자 정보를 가져온다. */
	public Map<String , Object> getUserAuthInfo(String userid) throws Exception;
	/** 모든 사용자 정보를 가져온다 */
	public List<Map<String , Object>> getAllUserAuthInfo() throws Exception;
	/** 사용자 정보를 추가한다 */
	public void insertUserInfo(Map<String , Object> params ) throws Exception;
	/** 사용자 정보를 삭제한다 */
	public void deleteUserInfo(String userid) throws Exception;

}
