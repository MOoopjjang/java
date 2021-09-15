package com.mooop.m.designpattern.proxy2;

import java.util.HashMap;
import java.util.Map;

/***
 *  Cache 용도의 Proxy 객체
 *   - 실제 PersonController에서의 조회는 cost가 큰 작업이며 , 때문에 한번 조회된 결과는
 *     Proxy 객체의 cache에 저장하여 조회결과를 빠르게 응답하게 한다.
 *     (   Cache Proxy )
 */
public class ProxyPerson implements IPerson{
    PersonController personController;
    Map<String , PersonInfo> cache = null;
    public ProxyPerson(){
        /** real object */
        personController = new PersonController();

        /** 한번 조회된 결과를 저장하는 cache */
        cache = new HashMap<>();
    }

    @Override
    public PersonInfo getPersonInfo(String name) {
        /**
         *  cache에  요청된 정보가 존재하지 않으면 , real object에 해당조회를 요청한다.
         */
        if(cache.isEmpty() || !cache.containsKey(name)){
            cache.put(name , personController.getPersonInfo(name));
        }
        return cache.get(name);
    }

    @Override
    public void setPersonInfo(PersonInfo p) {
        personController.setPersonInfo(p);
    }
}
