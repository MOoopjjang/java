package com.mooop.m;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/wsc")
public class WebSocketClientController {
	
	/**
	 * 
	 * WebSocket Main 페이지를출력한다.
	 *   - Direct Url 
	 *   
	 * @param request
	 * @return
	 */
	@GetMapping("/main")
	public ModelAndView test(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("websocket_main");
		return mv;
	}
	
	
	/**
	 * WebSocket Body 페이지를출력한다.
	 *   - Publisher 서버의 main_page를 통한 호출
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping("/remote_body")
	public String eagles(HttpServletRequest request , Model model) {
		String count = request.getParameter("count");
		model.addAttribute("count", count);
		return "websocket_message_body";
		
	}

}
