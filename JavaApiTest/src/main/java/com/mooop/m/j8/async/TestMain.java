package com.mooop.m.j8.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class TestMain {
	
	
	private static void doSomething() throws Exception{
		for(int i = 0 ; i < 10 ; i++){
//			Thread.sleep(1000);
			System.out.println("doSomething ==>"+i);
		}
	}
	
	private static void tst_1() throws Exception{
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		Future<Integer> future = (Future<Integer>) es.submit(()->{
			
			try{
				Thread.sleep(10 * 1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return 100;
		});
		
		
		doSomething();
		
		int result = future.get();
		System.out.println("result ::"+result);
		
	}
	
	
	
	static class Tst2Object{
		public<T> void loopData(String s , Consumer<T> cb) {
			IntStream.rangeClosed(1, 10).forEach(v->{
				System.out.println(v);
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			
			cb.accept((T) s);
			
		}
		
		
		public Function<Integer, String> generate(){
			return (v)->{
				return "hi"+":"+IntStream.rangeClosed(1, v).sum();
			};
		}
	}
	
	
	private static void tst2() {
		
		
		Tst2Object to = new Tst2Object();
		to.loopData("xferlog", v->{
			System.out.println(v);
		});
		
		
		Function<Integer, String> fcb = to.generate();
		fcb.apply(10);
		
		
	}
	
	public static void main(String[] args) {
		try{
//			tst_1();
			tst2();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
