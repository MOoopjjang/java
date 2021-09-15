package com.mooop.m.demo.fmg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	
	
	/**
	 * 
	 * @param info
	 * @return
	 */
	public MFileManager setInfo(FmInfo info) {
		this.info = info;
		return this;
	}
	
	
	
	/**
	 * 
	 */
	public void run() {
		
		try {
			Files.walk(Paths.get(info.getPath()))
					.filter(p->!Files.isDirectory(p))
					.filter(p->info.getSearchText().stream().filter(ext->p.toString().endsWith(ext)).count() > 0)
					.forEach(p->System.out.println(p.toString()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	/**
	 * 
	 */
	private static class  LazyHolder{
		private static final MFileManager INSTANCE = new MFileManager();
	}



	public static void main(String[] args) {
		MFileManager mf = new MFileManager();
		FmInfo info = FmInfo.budiler().path("/Users/gimcheol-u/Documents/work/git/java").search(".txt|.css").build();
		mf.setInfo(info).run();
	}


}
