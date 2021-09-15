package com.mooop.m.j8.mq;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
	
	private String name;
	private Integer age;
	
	
	public Person(String name , int age) {
		this.name = name;
		this.age = new Integer(age);
	}

}
