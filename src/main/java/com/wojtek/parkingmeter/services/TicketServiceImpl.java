package com.wojtek.parkingmeter.services;

import com.wojtek.parkingmeter.helpers.*;
import com.wojtek.parkingmeter.mapper.TicketMapper;
import com.wojtek.parkingmeter.model.Car;
import com.wojtek.parkingmeter.model.Ticket;
import com.wojtek.parkingmeter.model.TicketDTO;
import com.wojtek.parkingmeter.repositories.CarRepository;
import com.wojtek.parkingmeter.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final CarRepository carRepository;
    private final TicketMapper ticketMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TicketServiceImpl(TicketRepository ticketRepository, CarRepository carRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.carRepository = carRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public TicketDTO startTicket(String ticket_type, String nr_plate) {

        Ticket newTicket = new Ticket( TicketType.valueOf(ticket_type.toUpperCase()), LocalDateTime.now(), LocalDateTime.of(0,1,1,0,0,0,0));
        Car car = new Car(nr_plate);
        car.addTicket(newTicket);
        carRepository.save(car);

        ticketRepository.save(newTicket);

        return ticketMapper.ticketToTicketDTO(newTicket);
    }

    @Override
    public Ticket stopTicket(Long id) {

         Optional<Ticket> stopTicketOpt = ticketRepository.findById(id);

         Ticket stopTicket = stopTicketOpt.get();
         stopTicket.setStampStop(LocalDateTime.now());

        stopTicket.setCharge(ChargeCalculator.charge(stopTicket.getTicketType(), Duration.between(stopTicket.getStampStop(),stopTicket.getStampStart())));

        return ticketRepository.save(stopTicket);

    }

    @Override
    public ChargeJSON checkCharge(Long id) {

        Optional<Ticket> ticketOptional = ticketRepository.findById(id);


        Ticket ticket = ticketOptional.get();
        ticket.setStampStop(LocalDateTime.now());

        TicketType ticketType = ticket.getTicketType();
        Duration duration = Duration.between(ticket.getStampStop(),ticket.getStampStart());

        ChargeJSON chargeJSON = new ChargeJSON(ChargeCalculator.charge(ticketType,duration));

        return chargeJSON;
    }

    @Override
    public SumJSON checkSum() {

        Double sum = jdbcTemplate.queryForObject("SELECT sum(charge) FROM TICKET", Double.class );
        SumJSON sumJSON = new SumJSON(sum);

        return sumJSON;
    }

    @Override
    public HasStartedJSON hasStarted() {




        return null;
    }
}
