package com.mooop.m.designpattern.ticket.step1;

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


//    public void setAmount(Long amount){
//        this.amount = amount;
//    }


    public boolean hasInvitation(){
        return inVitation!=null;
    }

    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }


    public Ticket getTicket(){
        return this.ticket;
    }

    public void minusAmount(Long amount){
        this.amount -= amount;
    }

    public void plusAmount(Long amount){
        this.amount += amount;
    }


}
