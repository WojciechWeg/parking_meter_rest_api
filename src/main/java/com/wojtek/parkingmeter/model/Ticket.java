package com.wojtek.parkingmeter.model;


import com.wojtek.parkingmeter.helpers.TicketType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tickets")
@Setter
@Getter
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




}
