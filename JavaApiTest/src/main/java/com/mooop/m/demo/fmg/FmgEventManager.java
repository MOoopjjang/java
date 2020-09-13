package com.mooop.m.demo.fmg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.reactivex.Flowable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.schedulers.Schedulers;

public class FmgEventManager {
	
	
	private Map<FMG_ACTION_EVENT , List<ActionSubscriber>> eMap = null;
	
	
	public FmgEventManager() {
		eMap = Arrays.asList(FMG_ACTION_EVENT.values())
				.stream()
				.collect(Collectors.toMap(e->e , e->new ArrayList<ActionSubscriber>()));
		System.out.println("::"+eMap.size()+"::");
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static FmgEventManager getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	
	/**
	 * 
	 * @param e
	 * @param className
	 */
	public void registry(final ActionSubscriber className , final FMG_ACTION_EVENT... e ) {
		Arrays.asList(e).stream().map(es->{
			eMap.get(es).add(className);
			return "success";
		}).count();
	}
	
	
	/**
	 * 
	 */
	public void printRegistryInformation() {
		eMap.keySet().stream()
			.peek(e->System.out.println("================= ["+e+"]==================="))
			.map(e->{
				eMap.get(e).stream().forEach(cls->System.out.println(cls.getClass().getSimpleName()));
				return "OK";
			})
			.peek(d->System.out.println("=========================================="))
			.count();
	}
	
	
	/**
	 * 
	 * @param e
	 * @param className
	 */
	public void unregistry(final FMG_ACTION_EVENT e , final ActionSubscriber className ) {
		if(eMap.containsKey(e)) {
			ArrayList<ActionSubscriber> l = (ArrayList<ActionSubscriber>) eMap.get(e);
			Iterator<ActionSubscriber> iterator = l.iterator();
			while(iterator.hasNext()) {
				ActionSubscriber us = iterator.next();
				if(us.equals(className)) {
					iterator.remove();
				}
			}
		}
	}
	
	
	/**
	 * 
	 * @param e
	 * @param data
	 */
	public <T> void notify(final FMG_ACTION_EVENT e , final MMessage<T> data ) {
		
		if(eMap.containsKey(e)) {
			ConnectableFlowable<MMessage<T>> flowable = Flowable.just(data).publish();
			eMap.get(e).stream()
					.peek(ee->System.out.println(ee.getClass().getSimpleName()))
					.forEach(ee->flowable.subscribe(ee));
			flowable.connect(s->{
				System.out.println("Notify Starting....");
			});
			
			
		}
		
	}
	
	
	/**
	 * 
	 * @author mooopjjang
	 *
	 */
	private static class LazyHolder{
		public final static FmgEventManager INSTANCE  = new FmgEventManager();
	}

}
