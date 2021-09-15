package com.mooop.m.j8.threadlocal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsTst {
	
	public static AtomicInteger idx = new AtomicInteger(0);
	public static ThreadLocal<Integer> thl = new ThreadLocal<>();
	
	
	
	private static void tst1() throws Exception{
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		for(int i = 0 ; i < 5 ; i++) {
			es.execute(()->{
				Integer v = idx.addAndGet(1);
				thl.set(v);
				System.out.println("set ::"+v);
			});
		}
		
		
		try {
			Thread.sleep(5*1000L);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		for(int i = 0 ;i < 15 ; i++) {
			es.execute(()->{
				Integer vv = thl.get();
				System.out.println("vv : "+vv);
			});
			
		}
		
		es.shutdown();
		es.awaitTermination(100	, TimeUnit.SECONDS);
	}
	
	
	
	public static ThreadLocal<User> tlu = new ThreadLocal<>();
	private static void tstUser() throws Exception{
		
		List<User> userList = Arrays.asList(
				new User("1" , "a" , 10)
				, new User("2" , "b" , 20)
				,new User("3" , "c" , 30)
				,new User("4" , "d" , 40)
				,new User("5" , "e" , 50)
				);
		
		
		
		ExecutorService es = Executors.newFixedThreadPool(5);
		for(int i = 0 ; i < 5 ; i++) {
			es.execute(()->{
				
				tlu.set(userList.get(idx.getAndAdd(1)));
			});
		}
		
		
		try {
			Thread.sleep(5*1000L);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		for(int i = 0 ; i < 5 ; i++) {
			es.execute(()->{
				User u = tlu.get();
				System.out.println(" u : "+u.toString());
				tlu.remove();
			});
		}
		
		
		try {
			
			Thread.sleep(2*1000L);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		System.out.println("====== remove after exception 발생=======");
		for(int i = 0 ; i < 5 ; i++) {
			es.execute(()->{
				User u = tlu.get();
				System.out.println(" u : "+u.toString());
				tlu.remove();
			});
		}
		
		es.shutdown();
		es.awaitTermination(10, TimeUnit.SECONDS);
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		
//		tst1();
		tstUser();
		
		
	}
	
	
	
	public static class User{
		public String id;
		public String name;
		public Integer age;
		
		public User(String id , String name , Integer age) {
			this.id = id;
			this.name = name;
			this.age = age;
		}
		
		@Override
		public String toString() {
			return String.format("id : %s , name : %s , age : %d", this.id , this.name , this.age);
		}
	}

}
