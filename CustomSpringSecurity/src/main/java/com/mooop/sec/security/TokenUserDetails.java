package com.mooop.sec.security;

import org.springframework.security.core.userdetails.UserDetails;


/**
 * 
 *  Default ( Username + password + Authorities ) + Custom field ( Token )
 * 
 * @author MOoop
 *
 */
public interface TokenUserDetails extends UserDetails{
	
	/**
	 * 저장소의 token값을 반환하는 메소드 
	 * 
	 * @return token값
	 */
	public String getToken();

}
