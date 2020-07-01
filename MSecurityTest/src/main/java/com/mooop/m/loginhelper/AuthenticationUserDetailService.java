package com.mooop.m.loginhelper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("authenticationUserDetailService")
public class AuthenticationUserDetailService implements UserDetailsService{
	
	@Value("${sec.username}")
	String username;
	
	@Value("${sec.password}")
	String password;
	
	@Value("${sec.role}")
	String role;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBuilder builder = null;
		try {
			builder = User.withUsername(this.username);
			builder.password(password);
			builder.roles(role);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return builder.build();
	}

}
