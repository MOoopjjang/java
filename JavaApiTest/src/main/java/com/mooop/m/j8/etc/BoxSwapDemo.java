package com.mooop.m.j8.etc;

public class BoxSwapDemo {
	
	
	private static class Box<T>{
		private T obj;
		public void set(T _d) {this.obj = _d;}
		public T get() { return this.obj;} 
	}
	
	
	
	private static <T extends Number>  void swap(Box<T> left , Box<T> right) {
		
		
		Box<T> tmpBox = new Box<>();
		tmpBox.set(left.get());
		
		
		left.set(right.get());
		right.set(tmpBox.get());
		
	}
	
	public static void main(String[] args) {
		
		Box<Integer> b1 = new Box<>();
		b1.set(new Integer(10));
		
		Box<Integer> b2 = new Box<>();
		b2.set(new Integer(5));
		
		System.out.println("b : "+b1.get().intValue()+" , b2 : "+b2.get().intValue());
		swap(b1 , b2);
		
		System.out.println("b : "+b1.get().intValue()+" , b2 : "+b2.get().intValue());
		
	}

}
