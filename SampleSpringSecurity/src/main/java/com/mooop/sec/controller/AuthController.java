package com.mooop.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController extends CommonBasicController{
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/loginproc" , method=RequestMethod.POST)
	public String loginproc() {
		return "";
	}
	
	@RequestMapping(value="/loginfail")
	public String loginfail() {
		return "loginfail";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout() {
		return "logout";
	}
	
	@RequestMapping(value="/main")
	public String main() {
		return "main";
	}

}
