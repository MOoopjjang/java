package com.mooop.m;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/main")
public class MainController {
	
	@GetMapping("/")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	
	@GetMapping("/test")
	public ModelAndView test(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test");
		return mv;
	}

}
