package com.mooop.m.j8.syntax;

public class EtcTest {
	
	
	private static void tst1() throws Exception{
		
		
		String strNum = "0";
		int v = Integer.parseInt(strNum);
		System.out.println("v : "+v);
	}
	
	public static void main(String[] args) {
		
		try {
			tst1();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
