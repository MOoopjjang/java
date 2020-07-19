package com.mooop.m.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInfo {
	
	private String username;
	
	private String password;
	
	public UserInfo(String username , String password) {
		this.username = username;
		this.password = password;
	}

}
