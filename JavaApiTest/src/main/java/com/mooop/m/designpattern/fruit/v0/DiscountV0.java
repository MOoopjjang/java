package com.mooop.m.designpattern.fruit.v0;

import com.mooop.m.designpattern.fruit.vo.Fruit;

public class DiscountV0 {


    public int getDC(Fruit fruit , CustomerV0 customerV0){
        int dc = 0;
        if(customerV0.isFirstAndLast()){
            dc += 30;
        }else{
            if(customerV0.isFirst()){
                 dc += 10;
            }else if(customerV0.isLast()){
                 dc += 20;
            }
        }

        if(fruit.isNotFresh()){
            dc += 20;
        }


        return dc;
    }
}
