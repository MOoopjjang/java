package com.mooop.m.demo.fmg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import io.reactivex.Flowable;
import io.reactivex.flowables.ConnectableFlowable;

public class FmgEventManager {
	
	
	private Map<FMG_ACTION_EVENT , List<UiSubscriber>> eMap = null;
	
	
	public FmgEventManager() {
		eMap = Arrays.asList(FMG_ACTION_EVENT.values())
				.stream()
				.collect(Collectors.toMap(e->e , e->new ArrayList<UiSubscriber>()));
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
	public void registry(final UiSubscriber className , final FMG_ACTION_EVENT... e ) {
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
	public void unregistry(final FMG_ACTION_EVENT e , final UiSubscriber className ) {
		if(eMap.containsKey(e)) {
			ArrayList<UiSubscriber> l = (ArrayList<UiSubscriber>) eMap.get(e);
			Iterator<UiSubscriber> iterator = l.iterator();
			while(iterator.hasNext()) {
				UiSubscriber us = iterator.next();
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
	public void notify(final FMG_ACTION_EVENT e , final Object data ) {
		
		if(eMap.containsKey(e)) {
			ConnectableFlowable<Object> flowable = (ConnectableFlowable<Object>) Flowable.just(data);
			for(UiSubscriber s : eMap.get(e)) {
				flowable.subscribe(s);
			}
			
			flowable.connect();
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
