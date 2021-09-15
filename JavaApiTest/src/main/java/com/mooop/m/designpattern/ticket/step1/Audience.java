package com.mooop.m.designpattern.ticket.step1;

public class Audience {
    Bag bag;
    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){
        return this.bag;
    }
}
