package com.mooop.m.j8.async;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ComputerShop implements Shop{
	
	private ArrayList<ComputerData> list;
	
	public ComputerShop(){
		list = new ArrayList<ComputerData>();
	}

	/**
	 * STEP 1
	 */
	@Override
	public int convertSyncToAsyncStep1() {
		try{
			Thread.sleep(5 * 1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Random random = new Random();
		return random.nextInt(100);
	}

	/**
	 * STEP 1
	 */
	@Override
	public CompletableFuture<Integer> convertSyncToAsyncStep2() {
		CompletableFuture<Integer> future = new CompletableFuture<>();
		new Thread(()->{
			try{
				Thread.sleep(5 * 1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			future.complete(100);
		}).start();
		return future;
	}

	@Override
	public CompletableFuture<Integer> convertSyncToAsyncStep3() {
		CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(()->{
			try{
				Thread.sleep(5*1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			return 100;
		});
		return cf;
	}

	
	public void add(ComputerData data){
		list.add(data);
	}
	
	
	public ComputerData findMinStreamPrice(){
		Optional<Long> r =  list.stream().map(c->c.getComputerPartPrice()).min(Long::compareTo);
		return list.stream().filter(m->m.getComputerPartPrice() == r.get()).findFirst().get();
	}
	
	public ComputerData findMaxStreamPrice(){
		Long r = list.stream().map(ComputerData::getComputerPartPrice).max(Long::compareTo).get();
		return list.stream().filter(m->m.getComputerPartPrice() == r).findFirst().get();
	}
	
	
	public ComputerData findStream(String _partName){
		return list.stream().filter(mm->_partName.equals(mm.getComputerPartName())).findAny().get();
	}
	
	
	public ComputerData findMinPallelStreamPrice(){
		Optional<Long> r =  list.parallelStream().map(c->c.getComputerPartPrice()).min(Long::compareTo);
		return list.stream().filter(m->m.getComputerPartPrice() == r.get()).findFirst().get();
	}
	
	public ComputerData findMaxPallelStreamPrice(){
		Long r = list.parallelStream().map(ComputerData::getComputerPartPrice).max(Long::compareTo).get();
		return list.stream().filter(m->m.getComputerPartPrice() == r).findFirst().get();
	}
	
	
	public ComputerData findPallelStream(String _partName){
		return list.parallelStream().filter(mm->_partName.equals(mm.getComputerPartName())).findAny().get();
	}

}
