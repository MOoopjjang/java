package com.mooop.m.j8.sync;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public class SyncTestMain {
	
	
	// Thread가시성 문제를 발생시키기 위한 code [[
	@Getter
	static class TManager{
		private static TManager instance = null;
		private String name;
		private int age;
		
		private TManager() {}
		
		
		public static TManager getInstance() {
			if(instance == null) {
				instance = new TManager();
			}
			return instance;
		}
		
		
		public void setName(String _n) {
			this.name = _n;
		}
		
		public void setAge(int _a) {
			this.age = _a;
		}
		
		
		public Map<String , Object> getData(){
			
			System.out.println("name : "+this.name+" , age : "+this.age);
			
			try {
				/**
				 *  강제로 Thread 가시성 문제를 만들기 위해 Sleep을 설정
				 */
				Thread.sleep(30*1000L);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			Map<String , Object> m = new HashMap<>();
			m.put("name", this.name);
			m.put("age", this.age);
			return m;
		}
		
	}
	
	
	private static void threadTest1() throws Exception{
		
		Thread t1 = new Thread(()-> {
			TManager tm = TManager.getInstance();
			tm.setName("cwkim");
			tm.setAge(20);
			Map<String,  Object> r = tm.getData();
			System.out.println("t1 :"+r.toString());
			
		});
		t1.start();
		
		try {
			Thread.sleep(4*1000L);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Thread t2 = new Thread(()-> {
			TManager tm = TManager.getInstance();
			tm.setName("khlee");
			tm.setAge(30);
			Map<String,  Object> r = tm.getData();
			System.out.println("t2 :"+r.toString());
			
		});
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("End");
	}
	// Thread가시성 문제를 발생시키기 위한 code ]]
	
	
	public static void main(String[] args) {
		
		try {
			threadTest1();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
