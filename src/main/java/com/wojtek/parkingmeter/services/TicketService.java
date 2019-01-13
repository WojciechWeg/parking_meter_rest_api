package com.wojtek.parkingmeter.services;

import com.wojtek.parkingmeter.helpers.ChargeJSON;
import com.wojtek.parkingmeter.helpers.HasStartedJSON;
import com.wojtek.parkingmeter.helpers.SumJSON;
import com.wojtek.parkingmeter.model.Ticket;

public interface TicketService {

    Ticket startTicket(String ticket_type);

    Ticket stopTicket(Long id);

    ChargeJSON checkCharge(Long id);

    SumJSON checkSum();

    HasStartedJSON hasStarted();

}
