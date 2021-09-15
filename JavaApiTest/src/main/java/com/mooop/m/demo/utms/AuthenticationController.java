package com.mooop.m.demo.utms;

import java.util.Optional;

public class AuthenticationController {
    DetailService detailService;
    AuthenticationManager am;
    public AuthenticationController(DetailService detailService , AuthenticationManager am){
        this.detailService = detailService;
        this.am = am;
    }



    public String login(User user){
        if(am.isExist(user.getId())){
            return am.getToken(user.getId());
        }else{
            return Optional.ofNullable(detailService.loadUser(user.getId() , user.getPassword()))
                .map(authentication -> {
                    am.addAuthentication(user.getId() , authentication);
                    return am.getToken(user.getId());
                })
                .orElseGet(()->null);
        }
    }


    public void logout(String id){
        am.removeAuthentication(id);
    }


}
