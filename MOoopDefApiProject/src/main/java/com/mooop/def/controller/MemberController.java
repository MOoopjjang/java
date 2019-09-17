package com.mooop.def.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mooop.def.constants.MemberError;
import com.mooop.def.exception.MemberException;
import com.mooop.def.model.ApiResponseData;
import com.mooop.def.model.RequestUserParam;
import com.mooop.def.service.MemberServiceImpl;

import lombok.extern.slf4j.Slf4j;


@SuppressWarnings("rawtypes")
@RestController
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;


	@GetMapping("/")
	public ResponseEntity<ApiResponseData> allUserInfo(HttpServletRequest request) throws MemberException{
		ApiResponseData<List<Map<String ,Object>>> resData = new ApiResponseData();
		try {
			List<Map<String ,Object>> result = memberService.getAllUserInfo();
			resData.setResult("OK");
			resData.setResponseData(result);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MemberException(MemberError.MEMBER_ERROR_1 , e.toString());
		}
		
		return new ResponseEntity<ApiResponseData>(resData , HttpStatus.OK);
	}
	
	
	
	@PostMapping("/user")
	public ResponseEntity<ApiResponseData> getUserInfo(HttpServletRequest request ,
			@RequestBody RequestUserParam param) throws MemberException{
		ApiResponseData<Map<String ,Object>> resData = new ApiResponseData<>();
		
		try {
			resData.setResult("OK");
			resData.setResponseData(memberService.getUserInfo(param.getName(), param.getAge()));
		}catch(Exception e) {
			e.printStackTrace();
			throw new MemberException(MemberError.MEMBER_ERROR_2 , e.toString());
		}
		
		
		return new ResponseEntity<>(resData , HttpStatus.OK);
	}
	
	
	@DeleteMapping("/user")
	public ResponseEntity<ApiResponseData> delUserInfo(HttpServletRequest request,
			@RequestBody RequestUserParam param) throws MemberException{
		ApiResponseData<Map<String ,Object>> resData = new ApiResponseData<>();
		try {
			memberService.deleteUserInfo(param.getName(), param.getAge());
			resData.setResult("OK");
		}catch(Exception e) {
			e.printStackTrace();
			throw new MemberException(MemberError.MEMBER_ERROR_3 , e.toString());
		}
		return new ResponseEntity<>(resData , HttpStatus.OK);
	}
}
