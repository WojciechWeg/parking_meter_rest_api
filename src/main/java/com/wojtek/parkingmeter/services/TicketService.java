package com.wojtek.parkingmeter.services;

import com.wojtek.parkingmeter.helpers.HasStartedJSON;
import com.wojtek.parkingmeter.helpers.SumJSON;
import com.wojtek.parkingmeter.model.TicketEntity;
import com.wojtek.parkingmeter.model.TicketDTO;


public interface TicketService {

    TicketDTO startTicket(String ticket_type, String nr_plate);

    TicketEntity stopTicket(Long id);

    String checkCharge(Long id);

    SumJSON checkSum();

    HasStartedJSON hasStarted(String nr_plate);

}
