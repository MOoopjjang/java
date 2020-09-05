package com.mooop.m.j8.etc;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 제네릭 제한 테스트
 * 
 * @author MOoop
 *
 */
class Human{
	public String skinColor;
	
	@Override
	public String toString() {
		return "Human";
	}
}

class Man extends Human{
	public String national;
	
	
}


class Bhkim extends Man{
	public String address;
}



class Boxer{
	
	//Bhkim -> Man -> Human
	public static<T extends Man> void setList(List<T> l) {
		
	}
	
	
	public static void setSuper(List<? super Man> l) {
		
	}
}



public class UpperBoundWildcard {
	
	public static void main(String[] args) {
		
		List<Human> hList = new ArrayList<>();
		List<Man> mList = new ArrayList<>();
		List<Bhkim> bList = new ArrayList<>();
		
		
		Boxer.setList(bList);
//		Boxer.setList(hList);
		
		Boxer.setSuper(hList);
//		Boxer.setSuper(bList);
		
	}

}
