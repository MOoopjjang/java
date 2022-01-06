package com.mooop.m.designpattern.fruit.v0;

import com.mooop.m.designpattern.fruit.vo.Fruit;

public class DiscountV0 {
    private static final int MAX_CUSTOMER_COUNT = 4;


    /**
     * 할인율을 반환한다.
     *
     * @param sFruit
     * @param seq
     * @return
     */
    public int calculateDCPercent(Fruit sFruit , int seq){
        int dc = 0;
         if(sFruit.isNotFresh())dc += 20;

        if(seq == 1)dc+=10;
        if(seq == MAX_CUSTOMER_COUNT)dc+=20;

        return dc;
    }
}
