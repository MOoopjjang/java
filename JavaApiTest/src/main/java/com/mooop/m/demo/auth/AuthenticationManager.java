package com.mooop.m.demo.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AuthenticationManager {
    private final Map<String , Authentication> mm = new HashMap<>();



    public boolean isExist(String id){
        return mm.containsKey(id);
    }

    public void addAuthentication(String id , Authentication authentication){
        mm.put(id , authentication);
    }


    public String getToken(String id){
        return Optional.ofNullable(mm.get(id))
            .map(authentication -> authentication.getToken())
            .orElseGet(()->null);

    }


    public void removeAuthentication(String id){
        if(mm.containsKey(id)){
            mm.remove(id);
        }
    }



}
