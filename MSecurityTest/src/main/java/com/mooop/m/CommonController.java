package com.mooop.m;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/common")
@Controller
public class CommonController {

	@GetMapping("/error")
	public ModelAndView error(HttpServletRequest request , HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		return mv;
	}
}
