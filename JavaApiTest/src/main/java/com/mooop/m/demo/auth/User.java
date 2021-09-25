package com.mooop.m.demo.auth;


import lombok.Getter;

@Getter
public class User {

    private String id;
    private String password;
    private String username;
    private int age;


    public User(String id, String password, String username, int age) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.age = age;
    }
}
