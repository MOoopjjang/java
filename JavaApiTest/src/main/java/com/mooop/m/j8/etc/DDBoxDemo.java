package com.mooop.m.j8.etc;

public class DDBoxDemo {
	
	
	
	private static class DBox<L extends Fruit , R extends Fruit>{
		L left;
		R right;
		
		public void set(L left , R right) {
			this.left = left;
			this.right = right;
		}
		
		@Override
		public String toString() {
			return left.toString() + " & "+right.toString();
		}
	
	}
	
	
	private static class Fruit{
		String kind;
		Integer count;
		
		public Fruit(String kind , Integer count) {
			this.kind = kind;
			this.count = count;
		}
		
		@Override
		public String toString() {
			return this.kind+":"+this.count.intValue();
		}
	}
	
	
	private static class Apple extends Fruit{
		String color;

		public Apple(String kind, Integer count , String color) {
			super(kind, count);
			this.color = color;
		}
		
		@Override
		public String toString() {
			return super.toString() + ":"  +this.color;
		}
		
	}
	
	
	private static class Orange extends Fruit{
		Integer price;

		public Orange(String kind, Integer count , Integer price) {
			super(kind, count);
			this.price = price;
		}
		
		@Override
		public String toString() {
			return super.toString() + ":"  +this.price.intValue();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		Apple apple = new Apple("apple" , new Integer(25) , "blue");
		Orange orange = new Orange("orange" , new Integer(10) , new Integer(1000));
		
//		Fruit apple = new Fruit("apple" , new Integer(25));
//		Fruit orange = new Fruit("orange" , new Integer(10));
		
		
		
		DBox<Fruit , Fruit> box = new DBox<>();
		box.set(apple, orange);
		System.out.println(box.toString());
		
		
	}

}
