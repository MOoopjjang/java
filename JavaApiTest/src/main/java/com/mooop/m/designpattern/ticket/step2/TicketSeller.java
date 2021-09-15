package com.mooop.m.designpattern.ticket.step2;

import com.mooop.m.designpattern.ticket.step2.Audience;
import com.mooop.m.designpattern.ticket.step1.Ticket;
import com.mooop.m.designpattern.ticket.step2.TicketOffice;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }


    public void sellTo(Audience audience) throws CloneNotSupportedException {
        ticketOffice.sellTicketTo(audience);
    }
}
