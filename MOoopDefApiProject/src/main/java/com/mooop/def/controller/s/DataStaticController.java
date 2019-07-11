package com.mooop.def.controller.s;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mooop.def.model.ApiResponseData;
import com.mooop.def.model.RequestUserParam;
import com.mooop.def.service.s.DataStaticServiceImpl;

/**
 * 
 * STATIC I/F Sample
 * 
 * @author MOoop
 *
 */
@RestController
@RequestMapping(value="/data/static")
public class DataStaticController {
	
	
	@Autowired
	private DataStaticServiceImpl dataStaticService;
	
	
	@PostMapping("/user")
	public ResponseEntity<ApiResponseData> getUserData(@RequestBody RequestUserParam param) throws Exception{
		ApiResponseData<Map<String , Object>> res = new ApiResponseData<>();
		Map<String , Object> userData = dataStaticService.getUserData(param.getName(), param.getAge());
		res.setResult("OK");
		res.setResponseData(userData);
		return new ResponseEntity<>(res , HttpStatus.OK);
	}
	

}
