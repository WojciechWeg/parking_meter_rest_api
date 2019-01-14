package com.wojtek.parkingmeter.services;

import com.wojtek.parkingmeter.helpers.ChargeJSON;
import com.wojtek.parkingmeter.helpers.HasStartedJSON;
import com.wojtek.parkingmeter.helpers.SumJSON;
import com.wojtek.parkingmeter.model.Ticket;
import com.wojtek.parkingmeter.model.TicketDTO;


public interface TicketService {

    TicketDTO startTicket(String ticket_type, String nr_plate);

    Ticket stopTicket(Long id);

    ChargeJSON checkCharge(Long id);

    SumJSON checkSum();

    HasStartedJSON hasStarted(String nr_plate);

}
