package com.wojtek.parkingmeter.bootstrap;

import com.wojtek.parkingmeter.helpers.ChargeCalculator;
import com.wojtek.parkingmeter.helpers.TicketType;
import com.wojtek.parkingmeter.model.Ticket;
import com.wojtek.parkingmeter.repositories.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class Bootstrap implements CommandLineRunner {

    private final TicketRepository ticketRepository;

    public Bootstrap(TicketRepository ticketRepository) {

        this.ticketRepository = ticketRepository;
    }


    @Override
    public void run(String... args) throws Exception {


        Ticket ticket1 = new Ticket(TicketType.DISABLED, LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.now());

        ticket1.setCharge(ChargeCalculator.charge(ticket1.getTicketType(), Duration.between(ticket1.getStampStop(),ticket1.getStampStart())));

        ticketRepository.save(ticket1);

        Ticket ticket2 = new Ticket(TicketType.REGULAR,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.now());

        ticket2.setCharge(ChargeCalculator.charge(ticket2.getTicketType(), Duration.between(ticket2.getStampStop(),ticket2.getStampStart())));

        ticketRepository.save(ticket2);
    }
}
