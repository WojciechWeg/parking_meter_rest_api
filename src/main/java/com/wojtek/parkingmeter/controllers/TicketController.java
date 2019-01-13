package com.wojtek.parkingmeter.controllers;

import com.wojtek.parkingmeter.modelDTO.TicketDTO;
import com.wojtek.parkingmeter.repositories.TicketRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {


    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @PostMapping
    public void startTicket(@RequestBody TicketDTO ticketDTO){return;}

    @GetMapping("/{id}/stop")
    public void stopTicket(@PathVariable Long id){return;}

    @GetMapping("/id/check_charge")
    public void checkCharge(){return;}



}
