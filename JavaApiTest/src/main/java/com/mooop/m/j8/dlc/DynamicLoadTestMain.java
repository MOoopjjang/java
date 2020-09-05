package com.mooop.m.j8.dlc;

public class DynamicLoadTestMain {
	
	
	public Person getInstance() throws Exception{
		
		return (Person) Class.forName(Person.class.getName()).newInstance();
	}
	
	public static void main(String[] args) {
		
		
		
		
	}

}
