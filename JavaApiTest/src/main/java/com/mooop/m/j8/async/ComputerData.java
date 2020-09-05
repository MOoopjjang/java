package com.mooop.m.j8.async;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;


public class ComputerData {
	
	
	private String computerPartName;
	
	private long computerPartPrice;
	
	
	public ComputerData(String _partName , long _partPrice){
		this.computerPartName = _partName;
		this.computerPartPrice = _partPrice;
	}


	public String getComputerPartName() {
		return computerPartName;
	}


	public long getComputerPartPrice() {
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return computerPartPrice;
	}
	
	
	@Override
	public String toString() {
		return "computerPartName : "+computerPartName+" , computerPartPrice : "+computerPartPrice;
	}

}
