package com.mooop.m.j8.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

public class Sample2Main {
	
	
	
	
	private static void tst_2() throws Exception{
		
		ShopManager sm = ShopManager.getInstance();
		sm.add(new Shop2("memory" , 1000));
		sm.add(new Shop2("hard" , 1500));
		sm.add(new Shop2("cpu" , 200000));
		sm.add(new Shop2("board" , 100000));
		
		long startTime = System.nanoTime();
		String info = sm.findPrices("memory");
		System.out.println("info :"+info);
		System.out.println("stream duration time :"+(System.nanoTime()-startTime)/1000000);
		
		startTime = System.nanoTime();
		info = sm.finPallelPrices("memory");
		System.out.println("info :"+info);
		System.out.println("pallel duration time :"+(System.nanoTime()-startTime)/1000000);
		
		
		startTime = System.nanoTime();
		List<String> rl = sm.findAsyncPrice();
		rl.stream().forEach(System.out::println);
		System.out.println("pallel duration time :"+(System.nanoTime()-startTime)/1000000);
		
	}
	
	private static void tst_1() throws Exception{
		Shop2 s = new Shop2("memory" , 10000);
		long startTime = System.nanoTime();
		
		Future<Double> r = s.getPriceAsync("");
		
		System.out.println("tst_1 somegthing 1");	
		System.out.println("r :"+r.get());
		
	}
	
	public static void main(String[] args) {
		
		
		try{
//			tst_1();
			
			tst_2();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
