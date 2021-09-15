package com.mooop.m.j8.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mooop.m.j8.etc.SortTst.Person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class SortTst {
	
	
	@Getter
	@Setter
	@ToString
	@NoArgsConstructor
	static class Person implements Comparable<Person>{
		private String name;
		private int age;
		
		public Person(String _name , int _age) {
			this.name = _name;
			this.age = _age;
		}

		@Override
		public int compareTo(Person o) {
			return o.getAge() - getAge();
		}
	}
	
	
	@Getter
	@Setter
	@ToString
	@NoArgsConstructor
	static class Player{
		String name;
		int age;
		
		public Player(String _name , int _age) {
			this.name = _name;
			this.age = _age;
		}
	}
	
	
	
	private static void ComparableTest() {
		List<Person> persons = Arrays.asList(new Person("cwkim" , 20) , new Person("khlee" , 40) , new Person("bhkim" , 10)).stream()
				.collect(Collectors.toList());
		
		Collections.sort(persons);
		System.out.println(persons);
	}
	
	
	private static void ComparatorTest() {
		List<Player> players = Arrays.asList(new Player("cwkim" , 20) , new Player("khlee" , 40) , new Player("bhkim" , 10)).stream()
				.sorted((a,b)->b.getAge()-a.getAge())
				.collect(Collectors.toList());
		
//		Comparator<Player> comparator = (o1,o2)->o1.getAge()-o2.getAge();
//		Collections.sort(players , comparator);
		System.out.println(players);
		
		
	}
	
	private static void CompareTest() {
		List<Person> persons = Arrays.asList(new Person("cwkim" , 20) , new Person("khlee" , 40) , new Person("bhkim" , 10))
				.stream()
				.sorted((s1,s2)->s2.compareTo(s1))
				.collect(Collectors.toList());
		
		persons.stream().forEach(p->{
			System.out.println(p.toString());
		});
	}
	
	
	private static void sortTst1() {
		List<Person> persons = Arrays.asList(new Person("cwkim" , 20) , new Person("khlee" , 40) , new Person("bhkim" , 30)).stream()
				.collect(Collectors.toList());
		
		List<Person> olderThan20 = persons.stream().filter(p->p.getAge() > 20)
									.collect(ArrayList::new , ArrayList::add , ArrayList::addAll);
		
		for(Person p : olderThan20) {
			System.out.println(p.toString());
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		
//		ComparableTest();
		
//		ComparatorTest();
		
//		CompareTest();
		
		sortTst1();
	}

}
