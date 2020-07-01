package com.mooop.m;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(1)
@Component("someFilter")
public class SomeFilter extends OncePerRequestFilter{
	
	@Autowired
	Environment env;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("################ SomeFilter ################# : "+request.getRequestURI());
		if("/main/test".equals(request.getRequestURI()) && ("local".equals(env.getActiveProfiles()[0]))) {
			response.sendRedirect("/common/error");
		}else {
			filterChain.doFilter(request, response);
		}
		
	}

}
