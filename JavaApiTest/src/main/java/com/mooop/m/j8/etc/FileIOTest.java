package com.mooop.m.j8.etc;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileIOTest {
	
	
	final static String PATH = "/svc/dev/bs/testfolder";
	
	
	static void tst1() throws Exception{
		Files.list(Paths.get(PATH))
				.peek(path->System.out.println(path.toString()))
				.filter(path->path.toString().endsWith(".java"))
				.filter(Files::isDirectory)
				.forEach(System.out::println);
	}
	
	
	static void tst2() throws Exception{
		Files.newDirectoryStream(Paths.get(PATH) , path->path.toString().endsWith(".txt"))
										.forEach(System.out::println);
	}
	
	
	public static void tst3() throws Exception{
		Files.list(Paths.get(PATH))
				.forEach(System.out::println);
	}
	
	public static void tst_walk() throws Exception{
		Files.walk(Paths.get(PATH)).forEach(System.out::println);
	}
	
	
	public static void main(String[] args) {
		
		try {
//			tst1();
			
//			tst2();
			
//			tst3();
			
			tst_walk();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
