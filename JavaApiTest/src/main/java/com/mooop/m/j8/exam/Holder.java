package com.mooop.m.j8.exam;

import java.util.function.Supplier;

/**
 * 
 * Lazy 호출및 가시성 문제 해결 ( thread safe )
 *  -  lambda를 이용하는 방법이 핵심기술임..
 * 
 * @author MOoop
 *
 */
public class Holder {
	
	private Supplier<Heavy> heavy = ()->createAndCacheHeavy();
	
	public Holder() {
		System.out.println("Holder Created");
	}
	
	public Heavy getHeavy() {
		return heavy.get();
	}
	
	
	private synchronized Heavy createAndCacheHeavy() {
		class HeavyFactory implements Supplier<Heavy> {
			private final Heavy heavyInstance = new Heavy();
			
			public Heavy get() {return heavyInstance;}
		}
		
		if(!HeavyFactory.class.isInstance(heavy)) {
			heavy = new HeavyFactory();
		}
		return heavy.get();
	}

}
