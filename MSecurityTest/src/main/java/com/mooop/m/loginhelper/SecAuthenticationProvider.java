package com.mooop.m.loginhelper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component("secAuthenticationProvider")
public class SecAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	AuthenticationUserDetailService authenticationUserDetailService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
		String username = (String)token.getPrincipal();
		String password = (String)token.getCredentials();
		
		return Optional.ofNullable(authenticationUserDetailService.loadUserByUsername(username))
				        .filter(userDetails->isEqual(userDetails.getUsername() , username))
				        .filter(userDetails->isEqual(userDetails.getPassword() , password))
				        .map(userDetails->userDetails.getAuthorities())
				        .map(auths->new UsernamePasswordAuthenticationToken(username, password, auths))
				        .orElseThrow(()->new BadCredentialsException(username));
	}
	
	private boolean isEqual(String s1 , String s2) {
		return s1.equals(s2);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
