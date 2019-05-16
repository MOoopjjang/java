package com.mooop.sec.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mooop.sec.service.DbService;
import com.mooop.sec.utils.MStringUtil;


@RestController
@RequestMapping(value="/admin")
public class AdminController {
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private DbService dbService;
	
	@PostMapping(value="/registery")
	public ResponseEntity<Map<String , Object>> registery(@RequestBody Map<String , Object> registeryInfo ){
		
		String username = MStringUtil.defaultEmptyString((String) registeryInfo.get("userid"), "") ;
		String password = MStringUtil.defaultEmptyString((String) registeryInfo.get("password"), "") ;
		String token = MStringUtil.defaultEmptyString((String) registeryInfo.get("token"), "") ;
		String role = MStringUtil.defaultEmptyString((String) registeryInfo.get("role"), "") ;
		
		logger.info("username : "+username+" , password : "+password+" , token : "+token+" , role : "+role);
		HttpStatus status = HttpStatus.OK;
		Map<String , Object> resultMap = new HashMap<String, Object>();
		if(username.equals("") || password.equals("") || token.equals("") || role.equals("")) {
			
			resultMap.put("result", "FAILED");
			return new ResponseEntity<>(resultMap , status);
		}
		
		status = HttpStatus.OK;
		try {
			dbService.insertUserInfo(registeryInfo);
			resultMap.put("result", "OK");
		}catch(Exception e) {
			resultMap.put("result", "FAILED");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		return new ResponseEntity<>(resultMap , status);
	}
	
	
	
	@GetMapping(value="/test")
	public ResponseEntity<Map<String , Object>> test(){
		
		
		logger.info("test Called");
		HttpStatus status = HttpStatus.OK;
		Map<String , Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", "OK");
		return new ResponseEntity<>(resultMap , status);
	} 
	

}
