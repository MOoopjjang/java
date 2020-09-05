package com.mooop.m.j8.reflect;

public class Person {
	
	
	private String name;
	
	private Integer age;
	
	
	public Person(String name , int age) {
		this.name = name;
		this.age = new Integer(age);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return age.intValue();
	}
	
	
	@Override
	public String toString() {
		return "name :"+this.name+" , age : "+this.age.intValue();
	}

}
