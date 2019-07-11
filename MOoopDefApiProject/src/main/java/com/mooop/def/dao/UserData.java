package com.mooop.def.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mooop.def.model.UserIDataInsertVo;
import com.mooop.def.model.UserParamVo;

@Component("userData")
public interface UserData {
	
	public List<Map<String , Object>> getAllUserData() throws Exception;
	
	public Map<String , Object> getUserData(UserParamVo param) throws Exception;
	
	public void deleteUserData(UserParamVo param) throws Exception;
	
	public void insertUserData(UserIDataInsertVo newData) throws Exception;

}
