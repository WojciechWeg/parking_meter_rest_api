package com.wojtek.parkingmeter.bootstrap;

import com.wojtek.parkingmeter.helpers.ChargeCalculator;
import com.wojtek.parkingmeter.helpers.TicketType;
import com.wojtek.parkingmeter.model.Car;
import com.wojtek.parkingmeter.model.Ticket;
import com.wojtek.parkingmeter.repositories.CarRepository;
import com.wojtek.parkingmeter.repositories.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
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
        Car car1 = new Car("Toyota","Corolla","WI23123");
        carRepository.save(car1);

        Car car2 = new Car("BMW","3","LU45230");
        carRepository.save(car2);

        Car car3 = new Car("Jaguar","XJ","WT00920");
        carRepository.save(car3);

        Car car4 = new Car("Ford","Focus","SC65091");
        carRepository.save(car4);
    }

    private void load_tickets() {
        Ticket ticket1 = new Ticket(TicketType.REGULAR, LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,19,30,00,00));

        ticket1.setCharge(ChargeCalculator.charge(ticket1.getTicketType(), Duration.between(ticket1.getStampStop(),ticket1.getStampStart())));

        ticketRepository.save(ticket1);

        Ticket ticket2 = new Ticket(TicketType.REGULAR,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,20,01,00,00));

        ticket2.setCharge(ChargeCalculator.charge(ticket2.getTicketType(), Duration.between(ticket2.getStampStop(),ticket2.getStampStart())));

        ticketRepository.save(ticket2);


        Ticket ticket3 = new Ticket(TicketType.REGULAR,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,21,01,00,00));

        ticket3.setCharge(ChargeCalculator.charge(ticket3.getTicketType(), Duration.between(ticket3.getStampStop(),ticket3.getStampStart())));

        ticketRepository.save(ticket3);

        Ticket ticket4 = new Ticket(TicketType.REGULAR,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,22,01,00,00));

        ticket4.setCharge(ChargeCalculator.charge(ticket4.getTicketType(), Duration.between(ticket4.getStampStop(),ticket4.getStampStart())));

        ticketRepository.save(ticket4);


        Ticket ticket5 = new Ticket(TicketType.DISABLED, LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,19,30,00,00));

        ticket5.setCharge(ChargeCalculator.charge(ticket5.getTicketType(), Duration.between(ticket5.getStampStop(),ticket5.getStampStart())));

        ticketRepository.save(ticket5);

        Ticket ticket6 = new Ticket(TicketType.DISABLED,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,20,01,00,00));

        ticket6.setCharge(ChargeCalculator.charge(ticket6.getTicketType(), Duration.between(ticket6.getStampStop(),ticket6.getStampStart())));

        ticketRepository.save(ticket6);


        Ticket ticket7 = new Ticket(TicketType.DISABLED,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,21,01,00,00));

        ticket7.setCharge(ChargeCalculator.charge(ticket7.getTicketType(), Duration.between(ticket7.getStampStop(),ticket7.getStampStart())));

        ticketRepository.save(ticket7);

        Ticket ticket8 = new Ticket(TicketType.DISABLED,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,22,01,00,00));

        ticket8.setCharge(ChargeCalculator.charge(ticket8.getTicketType(), Duration.between(ticket8.getStampStop(),ticket8.getStampStart())));

        ticketRepository.save(ticket8);
    }
}
