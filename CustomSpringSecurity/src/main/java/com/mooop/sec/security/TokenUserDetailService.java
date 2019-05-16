package com.mooop.sec.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mooop.sec.dao.AuthDao;
import com.mooop.sec.security.TokenUser.TokenUserBuilder;


/**
 * 
 * 저장소에서 가져온 정보로  TokenUserDetails 객체를 생성후 반환한다
 * 
 * @author 
 *
 */

@Component
public class TokenUserDetailService implements UserDetailsService{
	
	@Autowired
	private AuthDao authDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		TokenUserBuilder tokenBuilder = null;
		try {
			
			Map<String , Object> userInfo = authDao.getUserAuthInfo(username);
			if(!userInfo.isEmpty()) {
				tokenBuilder = TokenUser.withUsername((String)userInfo.get("username"));
				tokenBuilder.password((String)userInfo.get("password"));
				tokenBuilder.token((String)userInfo.get("token"));
				tokenBuilder.roles((String)userInfo.get("role"));
				System.out.println("role ::"+(String)userInfo.get("role"));
			}else {
				throw new UsernameNotFoundException("User not found");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return tokenBuilder.build();
	}

}
