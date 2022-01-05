package com.mooop.m.demo.factorybean;

import java.util.*;

@MComponent("postService")
public class PostService {

    @MResource(name="userService")
    private UserService userService;

    public List<Map<String , String>> getPostList(){
        List<Map<String , String>> l = new ArrayList<>();

        Map<String , String> m = new HashMap<>();
        m.put("title" , "aaaaa");
        m.put("content" , "post1");
        l.add(m);

        m = new HashMap<>();
        m.put("title" , "bbbb");
        m.put("content" , "post2");
        l.add(m);

        m = new HashMap<>();
        m.put("title" , "cccc");
        m.put("content" , "post3");
        l.add(m);
        return l;
    }


    public List<Map<String , Object>> getUserList(){
        return userService.getUserList();
    }
}
