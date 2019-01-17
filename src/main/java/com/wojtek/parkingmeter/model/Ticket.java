package com.wojtek.parkingmeter.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wojtek.parkingmeter.helpers.ChargeCalculator;
import com.wojtek.parkingmeter.helpers.TicketType;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name="tickets")

public class Ticket {

    public Ticket() {
    }

    public Ticket(TicketType ticketType, LocalDateTime stampStart, LocalDateTime stampStop) {
        this.ticketType = ticketType;
        this.stampStart = stampStart;
        this.stampStop = stampStop;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name="ticket_type")
    private TicketType ticketType;

    @Column(name="charge")
    private double charge;

    @Column(name="stamp_start")
    private LocalDateTime stampStart;

    @Column(name="stamp_stop")
    private LocalDateTime stampStop;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "car_id")
    @JsonIgnoreProperties
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void countCharge() { setCharge(ChargeCalculator.charge(getTicketType(), getDuration())); }

    public Duration getDuration(){ return Duration.between(stampStart,stampStop); }
}
