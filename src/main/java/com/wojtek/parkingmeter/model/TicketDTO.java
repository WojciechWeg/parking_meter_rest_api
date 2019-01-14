package com.wojtek.parkingmeter.model;

import com.wojtek.parkingmeter.helpers.TicketType;


import java.time.LocalDateTime;


public class TicketDTO {


    public TicketDTO() {
    }

    public TicketDTO(TicketType ticketType, double charge, LocalDateTime stampStart, LocalDateTime stampStop) {
        this.ticketType = ticketType;
        this.charge = charge;
        this.stampStart = stampStart;
        this.stampStop = stampStop;
    }

    private TicketType ticketType;

    private double charge;

    private LocalDateTime stampStart;

    private LocalDateTime stampStop;

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public LocalDateTime getStampStart() {
        return stampStart;
    }

    public void setStampStart(LocalDateTime stampStart) {
        this.stampStart = stampStart;
    }

    public LocalDateTime getStampStop() {
        return stampStop;
    }

    public void setStampStop(LocalDateTime stampStop) {
        this.stampStop = stampStop;
    }
}
