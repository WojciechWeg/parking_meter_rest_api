package com.wojtek.parkingmeter.modelDAO;


import com.wojtek.parkingmeter.helpers.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="ticket")
@Setter
@Getter
public class TicketDAO {

    public TicketDAO(TicketType ticketType, Timestamp stampStart, Timestamp stampStop) {
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
    private Timestamp stampStart;

    @Column(name="stamp_stop")
    private Timestamp stampStop;


}
