package com.mooop.m.demo.fmg;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class ActionSubscriber<MMessage> implements Subscriber<MMessage>{

	@Override
	public void onSubscribe(Subscription s) {
		s.request(Long.MAX_VALUE);
		
	}

	@Override
	public void onNext(MMessage t) {
		System.out.println("ActionSubscriber -- > ");
		
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
