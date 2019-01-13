package com.wojtek.parkingmeter.bootstrap;

import com.wojtek.parkingmeter.helpers.TicketType;
import com.wojtek.parkingmeter.modelDAO.TicketDAO;
import com.wojtek.parkingmeter.repositories.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Bootstrap implements CommandLineRunner {

    private final TicketRepository ticketRepository;

    public Bootstrap(TicketRepository ticketRepository) {

        this.ticketRepository = ticketRepository;
    }


    @Override
    public void run(String... args) throws Exception {


        TicketDAO ticket1 = new TicketDAO(TicketType.DISABLED, new Timestamp(2019,1,1,15,12,3,0), new Timestamp(2019,1,1,15,15,3,0));

        ticketRepository.save(ticket1);

        TicketDAO ticket2 = new TicketDAO(TicketType.REGULAR, new Timestamp(2018,11,1,15,12,3,0), new Timestamp(2019,1,1,15,15,3,0));

        ticketRepository.save(ticket2);
    }
}
