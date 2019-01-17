package com.wojtek.parkingmeter.bootstrap;

import com.wojtek.parkingmeter.helpers.ChargeCalculator;
import com.wojtek.parkingmeter.helpers.TicketType;
import com.wojtek.parkingmeter.model.Car;
import com.wojtek.parkingmeter.model.Ticket;
import com.wojtek.parkingmeter.repositories.CarRepository;
import com.wojtek.parkingmeter.repositories.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Bootstrap implements CommandLineRunner {

    private final TicketRepository ticketRepository;
    private final CarRepository carRepository;

    public Bootstrap(TicketRepository ticketRepository, CarRepository carRepository) {

        this.ticketRepository = ticketRepository;
        this.carRepository = carRepository;
    }


    @Override
    public void run(String... args) throws Exception {


        load_tickets();


        load_cars();
    }

    private void load_cars() {
        Car car1 = new Car();
        car1.setNr_plate("00000");

        carRepository.save(car1);
    }

    private void load_tickets() {
        Ticket ticket1 = new Ticket(TicketType.REGULAR, LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,19,30,00,00));

        ticket1.setCharge(ChargeCalculator.charge(ticket1.getTicketType(), ticket1.getDuration()));

        ticketRepository.save(ticket1);

        Ticket ticket2 = new Ticket(TicketType.REGULAR,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,20,01,00,00));

        ticket2.setCharge(ChargeCalculator.charge(ticket2.getTicketType(),ticket2.getDuration()));

        ticketRepository.save(ticket2);


        Ticket ticket3 = new Ticket(TicketType.REGULAR,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,21,01,00,00));

        ticket3.setCharge(ChargeCalculator.charge(ticket3.getTicketType(), ticket3.getDuration()));

        ticketRepository.save(ticket3);

        Ticket ticket4 = new Ticket(TicketType.REGULAR,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,22,01,00,00));

        ticket4.setCharge(ChargeCalculator.charge(ticket4.getTicketType(), ticket4.getDuration()));

        ticketRepository.save(ticket4);


        Ticket ticket5 = new Ticket(TicketType.DISABLED, LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,19,30,00,00));

        ticket5.setCharge(ChargeCalculator.charge(ticket5.getTicketType(),ticket5.getDuration()));

        ticketRepository.save(ticket5);

        Ticket ticket6 = new Ticket(TicketType.DISABLED,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,20,01,00,00));

        ticket6.setCharge(ChargeCalculator.charge(ticket6.getTicketType(),ticket6.getDuration()));

        ticketRepository.save(ticket6);


        Ticket ticket7 = new Ticket(TicketType.DISABLED,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,21,01,00,00));

        ticket7.setCharge(ChargeCalculator.charge(ticket7.getTicketType(), ticket7.getDuration()));

        ticketRepository.save(ticket7);

        Ticket ticket8 = new Ticket(TicketType.DISABLED,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,22,01,00,00));

        ticket8.setCharge(ChargeCalculator.charge(ticket8.getTicketType(), ticket8.getDuration()));

        ticketRepository.save(ticket8);
    }
}
