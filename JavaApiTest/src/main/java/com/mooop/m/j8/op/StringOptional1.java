package com.mooop.m.j8.op;

import java.util.Optional;

import lombok.Getter;


@Getter
class ContInfo{
	private String phone;
	private String adrs;
	
	public ContInfo(String ph , String ad) {
		this.phone = ph;
		this.adrs = ad;
	}
}




public class StringOptional1 {
	
	//map
	private static void tst_3() throws Exception{
		Optional<String> os1 = Optional.of("opitonal String");
		Optional<String> os2 = os1.map(String::toUpperCase);
		
		System.out.println(os2.get());
		
		Optional<String> os3 = os1.map(s->s.replace(' ', '_')).map(String::toLowerCase);
		System.out.println(os3.get());
	}
	
	
	private static void tst_2() throws Exception{
		ContInfo con = new ContInfo("111222333" , null);
		
		String p;
		String a;
		
		/* as-is
		if(con.getPhone() != null) {
			p = con.getPhone();
		}else {
			p = "There is no phone number.";
		}
		
		if(con.getAdrs() != null) {
			a = con.getAdrs();
		}else {
			a = "There is no address.";
		}
		*/
		
		
		/* to-be */ 
		p = Optional.ofNullable(con.getPhone()).map(String::toString).orElse("There is no phone number.");
		a = Optional.ofNullable(con.getAdrs()).map(String::toString).orElse("There is no address.");
		
		
		System.out.println(p);
		System.out.println(a);
	}


	
	private static void tst_1() throws Exception{
		Optional<String> op1 = Optional.of(new String("xferlog"));
//		Optional<String> op1 = Optional.of(null);
		Optional<String> op2 = Optional.ofNullable(null);
		
		if(op1.isPresent()) {
			System.out.println(op1.get());
		}
		
		if(op2.isPresent()) {
			System.out.println(op2.get());
		}
		
		op1.ifPresent(System.out::println);
		op2.ifPresent(System.out::println);
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		try {
//			tst_1();
			
			tst_2();
			
//			tst_3();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
