package com.mooop.m.demo.factorybean;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        /** new 로 객체를 생성하지 않고 ComponentManager를 통하여 이미 생성된 객체를 가져온다. */
        PostService postService = (PostService) ComponentManager.getInstance().getBean("postService");
        postService.getUserList().forEach(m->{
            Iterator<String> iterator = m.keySet().iterator();
            while(iterator.hasNext()){
                String k = iterator.next();
                System.out.println("k : "+k+" , v : "+m.get(k));
            }
        });
    }
}
