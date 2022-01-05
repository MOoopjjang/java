package com.mooop.m.demo.factorybean;

import java.util.List;
import java.util.Map;

public class OtherService {

    @MResource(name="userService")
    UserService userService;


    public List<Map<String , Object>> getUserList(){
        return userService.getUserList();
    }
}
