package com.mooop.m.j8.etc;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileIOTest {
	
	
	
	static void tst1() throws Exception{
		Files.list(Paths.get("."))
				.filter(Files::isDirectory)
				.forEach(System.out::println);
	}
	
	
	static void tst2() throws Exception{
		Files.newDirectoryStream(Paths.get("./src") , path->path.toString().endsWith(".java"))
										.forEach(System.out::println);
	}
	
	
	public static void main(String[] args) {
		
		try {
//			tst1();
			
			tst2();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
