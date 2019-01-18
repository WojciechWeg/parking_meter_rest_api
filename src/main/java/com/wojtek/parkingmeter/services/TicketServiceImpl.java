package com.wojtek.parkingmeter.services;

import com.wojtek.parkingmeter.helpers.*;
import com.wojtek.parkingmeter.helpers.enums.HasStartedEnum;
import com.wojtek.parkingmeter.helpers.enums.TicketType;
import com.wojtek.parkingmeter.mapper.TicketMapper;
import com.wojtek.parkingmeter.model.Car;
import com.wojtek.parkingmeter.model.Ticket;

import com.wojtek.parkingmeter.model.TicketDTO;
import com.wojtek.parkingmeter.repositories.CarRepository;
import com.wojtek.parkingmeter.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
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

         stopTicket.countCharge();


        if(!(stopTicket.getCar()==null)) {
            Long id_car = stopTicket.getCar().getId();
            carRepository.deleteById(id_car);
        }



        stopTicket.setCar(null);

         return ticketRepository.save(stopTicket);

    }

    @Override
    public String checkCharge(Long id) {

        Optional<Ticket> ticketOptional = ticketRepository.findById(id);


        Ticket ticket = ticketOptional.get();

        if(!(ticket.getCar()==null))
            ticket.setStampStop(LocalDateTime.now());

        TicketType ticketType = ticket.getTicketType();


        String charge =  Double.toString(ChargeCalculator.charge(ticketType, ticket.getDuration()));

        return charge;
    }

    @Override
    public SumJSON checkSum() {

        Double sum = jdbcTemplate.queryForObject("SELECT sum(charge) FROM TICKETS", Double.class );
        SumJSON sumJSON = new SumJSON(sum);

        return sumJSON;
    }

    @Override
    public HasStartedJSON hasStarted(String nr_plate) {

        HasStartedJSON hasStartedJSON = new HasStartedJSON(HasStartedEnum.YES);

        Integer id = new Integer(0);

        try {
            // pobierz id samochodu którego znamy numery tablicy rejestracujnej
             id = jdbcTemplate.queryForObject(
                    "SELECT ID FROM CARS WHERE NR_PLATE = \'"+ nr_plate +"\'", Integer.class);
        }catch (EmptyResultDataAccessException e){
            hasStartedJSON.setHasStarted(HasStartedEnum.NO);
        }


        Integer ticketID  = new Integer(0);
        // pobierzmy id biletu takiego samochodu
        try {
            ticketID = jdbcTemplate.queryForObject("SELECT ID FROM TICKETS WHERE CAR_ID = "+ id+"" ,Integer.class );
        }catch (EmptyResultDataAccessException e){
            // jesli ticketID == null to znaczy że auto jest na parkingu bez biletu
            if(ticketID.equals(0))
                hasStartedJSON.setHasStarted(HasStartedEnum.NO);
            // jeśłi ticketID != null to znaczy że auto ma bilet

        }

        if(!ticketID.equals(0))
            hasStartedJSON.setHasStarted(HasStartedEnum.YES);

        return hasStartedJSON;
    }
}
