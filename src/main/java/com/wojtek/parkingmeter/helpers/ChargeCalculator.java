package com.wojtek.parkingmeter.helpers;

import java.time.Duration;

public class ChargeCalculator {

    public static double charge(TicketType ticketType, Duration duration){


        if(ticketType.toString().toUpperCase().equals("REGULAR"))
             return regular(Math.abs(duration.toHours()));

        if(ticketType.toString().toUpperCase().equals("DISABLED"))
            return  disabled(Math.abs(duration.toHours()));

        return -1.0;
    }

    static double regular(Long duration){

        double charge=0.0;
        Double hours = Math.ceil(duration);
        int hours_int = hours.intValue();

        if(hours_int >= 1)
            charge=charge+1;
        if(hours_int >= 2)
            charge=charge+2;
        if(hours_int >= 3) {

            double last_price = 2;

            for (int i = 3; i <= hours_int; i++) {

                charge = charge + last_price*1.5;
                last_price = last_price * 1.5;

            }
        }
        return charge;
    }

    static double disabled(Long duration){

        double charge=0.0;
        Double hours = Math.ceil(duration);
        int hours_int = hours.intValue();

        if(hours_int >= 2)
            charge=charge+2;
        if(hours_int >= 3) {

            double last_price = 2;

            for (int i = 3; i <= hours_int; i++) {

                charge = charge + last_price*1.2;
                last_price = last_price * 1.2;

            }
        }
        return charge;

    }

}
