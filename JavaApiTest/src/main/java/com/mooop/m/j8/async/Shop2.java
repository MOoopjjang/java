package com.mooop.m.j8.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Shop2 {
	
	
	public String productName;
	public double nPrice;
	
	public Shop2(String product , double price){
		productName = product;
		nPrice = price;
		
	}
	
	public double getPrice(String product){
		return calculatePrice(product);
	}
	
	public Future<Double> getPriceAsync(String product){
		
		return CompletableFuture.supplyAsync(()->calculatePrice(product));
	}
	
	
	private double calculatePrice(String product){
		delay();
		
		return nPrice;
	}
	
	
	private void delay(){
		try{
			Thread.sleep(1000);;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
