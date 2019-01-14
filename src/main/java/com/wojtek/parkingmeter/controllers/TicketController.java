package com.wojtek.parkingmeter.controllers;

import com.wojtek.parkingmeter.helpers.ChargeJSON;
import com.wojtek.parkingmeter.helpers.HasStartedJSON;
import com.wojtek.parkingmeter.helpers.SumJSON;
import com.wojtek.parkingmeter.model.TicketDTO;
import com.wojtek.parkingmeter.services.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {


    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/start/{ticket_type}/{nr_plate}")
    public TicketDTO startTicket(@PathVariable String ticket_type, @PathVariable String nr_plate){return ticketService.startTicket(ticket_type,nr_plate);}

    @GetMapping("/{id}/stop")
    public void stopTicket(@PathVariable Long id){ticketService.stopTicket(id);}

    @GetMapping("/{id}/check_charge")
    public ChargeJSON checkCharge(@PathVariable Long id){return ticketService.checkCharge(id);}

    @GetMapping("/sum")
    public SumJSON checkSum(){return ticketService.checkSum();}

    @GetMapping("{nr_plate}/hasStarted/")
    public HasStartedJSON hasStarted(@PathVariable String nr_plate){return ticketService.hasStarted(nr_plate);}


}
