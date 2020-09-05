package JavaApiTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class APIPTest {
	
	
	
	private static void tst_1() throws Exception{
		
		ArrayList<Map<String , Object>> games = new ArrayList<>();
		
		Map<String , Object> m1 = new HashMap<>();
		m1.put("id", "102181142543691610");
		m1.put("state", "completed");
		m1.put("number", 1);
		
		games.add(m1);
		
		m1 = new HashMap<>();
		m1.put("id", "102181142543822683");
		m1.put("state", "completed");
		m1.put("number", 2);
		games.add(m1);
		
		
		m1 = new HashMap<>();
		m1.put("id", "102181142543953756");
		m1.put("state", "unneeded");
		m1.put("number", 3);
		games.add(m1);
		
		System.out.println("size : "+games.size());
		
		
		Optional<Map<String , Object>> rMap = games.stream().filter(m->((String)m.get("state")).equals("unneeded")).findFirst();
		
		if(rMap == null) {
			System.out.println("null");
		}
		
		System.out.println(rMap.isPresent());
		
		
		
	}
	
	
	private static void tst_2() throws Exception{
		
		
		Long l = new Long((long) 13649.3564453125);
		Float f = new Float(13649.3564453125);
		System.out.println(f);
		
		
	}
	
	
	private static void tst_3() throws Exception{
//		ArrayList<Map<String , Object>> al = new ArrayList<>();
		Map<String , Object> m = new HashMap<String , Object>();
		m.put("killerTeamID", 200);
		List<Map<String , Object>> al = Arrays.asList(m);
		
		Integer teamNumber = new Integer(100);
		int count = (int) al.stream().filter(data -> teamNumber.equals((Integer) data.get("killerTeamID"))).count();
		System.out.println("count : "+count);
	}
	
	public static void main(String[] args) throws Exception{
//		tst_1();
		
//		tst_2();
		
		tst_3();
	}

}
