package com.mooop.m.j8.threadlocal;

import java.util.Date;

public class Tmps {
	
	public static class A{
		
		public void a() {
			Context.local.set(new Date());
			
			System.out.println("A : set Date");
			
			B b = new B();
			b.b();
			
			Context.local.remove();
			
		}
		
	}
	
	
	public static class B{
		public void b() {
			
			Date date = Context.local.get();
			System.out.println("B :: Date : "+date.toString());
			 
			C c = new C();
			c.c();
		}
	}
	
	
	public static class C{
		public void c() {
			Date date = Context.local.get();
			
			System.out.println("c :: Date : "+date.toString());
		}
	}
	
	
	public static void main(String[] args) {
		A a = new A();
		a.a();
	}

}
