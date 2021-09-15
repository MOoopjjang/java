package com.mooop.m.designpattern.ticket.step1;

public class Ticket implements Cloneable {

    private Long fee;


    public Long getFee(){
        return this.fee;
    }


    @Override
    public Ticket clone() throws CloneNotSupportedException {
        Ticket clone = new Ticket();
        clone.fee = 1000L;
        return clone;
    }
}
