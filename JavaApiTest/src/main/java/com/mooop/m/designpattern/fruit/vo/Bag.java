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

    public long getAmount(){
       return amount;
    }

    public void minusAmount(long mAmount){
        this.amount = this.amount - mAmount;
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

}
