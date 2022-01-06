package com.mooop.m.designpattern.fruit.vo;

import java.util.Arrays;
import java.util.List;

public class Bag {
    private long amount;
    private List<Fruit> fruits;
    private int seq;


    public Bag(long amount){
        this.amount = amount;
    }

    public Bag(){
        this(10000L);
    }


    /**
     * 소지한 돈에서 과일값을 지불한다.
     *
     * @param reqAmount
     * @return
     */
    public long hold(long reqAmount){
        if(amount < reqAmount)return -1;
        minusAmount(reqAmount);
        return reqAmount;
    }



    public void addFruits(Fruit... fruits){
        this.fruits = Arrays.asList(fruits);
    }

    public int getSeq(){
        return this.seq;
    }

    public void setSeq(int seq){
        this.seq = seq;
    }

    private void minusAmount(long mAmount){
        this.amount = this.amount - mAmount;
    }
}
