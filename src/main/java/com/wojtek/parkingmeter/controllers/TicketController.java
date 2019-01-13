package com.wojtek.parkingmeter.controllers;

import com.wojtek.parkingmeter.helpers.ChargeJSON;
import com.wojtek.parkingmeter.helpers.HasStartedJSON;
import com.wojtek.parkingmeter.helpers.SumJSON;
import com.wojtek.parkingmeter.model.Ticket;
import com.wojtek.parkingmeter.services.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {


    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/start/{ticket_type}")
    public Ticket startTicket(@PathVariable String ticket_type){return ticketService.startTicket(ticket_type);}

    @GetMapping("/{id}/stop")
    public void stopTicket(@PathVariable Long id){ticketService.stopTicket(id);}

    @GetMapping("/{id}/check_charge")
    public ChargeJSON checkCharge(@PathVariable Long id){return ticketService.checkCharge(id);}

    @GetMapping("/sum")
    public SumJSON checkSum(){return ticketService.checkSum();}

    @GetMapping("/hasStarted")
    public HasStartedJSON hasStarted(){return ticketService.hasStarted();}


}
