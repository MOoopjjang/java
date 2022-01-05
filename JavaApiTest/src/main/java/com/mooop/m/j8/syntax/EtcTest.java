package com.mooop.m.j8.syntax;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EtcTest {
	
	
	private static void tst1() throws Exception{
		
		
		String strNum = "0";
		int v = Integer.parseInt(strNum);
		System.out.println("v : "+v);
	}

	/**
	 * Hash Map에 관련된 다양한 테스트
	 *
	 * @throws Exception
	 */
	private static void tst_hashmap() throws Exception{
		Map<String , String> SAMPLE = new HashMap<>();
		SAMPLE.put("xferlog" , "aaaa");
		SAMPLE.put("xferlog1" , "aaaa");
		SAMPLE.put("xferlog2" , "aaaa");
		SAMPLE.put("xferlog3" , "aaaa");
		SAMPLE.put("xferlog4" , "aaaa");

		//삭제 1
		System.out.println("================== 1 ==================");
		SAMPLE.remove("xferlog");
		SAMPLE.keySet().stream().forEach(System.out::println);

		//삭제 2
		System.out.println("================== 2 ==================");
		Iterator<Map.Entry<String , String>> iterator = SAMPLE.entrySet().iterator();
		while(iterator.hasNext()){
			if("xferlog3".equals(iterator.next().getKey())){
				iterator.remove();
			}
		}
		SAMPLE.keySet().stream().forEach(System.out::println);

		//삭제 3
		System.out.println("================== 3 ==================");
		SAMPLE.entrySet().removeIf(e->e.getKey().equals("xferlog1"));
		SAMPLE.keySet().stream().forEach(System.out::println);

		//삭제 4
		System.out.println("================== 4 ==================");
		ConcurrentHashMap<String , String> SAMPLE2 = new ConcurrentHashMap<>();
		SAMPLE2.put("xferlog" , "aaaa");
		SAMPLE2.put("xferlog1" , "aaaa");
		SAMPLE2.put("xferlog2" , "aaaa");
		SAMPLE2.put("xferlog3" , "aaaa");
		SAMPLE2.put("xferlog4" , "aaaa");
		for(Map.Entry<String , String> item : SAMPLE2.entrySet()){
			if(item.getKey().equals("xferlog3")){
				SAMPLE2.remove(item.getKey());
			}
		}
		SAMPLE2.keySet().stream().forEach(System.out::println);

	}
	
	public static void main(String[] args) {
		
		try {
//			tst1();

			tst_hashmap();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
