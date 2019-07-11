package com.mooop.def.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mooop.def.model.UserParamVo;

@Component("userInfo")
public interface UserInfo {
	
	public List<Map<String , Object>> getAllUserInfo() throws Exception;
	
	public Map<String , Object> getUserInfo(UserParamVo param) throws Exception;
	
	public void deleteUserInfo(UserParamVo param) throws Exception;

}
