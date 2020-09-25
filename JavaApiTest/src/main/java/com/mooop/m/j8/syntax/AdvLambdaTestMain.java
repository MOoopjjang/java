package com.mooop.m.j8.syntax;

import java.util.function.Consumer;

import lombok.Getter;

public class AdvLambdaTestMain {
	
	
	@Getter
	static class Person{
		private String name;
		private int age;
		private String address;
		
		
		private Person(Builder builder) {
			this.name = builder.name;
			this.age = builder.age;
			this.address = builder.address;
		}
		
		public static Builder builder() {
			return new Builder();
		}
		
		
		public static class Builder{
			private String name;
			private int age;
			private String address;
			
			public Builder name(String name) {
				this.name = name;
				return this;
			}
			
			public Builder age(int age) {
				this.age = age;
				return this;
			}
			
			public Builder address(String address) {
				this.address = address;
				return this;
			}
			
			public Person build() {
				return new Person(this);
			}
		}
	}
	
	
	public static<T> void send(Consumer<T> consumer , T object) {
		consumer.accept(object);
	}
	
	
	
	public static void main(String[] args) {
		
		/**
		 *  하나의 Context안에서 객체생성및 처리를 담당하는 고차원 기술
		 */
		send(person->{
					//네트워크 전송처리
				}
				, Person.builder().name("cwkim").age(44).address("seoul").build()
			);
	}

}
