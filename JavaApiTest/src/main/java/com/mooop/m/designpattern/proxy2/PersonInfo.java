package com.mooop.m.designpattern.proxy2;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonInfo {

    private String name;
    private int age;
    private String address;

    public PersonInfo(String name , int age , String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

}
