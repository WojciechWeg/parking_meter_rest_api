package com.wojtek.parkingmeter.services;

import com.wojtek.parkingmeter.helpers.ChargeJSON;
import com.wojtek.parkingmeter.helpers.HasStartedJSON;
import com.wojtek.parkingmeter.helpers.SumJSON;
import com.wojtek.parkingmeter.modelDTO.TicketDTO;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public TicketDTO startTicket(TicketDTO ticketDTO) {
        return null;
    }

    @Override
    public void stopTicket(Long id) {

    }

    @Override
    public ChargeJSON checkCharge() {
        return null;
    }

    @Override
    public SumJSON checkSum(Long id) {
        return null;
    }

    @Override
    public HasStartedJSON hasStarted() {
        return null;
    }
}
