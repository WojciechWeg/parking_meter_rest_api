package com.wojtek.parkingmeter.controllers;

import com.wojtek.parkingmeter.repositories.TicketRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {


    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/{id}/start")
    public void startTicket(@PathVariable Long id){return;}

    @GetMapping("/{id}/stop")
    public void stopTicket(@PathVariable Long id){return;}

    @GetMapping("/id/check_charge")
    public void checkCharge(){return;}



}
