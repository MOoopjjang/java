package com.mooop.m.login;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class AuthenticationManager implements Subscriber<UserInfo>{
	
	private static String USERNAME = "xferlog";
	private static String PWD = "1111";

	@Override
	public void onSubscribe(Subscription s) {
		s.request(Integer.MAX_VALUE);
		
	}

	@Override
	public void onNext(UserInfo t) {
		if(t.getUsername().equals(USERNAME) && t.getPassword().equals(PWD)) {
			System.out.println("인증");
		}else {
			System.out.println("not 인증");
		}
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		
	}

}
