package com.wojtek.parkingmeter.helpers;

import com.wojtek.parkingmeter.helpers.enums.TicketType;

public class ValidateNewTicket {


    public static boolean validate(String ticket_type, String nr_plate){


        if(TicketType.DISABLED.toString().equals(ticket_type.toUpperCase()))
            if(nr_plate.length() == 5)
                return true;

        if(TicketType.REGULAR.toString().equals(ticket_type.toUpperCase()))
            if(nr_plate.length() == 5)
                return true;

        return false;
    }

}
