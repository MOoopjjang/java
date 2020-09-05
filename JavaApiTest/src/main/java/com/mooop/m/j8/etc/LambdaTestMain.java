package com.mooop.m.j8.etc;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTestMain {
	
	
	final static Function<String, Predicate<String>> cfunc = (letter)->(name)->letter.startsWith(name);
	
	public static void main(String[] args) {
//		 Predicate<String> pfunc = cfunc.apply("Hi joel kim ,Hi kcwda , Hi kkkal");
//		 System.out.println(pfunc.test("Hi"));
		 
		 String s = "afa,cfakf,iadkf,4,5,6";
		 s.chars().mapToObj(ch->Character.valueOf((char)ch)).forEach(System.out::println);
	}
	

}
