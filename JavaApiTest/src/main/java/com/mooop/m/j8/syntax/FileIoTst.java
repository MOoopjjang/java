package com.mooop.m.j8.syntax;

import java.io.File;

public class FileIoTst {
	
	
	
	private static void tst1() throws Exception{
		
		
		File f = new File("a.json");
		if(f.exists()) {
			System.out.println("exist");
			f.delete();
		}else {
			System.out.println("not exist");
			f.createNewFile();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			tst1();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
