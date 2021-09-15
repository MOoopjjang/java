package com.mooop.m.designpattern.ticket.step1;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {

    Long amount;
    List<Ticket> ticketList;
    public TicketOffice(Long amount , Ticket... tikes){
        this.amount = amount;
        this.ticketList = Arrays.asList(tikes);
    }

    public Ticket getTicket() throws CloneNotSupportedException {
        Ticket t = ticketList.get(0).clone();
        ticketList.remove(0);
        return t;
    }


    public void minusAmount(Long amount){
        this.amount -= amount;
    }

    public void plusAmount(Long amount){
        this.amount += amount;
    }
}
