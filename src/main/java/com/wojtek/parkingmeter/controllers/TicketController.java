package com.wojtek.parkingmeter.controllers;

import com.wojtek.parkingmeter.helpers.ChargeJSON;
import com.wojtek.parkingmeter.helpers.HasStartedJSON;
import com.wojtek.parkingmeter.helpers.SumJSON;
import com.wojtek.parkingmeter.modelDTO.TicketDTO;
import com.wojtek.parkingmeter.services.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {


    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public TicketDTO startTicket(@RequestBody TicketDTO ticketDTO){return ticketService.startTicket(ticketDTO);}

    @GetMapping("/{id}/stop")
    public void stopTicket(@PathVariable Long id){ticketService.stopTicket(id);}

    @GetMapping("/{id}/check_charge")
    public ChargeJSON checkCharge(@PathVariable Long id){return ticketService.checkCharge(id);}

    @GetMapping("/sum")
    public SumJSON checkSum(){return ticketService.checkSum();}

    @GetMapping("/hasStarted")
    public HasStartedJSON hasStarted(){return ticketService.hasStarted();}


}
