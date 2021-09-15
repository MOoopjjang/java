package com.mooop.m.j8.etc;

import com.mooop.m.j8.dlc.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTst {


	private static void tst6(){

		/* parallel 에서 사용할수 있는 thread 설정 */
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism" , "6");
		Long sumValue = Stream.iterate(1L , i->i+1).limit(10).parallel().reduce(0L , Long::sum);
		System.out.println("result :"+sumValue);

		/* sequential -> parallel*/

		sumValue =Stream.iterate(1L , i->i+1)
				.limit(100)
				.filter(n->n%2 == 0)
				.sequential()
				.map(n->n*2)
				.parallel()
				.reduce(0L , (x,y)->x+y);
		System.out.println("result 2:"+sumValue);

	}
	
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


	private static void process(String[] data , String name){
//		try{
//			Thread.sleep(2000L);
//		}catch (Exception e){}

//		System.out.println("tst1 --> thread id :"+Thread.currentThread().getId() );
//		Arrays.asList(data).stream()
//			.map(word-> {
//				System.out.println("stream --> thread id :"+Thread.currentThread().getId()+" , name : "+name+",word:"+word);
//				return word.split("");
//			})
//			.map(Arrays::stream)
//			.distinct()
//			.collect(Collectors.toList());


		for(String d:data){
			System.out.println("stream --> thread id :"+Thread.currentThread().getId()+" , name : "+name+",word:"+d);
		}
	}
	
	private static void tst1() {

		Person p = new Person();
		p.setAge(10);
		p.setName("cwkim");

		Person p2 = new Person();
		p2.setAge(20);
		p2.setName("bhkim");

		Person p3 = new Person();
		p3.setAge(30);
		p3.setName("ejkim");

		List<Person> pl = Arrays.asList(p,p2,p3);
		List<String> ppp = pl.stream()
			.map(pp->{
				pp.setName(pp.getName()+pp.getAge());
				return pp.getName();
			}).collect(Collectors.toList());
		System.out.println(ppp);

		System.out.println("==============================");

		pl.stream().forEach(person->{
			System.out.println(person.getName());
		});



	}



	public static void main(String[] args) {
		try {
			tst1();

//			tst2();
//			tst4();
//			tst5();

//			tst6();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
