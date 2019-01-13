package com.wojtek.parkingmeter.services;

import com.wojtek.parkingmeter.helpers.ChargeJSON;
import com.wojtek.parkingmeter.helpers.HasStartedJSON;
import com.wojtek.parkingmeter.helpers.SumJSON;
import com.wojtek.parkingmeter.modelDTO.TicketDTO;

public interface TicketService {

    TicketDTO startTicket(TicketDTO ticketDTO);

    void stopTicket(Long id);

    ChargeJSON checkCharge(Long id);

    SumJSON checkSum();

    HasStartedJSON hasStarted();

}
