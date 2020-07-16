package com.mooop.m;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/wsc")
public class WebSocketController {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	/**
	 * Broker에게 메세지를 publish 한다
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/socket")
	@ResponseBody
	public String socketTest(HttpServletRequest request) {
		String text = request.getParameter("text");
		simpMessagingTemplate.setMessageConverter(new StringMessageConverter());
		simpMessagingTemplate.convertAndSend("/topic/test",text);
		return "OK";
		
	}
	
	/**
	 * main_page 출력
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/main_page")
	@ResponseBody
	public ModelAndView main_page(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main_page");
		return mv;
		
	}
	
	
	@GetMapping(value = "/eagles")
	public ModelAndView test(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("eagles");
		return mv;
	}

}
