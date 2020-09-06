package com.mooop.m.demo.fmg;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author mooopjjang
 *
 */
public class FmInfo {
	
	private String path;
	private String searchText;
	

	public FmInfo(Builder builder) {
		this.path = builder.path;
		this.searchText = builder.searchText;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getPath() {
		return this.path;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getSearchText(){
		return Arrays.asList(this.path.split("\\|"));
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static Builder budiler() {
		return new Builder();
	}
	
	
	
	public static class Builder{
		private String path;
		private String searchText;
		
		public Builder path(String path) {
			this.path = path;
			return this;
		}
		
		public Builder search(String text) {
			this.searchText = text;
			return this;
		}
		
		public FmInfo build() {
			return new FmInfo(this);
		}
	}
	
}
