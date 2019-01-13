package com.wojtek.parkingmeter.services;

import com.wojtek.parkingmeter.helpers.ChargeJSON;
import com.wojtek.parkingmeter.helpers.HasStartedJSON;
import com.wojtek.parkingmeter.helpers.SumJSON;
import com.wojtek.parkingmeter.helpers.TicketType;
import com.wojtek.parkingmeter.model.Ticket;
import com.wojtek.parkingmeter.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;



    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket startTicket(String ticket_type) {

        Ticket newTicket = new Ticket( TicketType.valueOf(ticket_type.toUpperCase()), LocalDateTime.now(), LocalDateTime.of(0,1,1,0,0,0,0));

        return  ticketRepository.save(newTicket);

    }

    @Override
    public Ticket stopTicket(Long id) {

         Optional<Ticket> stopTicketOpt = ticketRepository.findById(id);

         Ticket stopTicket = stopTicketOpt.get();
         stopTicket.setStampStop(LocalDateTime.now());

        //set charge here


        return ticketRepository.save(stopTicket);

    }

    @Override
    public ChargeJSON checkCharge(Long id) {
        return null;
    }

    @Override
    public SumJSON checkSum() {
        return null;
    }

    @Override
    public HasStartedJSON hasStarted() {
        return null;
    }
}
