package com.mooop.m.j8.etc;

import java.util.Iterator;

public class IterTestMain {
	
	
	static class PMember<T>{
		private int index = 0 , start = 0;
		private Object[] array = new Object[1024];
		
		
		public PMember<T> setData(T _d) {
			array[index] = _d;
			index++;
			return this;
		}
		
		public Iterator<T> getPIterator(){
			start = 0;
			return new Iterator<T>() {
				@Override
				public boolean hasNext() {
					return start < index;
				}
				
				@Override
				public T next() { 
					T retData = (T) array[start];
					start++;
					return retData;
				}
				
			};
		}
	}
	
	
	public static void main(String[] args) {
		PMember<String> pmember = new PMember<>();
		pmember.setData("xferlog").setData("kknda").setData("kcwda");
		
		
		Iterator<String> iterator = pmember.getPIterator();
		while(iterator.hasNext()) {
			String d = iterator.next();
			System.out.println("d : "+d);
		}
	}

}
