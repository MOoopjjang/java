package com.mooop.m.designpattern.ticket.step2;

import com.mooop.m.designpattern.ticket.step1.InVitation;
import com.mooop.m.designpattern.ticket.step1.Ticket;

public class Bag {

    private InVitation inVitation = null;
    private Ticket ticket = null;
    private Long amount;


    public Bag(Long amount){
        this.amount = amount;
    }

    public Bag(Long amount , InVitation inVitation){
        this.amount = amount;
        this.inVitation = inVitation;
    }



    public Long hold(Ticket ticket){
        if(inVitation != null){
            this.ticket = ticket;
            return 0L;
        }else{
            minusAmount(ticket.getFee());
            this.ticket = ticket;
            return ticket.getFee();
        }
    }



    public void minusAmount(Long amount){
        this.amount -= amount;
    }

    public void plusAmount(Long amount){
        this.amount += amount;
    }
}
