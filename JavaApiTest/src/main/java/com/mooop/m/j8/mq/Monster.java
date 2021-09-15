package com.mooop.m.j8.mq;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Monster {
	
	private String kind;
	
	private String weapone;
	
	private String area;
	
	public Monster(String k , String w , String area) {
		this.kind = k;
		this.weapone = w;
		this.area = area;
	}
	

}
