package com.mooop.sec.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class UsernamePasswordTokenAuthenticatonToken extends UsernamePasswordAuthenticationToken{
	private static final long serialVersionUID = -5285586712485580016L;
	
	private String userToken;
	
	
	public UsernamePasswordTokenAuthenticatonToken(Object principal, Object credentials , String userToken) {
		super(principal, credentials);
		this.userToken = userToken;
	}

	public UsernamePasswordTokenAuthenticatonToken(Object principal, Object credentials, String userToken,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
		
		this.userToken = userToken;
	}
	
	
	public String getToken() {
		return userToken;
	}


}
