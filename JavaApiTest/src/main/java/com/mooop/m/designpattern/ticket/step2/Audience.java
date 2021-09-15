package com.mooop.m.designpattern.ticket.step2;

import com.mooop.m.designpattern.ticket.step2.Bag;
import com.mooop.m.designpattern.ticket.step1.Ticket;

public class Audience {
    Bag bag;
    public Audience(Bag bag){
        this.bag = bag;
    }


   public Long buy(Ticket ticket){
        return bag.hold(ticket);
   }

}
