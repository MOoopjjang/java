package com.mooop.m.j8.reflect;

public class Job {
	
	private String job;
	
	private Long price;
	
	private String kind;
	
	
	public Job(String job , long price , String kind) {
		this.job = job;
		this.price = new Long(price);
		this.kind = kind;
	}
	
	
	public String getJob() {
		return this.job;
	}
	
	public long getPrice() {
		return this.price.longValue();
	}
	
	public String getKind() {
		return this.kind;
	}
	
	@Override
	public String toString() {
		return "job : "+this.job+" , price : "+this.price.longValue()+" , kind : "+this.kind;
	}

}
