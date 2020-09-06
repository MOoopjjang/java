package com.mooop.m.demo.fmg;

public class MFileManager {
	
	private FmInfo info;
	
	private MFileManager() {}
		
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static MFileManager getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	
	
	public MFileManager setInfo(FmInfo info) {
		this.info = info;
		return this;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	private static class  LazyHolder{
		public static final MFileManager INSTANCE = new MFileManager();
	}





}
