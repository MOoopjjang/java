package com.mooop.m.j8.etc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTst {
	
	
	/**
	 * String data가 stream example
	 */
	private static void tst5() {
		String strs = "abcedef xfelog 12oiadfk";
		
		strs.chars()
				.mapToObj(ch->Character.valueOf((char)ch))
				.filter(Character::isDigit)
				.forEach(System.out::println);
	}
	
	private static void tst4() {
		
		int value = IntStream.range(1, 1000).reduce(0,(a,b)->a+b);
		System.out.println("value : "+value);
	}
	
	
	private static void tst3() {
		/**
		 * 
		 *  tst2() 에서 합이 으로 나누어떨어지는 쌍만 반환하려면 어떻게 해야 할까?
		 *  예를 들어 (2,4) , (3,3)을 반환해야 한다.
		 * 
		 * 
		 */
		List<Integer> d1 = Arrays.asList(1,2,3,4);
		List<Integer> d2 = Arrays.asList(9,8,3);
		
		d1.stream().flatMap(v->d2.stream().filter(v2->v+v2%3 == 0).map(v2->new int[] {v,v2}))
		.collect(Collectors.toList());
		
		
	}
	
	
	
	private static void tst2() {
		/**
		 * 
		 * 두개의 숫자 리스트가 있을 때 모든 숫자 쌍의 리스트를 반환하시오.예를 들어 두 개의 리스트[1,2,3]과[3,4]
		 * 가 주어지면 [(1,3),(1,4),(2,3),(2,4),(3,3),(3,4)]를 반환해야 한다.
		 * 
		 */
		
		List<Integer> d1 = Arrays.asList(1,2,3,4);
		List<Integer> d2 = Arrays.asList(9,8,3);
		
		List<int[]> r = d1.stream().flatMap(v->{
			return d2.stream().map(v2->new int[] {v,v2});
		}).collect(Collectors.toList());
		
		r.stream().forEach(iv->{
			for(int i = 0 ; i < iv.length ; i++) {
				System.out.println(iv[i]);
			}
		});
	}
	
	
	private static void tst1() {
		String[] data = {"xferlog" , "kknda" , "bhkim"};
		Stream<String> WORDS = Arrays.stream(data);
		
		Arrays.asList(data).stream()
							.map(word->word.split(""))
							.map(Arrays::stream)
							.distinct()
							.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		try {
//			tst2();
			
//			tst4();
			
			tst5();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
