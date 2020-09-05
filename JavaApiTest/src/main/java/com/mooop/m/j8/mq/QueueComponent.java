package com.mooop.m.j8.mq;

import java.util.HashMap;
import java.util.Map;

public class QueueComponent<T , P> {
	
	public static final String Q1_TAG = "q1";
	public static final String Q2_TAG = "q2";
	
	
	
	private Map<String , BaseQueue<?>> qMap = new HashMap<>();
	
	
	
	
	public QueueComponent() {
		qMap.put(Q1_TAG, new PersonQueue<T>());
		qMap.put(Q2_TAG, new MonsterQueue<P>());
	}
	
	
	public BaseQueue load(String tag){
		return qMap.get(tag);
	}
	
	
//	public void push( data) {
//		loadQueue.offer(data);
//	}

}
