package com.mooop.def.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mooop.def.constants.DataError;
import com.mooop.def.exception.DataException;
import com.mooop.def.model.ApiResponseData;
import com.mooop.def.model.RequestInsertUserDataParam;
import com.mooop.def.service.DataServiceImpl;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping(value="/data")
public class DataController {
	
	public static Logger logger = LoggerFactory.getLogger(DataController.class);
	
	@Autowired
	private DataServiceImpl dataService;
	
	
	@GetMapping("/")
	public ResponseEntity<ApiResponseData> getAllUserData() throws DataException{
		ApiResponseData<List<Map<String , Object>>> res = new ApiResponseData<>();
		try {
			CompletableFuture<List<Map<String , Object>>> f = dataService.getAllUserData();
			while(!f.isDone()) {
				Thread.sleep(100);
			}
			
			res.setResult("OK");
			res.setResponseData(f.get());
		}catch(Exception e) {
			e.printStackTrace();
			throw new DataException(DataError.DATA_ERROR_1, e.toString());
		}
		return new ResponseEntity<>(res , HttpStatus.OK);
	}
	
	
	@PutMapping("/user")
	public ResponseEntity<ApiResponseData> updateData(@RequestBody RequestInsertUserDataParam data) throws DataException{
		ApiResponseData<Map> res = new ApiResponseData<>();
		try {
			res.setResult("OK");
			dataService.updateUserData(data);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			throw new DataException(DataError.DATA_ERROR_2, e.toString());
		}
		return new ResponseEntity<>(res , HttpStatus.OK);
	}

}
