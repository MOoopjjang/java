package com.mooop.m.demo.utms;

import lombok.Getter;

@Getter
public class Authentication {

    private String userId;
    private String password;
    private String token;

    public Authentication(String userId, String password, String token) {
        this.userId = userId;
        this.password = password;
        this.token = token;
    }
}
