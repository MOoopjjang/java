package com.mooop.m.designpattern.ticket.step2;

import com.mooop.m.designpattern.ticket.step1.Ticket;

import java.util.Arrays;
import java.util.List;

public class TicketOffice{
    Long amount;
    List<Ticket> ticketList;
    public TicketOffice(Long amount , Ticket... tikes){
        this.amount = amount;
        this.ticketList = Arrays.asList(tikes);
    }

    private Ticket getTicket() throws CloneNotSupportedException {
        Ticket t = ticketList.get(0).clone();
        ticketList.remove(0);
        return t;
    }


    public void sellTicketTo(Audience audience) throws CloneNotSupportedException {
        Ticket ticket = getTicket();
        plusAmount(audience.buy(ticket));
    }


    public void minusAmount(Long amount){
        this.amount -= amount;
    }

    public void plusAmount(Long amount){
        this.amount += amount;
    }
}
