package com.mooop.sec.service;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


@Component
public class SecAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private AuthenticationUserDetailService authenticationUserDetailService;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		
		UserDetails user = authenticationUserDetailService.loadUserByUsername(username);
		
		System.out.println("user.getPassword() =>"+user.getPassword());
		System.out.println("password =>"+password);
		System.out.println("user.isEnabled() =>"+user.isEnabled());
		
		if(user.getPassword() == null) {
			throw new BadCredentialsException("username");
		}
		
		if(!matchUserInfo(password , user.getPassword())) {
			throw new BadCredentialsException("username");
		}
		
		if(!user.isEnabled()) {
			throw new BadCredentialsException(username);
		}
		
		Collection<? extends GrantedAuthority> authories = user.getAuthorities();
		return new UsernamePasswordAuthenticationToken(username, password , authories);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
	
	private boolean matchUserInfo(String org , String target) {
		return org.equals(target);
	}

}
