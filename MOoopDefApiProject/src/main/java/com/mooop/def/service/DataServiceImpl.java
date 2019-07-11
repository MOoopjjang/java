package com.mooop.def.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mooop.def.dao.UserData;
import com.mooop.def.model.RequestInsertUserDataParam;
import com.mooop.def.model.UserIDataInsertVo;
import com.mooop.def.model.UserParamVo;

@Transactional
@Service("dataService")
public class DataServiceImpl implements DataService{
	
	@Autowired
	private UserData userData;

	@Async("asyncThreadPoolTaskExecutor")
	@Override
	public CompletableFuture<List<Map<String , Object>>> getAllUserData() throws Exception {
		return CompletableFuture.completedFuture(userData.getAllUserData());
	}

	@Override
	public Map<String, Object> getUserData(String name, int age) throws Exception {
		UserParamVo param = new UserParamVo();
		param.setName(name);
		param.setAge(age);
		return userData.getUserData(param);
	}

	@Override
	public void deleteUserData(String name, int age) throws Exception {
		UserParamVo param = new UserParamVo();
		param.setName(name);
		param.setAge(age);
		userData.deleteUserData(param);
	}

	/**
	 *   Transaction 테스트를 위한 3개의 Query수행
	 *      1. select
	 *      2. delete
	 *      3. insert
	 * 
	 */
	@Async("asyncThreadPoolTaskExecutor")
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateUserData(RequestInsertUserDataParam newData) throws Exception {
		//1.조회
		UserParamVo param = new UserParamVo();
		param.setName(newData.getName());
		param.setAge(Integer.parseInt(newData.getAge()));
		Map<String , Object> search = userData.getUserData(param);
		if(!search.isEmpty()) {
			//2.삭제
			userData.deleteUserData(param);
		}
		
		UserIDataInsertVo ivo = new UserIDataInsertVo();
		ivo.setName(newData.getName());
		ivo.setAge(Integer.parseInt(newData.getAge()));
		ivo.setCar_yn(newData.getCar_yn());
		ivo.setHome_yn(newData.getHome_yn());
		ivo.setJob(newData.getJob());
		ivo.setMarriage_yn(newData.getMarriage_yn());
		ivo.setHobby(newData.getHobby());
		//3. 삽입
		userData.insertUserData(ivo);
	}

}
