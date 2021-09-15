package com.mooop.m.designpattern.ticket.step2;

import com.mooop.m.designpattern.ticket.step2.Audience;

public class Theater {
    TicketSeller ticketSeller;
    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }

    public TicketSeller getTicketSeller(){
        return this.ticketSeller;
    }

    public void enter(Audience audience) throws CloneNotSupportedException {
        ticketSeller.sellTo(audience);
    }

}
