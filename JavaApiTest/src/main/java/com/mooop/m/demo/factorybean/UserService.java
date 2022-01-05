package com.mooop.m.demo.factorybean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MComponent("userService")
public class UserService {

    public List<Map<String , Object>> getUserList(){
        List<Map<String , Object>> l = new ArrayList<>();

        Map<String , Object> m = new HashMap<>();
        m.put("name" , "홍길동");
        m.put("age" , 45);
        l.add(m);

        m = new HashMap<>();
        m.put("name" , "mike");
        m.put("age" , 50);
        l.add(m);

        m = new HashMap<>();
        m.put("name" , "james");
        m.put("age" , 43);
        l.add(m);
        return l;
    }
}
