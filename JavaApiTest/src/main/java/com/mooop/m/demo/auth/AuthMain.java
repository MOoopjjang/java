package com.mooop.m.demo.auth;

public class AuthMain {

    public static void main(String[] args) {

        AuthenticationController ac = new AuthenticationController(
            new UserDetailService()
            , new AuthenticationManager());

        User user = new User("aaa@aaa.com" , "1111" , "김철우" , 30);
        String token = ac.login(user);
        System.out.println("token : "+token);




    }
}
