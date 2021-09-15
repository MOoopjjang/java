package com.mooop.m.j8.etc;


class Toy{
	
	@Override
	public String toString() {
		return "I am a Toy";
	}
}


class BoxHandler{
	public static <T extends Toy> void outBox(Box<T> box) {
		Toy t = box.get();
		System.out.println(t.toString());
		
//		box.set(new Toy());
	}
	
	public static void inBox(Box<? super Toy> box , Toy n) {
		box.set(n);
		
//		Toy t = box.get();
	}
}



public class BoundedWildcardBase {
	public static void main(String[] args) {
		Box<Toy> box = new Box<>();
		
		BoxHandler.inBox(box, new Toy());
		BoxHandler.outBox(box);
	}

}
