package com.mooop.m.j8.etc;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class TestMain1 {
	
	
	private static void tst_obserable() throws Exception{
		class MyObservable extends Observable{
			public void run(){
				for(int i = 0 ; i < 10 ; i++){
					setChanged();
					notifyObservers(i);
				}
			}
			
		}
		
		
		class IntObserver implements Observer{

			@Override
			public void update(Observable o, Object arg) {
				System.out.println("arg :"+(Integer)arg);
				
			}
			
		}
		
		MyObservable mo = new MyObservable();
		mo.addObserver(new IntObserver());
		
		mo.run();
		
		
	}
	
	
	private static void tst_iterable() throws Exception{
		// Iterable ( Pull )
		Iterable<String> iterable = ()->{

			Iterator<String> iter = new Iterator<String>(){
				
				String[] arr = {"xferlog" , "kknda" , "abc" , "dist" , "bhkim"};
				int MAX = arr.length;
				int index = 0;

				@Override
				public boolean hasNext() {
					return index < MAX;
				}

				@Override
				public String next() {
					String result = arr[index];
					index++;
					return result;
				}
				
			};
			
			return iter;
		};
		
		
		for(String i:iterable){    //for-each
			System.out.println(i);
		}
	}
	
	
	public static void etc_tst() {
		
		
		Employee e = Employee.Factory.build();
		e.youAreFired();
		
	}
	
	public static void main(String[] args) {
		try{
//			tst_iterable();
			
//			tst_obserable();
			
			etc_tst();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
