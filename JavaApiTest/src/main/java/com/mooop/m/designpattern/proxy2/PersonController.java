package com.mooop.m.designpattern.proxy2;

import java.util.HashMap;
import java.util.Map;

public class PersonController implements IPerson{
    Object monitor = new Object();
    Map<String , PersonInfo> dataMap = null;

    public PersonController(){
        dataMap = new HashMap<>();
    }

    @Override
    public PersonInfo getPersonInfo(String name) {
        System.out.print("==== getPersonInfo ==== ");
        /***
         * 실제로는 DB or Network 연동
         */
        synchronized(monitor){
            try{
                Thread.sleep(5*1000L);
            }catch(Exception e){}

        }
        return dataMap.get(name);
    }

    @Override
    public void setPersonInfo(PersonInfo p) {
        synchronized (monitor){
            dataMap.put(p.getName() , p);
        }
    }
}
