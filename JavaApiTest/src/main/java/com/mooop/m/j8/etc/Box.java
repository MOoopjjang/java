package com.mooop.m.j8.etc;

public class Box<T> {
	
	private T data;
	public void set(T _d) {
		this.data = _d;
	}
	
	public T get() {
		return this.data;
	}

}
