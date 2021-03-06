package com.mooop.sec.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptUtils {
	
	private PasswordEncoder encoder;
	
	private BCryptUtils() {
		encoder = new BCryptPasswordEncoder();
	}
	
	
	/**
	 * Singleton
	 * 
	 * @return
	 */
	public static BCryptUtils getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	
	/**
	 * Encoding..
	 * 
	 * @param rawPassword
	 * @return
	 */
	public String encode(String rawPassword) {
		return encoder.encode(rawPassword);
	}
	
	/**
	 * 
	 * @param rawPassword
	 * @param encodedPassword
	 * @return
	 */
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encoder.matches(rawPassword, encodedPassword);
	}
	
	
	
	
	
	private static class LazyHolder{
		private static BCryptUtils INSTANCE = new BCryptUtils();
	}

}
