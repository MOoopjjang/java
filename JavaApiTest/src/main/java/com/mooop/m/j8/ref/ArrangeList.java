package com.mooop.m.j8.ref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.reactivex.functions.Consumer;

public class ArrangeList {
	
	
	private static void tst_1() throws Exception{
		
		List<Integer> l = Arrays.asList(1,2,3,4,5);
		l = new ArrayList<>(l);
		
		Consumer<List<Integer>> ll = Collections::reverse;
		ll.accept(l);
		System.out.println(l);
	}
	
	public static void main(String[] args) {
		try {
			tst_1();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
