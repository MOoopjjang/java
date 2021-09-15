package com.mooop.m.demo.fmg;

import lombok.Getter;

@Getter
public class MMessage<T> {
	
	private String mType;
	private T data;
	
	public MMessage(Builder<T> builder) {
		this.mType = builder.mType;
		this.data = builder.data;
	}
	
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder<T>{
		private String mType;
		private T data;
		
		public Builder<T> type(String type) {
			this.mType = type;
			return this;
		}
		
		public Builder<T> data(T data){
			this.data = data;
			return this;
		}
		
		public MMessage<T> build(){
			return new MMessage(this);
		}
	}

}
