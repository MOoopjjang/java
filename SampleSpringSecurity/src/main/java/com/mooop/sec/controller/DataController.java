package com.mooop.sec.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mooop.sec.service.DbService;


@RestController
@RequestMapping(value="/db")
public class DataController extends CommonBasicController{
	
	private static Logger logger = LoggerFactory.getLogger(DataController.class);
	
	
	@Autowired
	private DbService dbService;
	
	@GetMapping(value="/{userid}")
	public ResponseEntity<Map<String , Object>> getAuthInfo(@PathVariable String userid){
		
		
		HttpStatus status = HttpStatus.OK;
		Map<String , Object> rr = null;
		try {
			rr = dbService.getUserAuthInfo(userid);
		}catch(Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(rr , status);
		
	}

}
