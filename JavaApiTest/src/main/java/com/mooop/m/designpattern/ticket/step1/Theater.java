package com.mooop.m.designpattern.ticket.step1;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }


    public void enter(Audience audience) throws CloneNotSupportedException {

        if(audience.getBag().hasInvitation()){
            audience.getBag().setTicket(ticketSeller.getTicketOffice().getTicket());
        }else{
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
