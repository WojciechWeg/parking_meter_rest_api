package com.wojtek.parkingmeter.helpers;

import com.wojtek.parkingmeter.helpers.enums.TicketType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class Validator {


    public Validator() {
    }

    public static boolean validateNewTicket(String ticket_type, String nr_plate) {


        if (TicketType.DISABLED.toString().equals(ticket_type.toUpperCase()))
            if (nr_plate.length() == 5)
                return true;

        if (TicketType.REGULAR.toString().equals(ticket_type.toUpperCase()))
            if (nr_plate.length() == 5)
                return true;

        return false;
    }

    public static boolean checkIfAlreadyStarted(JdbcTemplate jdbcTemplate, Long id) {

        Integer carID = new Integer(0);
        try {
            carID = jdbcTemplate.queryForObject("SELECT CAR_ID FROM TICKETS WHERE ID = " + id + "", Integer.class);
        } catch (EmptyResultDataAccessException e) {
        }

        if (carID == null)
            return false;

        return true;

    }

    public static boolean checkIfExists(JdbcTemplate jdbcTemplate, Long id) {

        Integer carID = new Integer(0);
        try {
            carID = jdbcTemplate.queryForObject("SELECT ID FROM TICKETS WHERE ID = " + id + "", Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

        return true;


    }

}
