package com.mooop.def.service.s;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mooop.def.model.RequestInsertUserDataParam;
import com.mooop.def.service.DataService;


@Service("dataStaticService")
public class DataStaticServiceImpl implements DataService{

	@Override
	public CompletableFuture<List<Map<String, Object>>> getAllUserData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getUserData(String name, int age) throws Exception {
		ObjectMapper om = new ObjectMapper();
		Map<String , Object> readStaticData = om.readValue(getClass().getResource("/static/data/api/info.json")
				, Map.class);
		return readStaticData;
	}

	@Override
	public void deleteUserData(String name, int age) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserData(RequestInsertUserDataParam newData) throws Exception {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
