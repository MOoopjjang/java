package com.mooop.m.j8.mq;

import java.util.LinkedList;
import java.util.Queue;

public class BaseQueue<T> {
	
	protected Queue<T> queue = new LinkedList<>();
	
	
	
	public void push(T data) {
		queue.offer(data);
	}
	
	
	public T pop() {
		return queue.poll();
	}

}
