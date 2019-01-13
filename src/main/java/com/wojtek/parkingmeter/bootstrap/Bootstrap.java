package com.wojtek.parkingmeter.bootstrap;

import com.wojtek.parkingmeter.helpers.TicketType;
import com.wojtek.parkingmeter.model.Ticket;
import com.wojtek.parkingmeter.repositories.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Bootstrap implements CommandLineRunner {

    private final TicketRepository ticketRepository;

    public Bootstrap(TicketRepository ticketRepository) {

        this.ticketRepository = ticketRepository;
    }


    @Override
    public void run(String... args) throws Exception {


        Ticket ticket1 = new Ticket(TicketType.DISABLED, LocalDateTime.of(12,12,12,12,12,12,12), LocalDateTime.now());

        ticketRepository.save(ticket1);

        Ticket ticket2 = new Ticket(TicketType.REGULAR,  LocalDateTime.of(13,12,13,13,13,13,13), LocalDateTime.now());

        ticketRepository.save(ticket2);
    }
}
