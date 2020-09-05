package com.mooop.m.j8.async;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShopManager {
	
	
	private List<Shop2> list;
	
	private ExecutorService es;
	
	private ShopManager(){
		list = new ArrayList<Shop2>();
	}
	
	public static ShopManager getInstance(){
		return LazyHolder.INSTANCE;
	}
	
	
	public void add(Shop2 _item){
		list.add(_item);
	}
	
	
	public  String findPrices(String product){
		
		
		
		Optional<String> r= list.stream().filter(s->s.productName.equals(product)).map(m->{
			return "productName :"+m.productName+" , price :"+m.getPrice(product);
		}).findAny();
		
		return r.get();
	}
	
	public  String finPallelPrices(String product){
		Optional<String> r= list.parallelStream().filter(s->s.productName.equals(product)).map(m->{
			return "productName :"+m.productName+" , price :"+m.getPrice(product);
		}).findAny();
		
		return r.get();
	}
	
	public List<String> findAsyncPrice(){
		
		ExecutorService es = Executors.newFixedThreadPool(Math.min(list.size(), 100)  , r->{
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		});
		
		List<CompletableFuture<String>> futures = list.stream().map(m->{
			return CompletableFuture.supplyAsync(()->{
				return "productName :"+m.productName+" , price :"+m.getPrice("");
			} , es);
		}).collect(Collectors.toList());
		
		
		return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
		
	}
	
	
	private static class LazyHolder{
		private final static  ShopManager INSTANCE = new ShopManager();
	}

}
