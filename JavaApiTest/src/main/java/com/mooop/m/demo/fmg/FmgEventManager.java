package com.mooop.m.demo.fmg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import io.reactivex.Flowable;
import io.reactivex.flowables.ConnectableFlowable;

public class FmgEventManager {
	
	
	private Map<FMG_UI_EVENT , List<UiSubscriber>> eMap = null;
	
	
	public FmgEventManager() {
		eMap = Arrays.asList(FMG_UI_EVENT.values())
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
	public void registry(final FMG_UI_EVENT e , final UiSubscriber className ) {
		if(eMap.containsKey(e)) {
			eMap.get(e).add(className);
		}
	}
	
	
	/**
	 * 
	 * @param e
	 * @param data
	 */
	public void notify(final FMG_UI_EVENT e , final Object data ) {
		
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
