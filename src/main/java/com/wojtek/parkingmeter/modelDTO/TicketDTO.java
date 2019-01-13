package com.wojtek.parkingmeter.modelDTO;

import com.wojtek.parkingmeter.helpers.TicketType;

public class TicketDTO {


    private TicketType ticketType;

    public TicketDTO() {
    }

    public TicketDTO(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
}
