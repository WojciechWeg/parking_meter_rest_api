package com.wojtek.parkingmeter.helpers;

import com.wojtek.parkingmeter.helpers.enums.TicketType;

import java.time.Duration;


public class ChargeCalculator {

    public static double charge(TicketType ticketType, Duration duration) {

        if (TicketType.REGULAR == ticketType)
            return regular(Math.abs(duration.toHours()));

        if (TicketType.DISABLED.equals(ticketType))
            return disabled(Math.abs(duration.toHours()));

        return -1.0;
    }

    static double regular(Long duration) {

        double charge = 0.0;
        //Double hours = Math.ceil(duration);
        //int hours_int = hours.intValue();

        if (duration <= 1)
            charge = charge + 1;
        if (duration <= 2 && duration >= 1)
            charge = charge + 2;
        if (duration >= 2) {
            charge = 3;
            double last_price = 2;

            for (int i = 2; i <= duration; i++) {
                last_price = last_price * 1.5;
                charge = charge + last_price;
            }
        }
        return charge;
    }

    static double disabled(Long duration) {

        double charge = 0.0;
        Double hours = Math.ceil(duration);
        int hours_int = hours.intValue();


        if (hours_int <= 2 && hours_int >= 1)
            charge = charge + 2;
        if (hours_int >= 2) {
            charge = 2;
            double last_price = 2;

            for (int i = 2; i <= hours_int; i++) {
                last_price = last_price * 1.2;
                charge = charge + last_price;


            }
        }
        return charge;

    }

}
