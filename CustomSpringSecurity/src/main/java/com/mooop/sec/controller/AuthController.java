package com.mooop.sec.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
	
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public String root() {
		return "redirect:/main/";
	}
	
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
	public String main(HttpServletRequest req) {
		
		System.out.println("main :: "+req.isUserInRole("ADMIN"));
		if(req.isUserInRole("ADMIN")) {
			return "redirect:/admin/";
		}else if(req.isUserInRole("USER")) {
			return "redirect:/user/";
		}else if(req.isUserInRole("GUEST")) {
			return "redirect:/default/";
		}
		return "redirect:/login/";
	}
	
	
	@RequestMapping(value="/admin")
	public String admin() {
		System.out.println("admin");
		return "admin";
	}
	
	@RequestMapping(value="/user")
	public String user() {
		System.out.println("user");
		return "user";
	}
	
	@RequestMapping(value="/default")
	public String defpage() {
		System.out.println("default");
		return "default";
	}
	
	
	@GetMapping(value="/registery")
	public String registery() {
		return "registery";
	}

}
