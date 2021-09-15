package com.mooop.m.j8.async;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sample1Main {
	
	
	public void convertAsyncStep3() throws Exception{
		
		ComputerShop cs = new ComputerShop();
		Future<Integer> resultFuture = cs.convertSyncToAsyncStep3();
		  for(int i = 0 ; i < 10 ; i++){
		    	System.out.println("[convertAsyncStep3] i ="+i);
		    	Thread.sleep(100);
		    }
		
		  System.out.println("[convertAsyncStep3] result :"+resultFuture.get());
	}

	
	public void convertAsyncStep2() throws Exception{
		
		ComputerShop cs = new ComputerShop();
		Future<Integer> resultFuture = cs.convertSyncToAsyncStep2();
		  for(int i = 0 ; i < 10 ; i++){
		    	System.out.println("[convertAsyncStep2] i ="+i);
		    	Thread.sleep(100);
		    }
		
		  System.out.println("[convertAsyncStep2] result :"+resultFuture.get());
	}
	
	
	public void convertAsyncStep1() throws Exception{
		
		ComputerShop cs = new ComputerShop();
		int result = cs.convertSyncToAsyncStep1();
	    for(int i = 0 ; i < 10 ; i++){
	    	System.out.println("[convertAsyncStep1] i ="+i);
	    	Thread.sleep(100);
	    }
		System.out.println("[convertAsyncStep1] result :"+result);
		
		
	}
	
	
	//=======================================================================================================
	//
	//  stream 과 pallelStream 과의 성능 차이 테스트( START )
	//
	//    - singleStreamTest : Stream
	//    - pallelStreamTest : pallelStream
	//
	//=======================================================================================================
	public ComputerShop makeShopData() throws Exception{
		
		ComputerShop cs = new ComputerShop();
		cs.add(new ComputerData("ram" , 40000));
		cs.add(new ComputerData("harddisk" , 100000));
		cs.add(new ComputerData("cpu" , 200000));
		cs.add(new ComputerData("monitor" , 120000));
		
		
		return cs;
	}
	
	public void pallelStreamTest() throws Exception{
		System.out.println("============================ pallelStreamTest() ================================");
		ComputerShop cs = makeShopData();
		long startTime = System.nanoTime();
		ComputerData resultData = cs.findMinPallelStreamPrice();
		System.out.println("[singleStreamTest]min==>"+resultData.toString()+" , duration : "+durationTime(startTime));
		
		startTime = System.nanoTime();
		resultData = cs.findMaxPallelStreamPrice();
		System.out.println("[singleStreamTest]max==>"+resultData.toString()+" , duration : "+durationTime(startTime));
		
		startTime = System.nanoTime();
		resultData = cs.findPallelStream("harddisk");
		System.out.println("[singleStreamTest]find==>"+resultData.toString()+" , duration : "+durationTime(startTime));
	}
	
	
	public void singleStreamTest() throws Exception{
		System.out.println("============================ singleStreamTest() ================================");
		ComputerShop cs = makeShopData();
		long startTime = System.nanoTime();
		ComputerData resultData = cs.findMinStreamPrice();
		System.out.println("[singleStreamTest]min==>"+resultData.toString()+" , duration : "+durationTime(startTime));
		
		startTime = System.nanoTime();
		resultData = cs.findMaxStreamPrice();
		System.out.println("[singleStreamTest]max==>"+resultData.toString()+" , duration : "+durationTime(startTime));
		
		startTime = System.nanoTime();
		resultData = cs.findStream("harddisk");
		System.out.println("[singleStreamTest]find==>"+resultData.toString()+" , duration : "+durationTime(startTime));
	}
	
	
	private long durationTime(long startTime){
		return (System.nanoTime()-startTime)/1000000;
	}
	
	
	private static void tst_stream_performance(){
		try{
			Sample1Main m = new Sample1Main();
			m.singleStreamTest();
			m.pallelStreamTest();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//=======================================================================================================
	//  stream 과 pallelStream 과의 성능 차이 테스 ( END )
	//=======================================================================================================
	
	
	public static void main(String[] args) {
		tst_stream_performance();
		
		
	}

}
