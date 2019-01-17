package com.wojtek.parkingmeter.helpers;

import com.wojtek.parkingmeter.helpers.enums.TicketType;
import com.wojtek.parkingmeter.model.Ticket;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class ChargeCalculatorTest {



    @Test
    public void RegularLessThanOneHour(){

        //given
        Ticket ticket1 = new Ticket(TicketType.REGULAR, LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,19,30,00,00));

        //when
        ticket1.setCharge(ChargeCalculator.charge(ticket1.getTicketType(), ticket1.getDuration()));

        //then
        assertEquals(1, ticket1.getCharge(),0.001);
    }

    @Test
    public void RegularLessThanTwoHours(){

        //given
        Ticket ticket2 = new Ticket(TicketType.REGULAR,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,20,01,00,00));


        //when
        ticket2.setCharge(ChargeCalculator.charge(ticket2.getTicketType(),ticket2.getDuration()));

        //then
        assertEquals(3, ticket2.getCharge(),0.001);
    }

    @Test
    public void RegularLessThanThreeHours(){

        //given
        Ticket ticket3 = new Ticket(TicketType.REGULAR,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,21,01,00,00));


        //when
        ticket3.setCharge(ChargeCalculator.charge(ticket3.getTicketType(), ticket3.getDuration()));

        //then
        assertEquals(6, ticket3.getCharge(),0.001);
    }



    @Test
    public void RegularLessThanFourHours(){

        //given
        Ticket ticket4 = new Ticket(TicketType.REGULAR,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,22,01,00,00));

        //when
        ticket4.setCharge(ChargeCalculator.charge(ticket4.getTicketType(), ticket4.getDuration()));


        //then
        assertEquals(10.5, ticket4.getCharge(),0.001);
    }

    @Test
    public void DisabledLessThanOneHours(){

        //given
        Ticket ticket5 = new Ticket(TicketType.DISABLED, LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,19,30,00,00));

        //when
        ticket5.setCharge(ChargeCalculator.charge(ticket5.getTicketType(),ticket5.getDuration()));

        //then
        assertEquals(0.0, ticket5.getCharge(),0.001);
    }

    @Test
    public void DisabledLessThanTwoHours(){

        //given
        Ticket ticket6 = new Ticket(TicketType.DISABLED,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,20,01,00,00));

        //when
        ticket6.setCharge(ChargeCalculator.charge(ticket6.getTicketType(),ticket6.getDuration()));
        //then
        assertEquals(2.0, ticket6.getCharge(),0.001);

    }

    @Test
    public void DisabledLessThanThreeHours(){

        //given
        Ticket ticket7 = new Ticket(TicketType.DISABLED,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,21,01,00,00));

        //when
        ticket7.setCharge(ChargeCalculator.charge(ticket7.getTicketType(), ticket7.getDuration()));
        //then
        assertEquals(4.4, ticket7.getCharge(),0.001);

    }

    @Test
    public void DisabledLessThanFourHours(){

        //given
        Ticket ticket8 = new Ticket(TicketType.DISABLED,  LocalDateTime.of(2019,1,13,19,00,00,00), LocalDateTime.of(2019,1,13,22,01,00,00));

        //when
        ticket8.setCharge(ChargeCalculator.charge(ticket8.getTicketType(), ticket8.getDuration()));

        //then
        assertEquals(7.28, ticket8.getCharge(),0.001);

    }

}
