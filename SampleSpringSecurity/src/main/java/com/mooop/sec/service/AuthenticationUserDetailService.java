package com.mooop.sec.service;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mooop.sec.dao.AuthDao;
import com.mooop.sec.utils.BCryptUtils;


@Component
public class AuthenticationUserDetailService implements UserDetailsService{
	
	@Autowired
	private AuthDao authDao;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserBuilder builder = null;
		try {
			Map<String , Object> info = authDao.getUserAuthInfo(username);
			if(!info.isEmpty()) {
				builder = User.withUsername((String)info.get("username"));
				builder.password((String)info.get("password"));
				builder.roles((String)info.get("role"));
				
			}else {
				throw new UsernameNotFoundException("User not found");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.build();
	}

}
