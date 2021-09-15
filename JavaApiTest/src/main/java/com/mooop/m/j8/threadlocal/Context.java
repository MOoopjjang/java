package com.mooop.m.j8.threadlocal;

import java.util.Date;

public class Context {
	
	public static ThreadLocal<Date> local = new ThreadLocal<>();

}
