package com.mooop.m.j8.reflect;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QueueComponent {
	
	
	
	private Map<String , Queue<?>> m = new HashMap<>();
	
//	private Queue<?> loadQueue = null;
	
	
	public<T> void registry(String key , Class<T> cls) {
		if(!m.containsKey(key)) {
			m.put(key, new LinkedList<T>());
		}
	}
	
	
//	public QueueComponent load(String key){
//		loadQueue = m.get(key);
//		return this;
//	}
	
	
//	public QueueComponent add(String key)
	
	
	public int size() {
		return m.size();
	}
	
	
	public <T> Queue<T> get(String key){
		return (Queue<T>) m.get(key);
	}
	
	
	public<T> void add(String key , T data) {
		Queue<T> mm = (Queue<T>) m.get(key);
		mm.offer(data);
	}
	
	
	public<T> T pop(String key) {
		Queue<T> mm = (Queue<T>) m.get(key);
		return mm.poll();
	}
	
//	public 

}
