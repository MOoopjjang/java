package com.mooop.sec.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.mooop.sec.utils.BCryptUtils;


/**
 * 
 * @author MOoop
 *
 */

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private TokenUserDetailService tokenUserDetailService;

	/**
	 *  입력받은값 (UsernamePasswordTokenAuthenticatonToken)과 저장소의 값 ( TokenUserDetails )의 값을 비교후 Authentication 객체를 반환한다
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		/**
		 * 
		 * UsernamePasswordTokenAuthenticationFilter 를 통해 생성된 UsernamePasswordTokenAuthenticatonToken 값으로 casting
		 */
		UsernamePasswordTokenAuthenticatonToken token = (UsernamePasswordTokenAuthenticatonToken)authentication;
		String username = (String) token.getPrincipal();
		String password = (String) token.getCredentials();
		String userToken = token.getToken();
		
		TokenUserDetails tokenUserDetails = (TokenUserDetails) tokenUserDetailService.loadUserByUsername(username);
		
		if(!username.equals(tokenUserDetails.getUsername())) {
			throw new BadCredentialsException(username);
		}
		
		
		if(!BCryptUtils.getInstance().matches(password, tokenUserDetails.getPassword())) {
			throw new BadCredentialsException(username);
		}
		
		if(!userToken.equals(tokenUserDetails.getToken())) {
			throw new BadCredentialsException(username);
		}
		
		Collection<GrantedAuthority> authorites = (Collection<GrantedAuthority>) tokenUserDetails.getAuthorities();
		System.out.println("authorites size ::"+authorites.size());
		if(authorites == null || authorites.size() == 0) {
			throw new BadCredentialsException(username);
		}
		
		/**
		 * 인증완료된 정보로 Custom Token생성
		 */
		return new UsernamePasswordTokenAuthenticatonToken(username , password , userToken , authorites);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordTokenAuthenticatonToken.class.equals(authentication);
	}

}
