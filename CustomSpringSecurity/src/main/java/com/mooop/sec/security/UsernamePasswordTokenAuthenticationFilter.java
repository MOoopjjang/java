package com.mooop.sec.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class UsernamePasswordTokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		
		if(!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: "+request.getMethod());
		}
		
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		String userToken = request.getParameter("usertoken");
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(userToken);
		if(username == null) {
			username = "";
		}
		if(password == null) {
			password = "";
		}
		if(userToken == null) {
			userToken = "";
		}
		
		//Custom Token 생성
		UsernamePasswordTokenAuthenticatonToken authRequest = new UsernamePasswordTokenAuthenticatonToken(username , password , userToken);
		setDetails(request, authRequest);
		return this.getAuthenticationManager().authenticate(authRequest);
	}
	
	/**
	 *  인증성공시 호출된 Handler 지정
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println("adfadfaf");
		setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler("/main"));
		super.successfulAuthentication(request, response, chain, authResult);
	}
	
	
	/**
	 * 인증실패시 호출될 Handler 지정
	 */
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/loginfail"));
		super.unsuccessfulAuthentication(request, response, failed);
	}

}
