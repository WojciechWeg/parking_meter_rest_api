package com.wojtek.parkingmeter.controllers;

import com.wojtek.parkingmeter.helpers.*;
import com.wojtek.parkingmeter.helpers.enums.HasStartedEnum;
import com.wojtek.parkingmeter.model.TicketDTO;
import com.wojtek.parkingmeter.services.TicketService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class TicketController {


    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/start/{ticket_type}/{nr_plate}")
    public ResponseEntity<TicketDTO> startTicket(@PathVariable String ticket_type, @PathVariable String nr_plate) {


        if (ticketService.hasStarted(nr_plate).getHasStarted().equals(HasStartedEnum.YES))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TicketDTO());
        if (ValidateNewTicket.validate(ticket_type, nr_plate))
            return ResponseEntity.ok().body(ticketService.startTicket(ticket_type, nr_plate));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TicketDTO());

    }

    @GetMapping("/stop/{id}")
    public ResponseEntity<String> stopTicket(@PathVariable Long id) {


        try {
            ticketService.stopTicket(id);
            return ResponseEntity.ok().body("TICKET STOPPED");
        } catch (NoSuchElementException e) {
            String noSuchTicket = "No such ticket.";
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(noSuchTicket);
        }

    }

    @GetMapping("/check_charge/{id}")
    public ResponseEntity<String> checkCharge(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(ticketService.checkCharge(id));
        } catch (NoSuchElementException e) {
            String noSuchTicket = "No such ticket.";
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(noSuchTicket);
        }

    }

    @GetMapping("/sum")
    public SumJSON checkSum() {
        return ticketService.checkSum();
    }

    @GetMapping("/hasStarted/{nr_plate}")
    public ResponseEntity<HasStartedJSON> hasStarted(@PathVariable String nr_plate) {

        try {
            return ResponseEntity.ok(ticketService.hasStarted(nr_plate));
        } catch (EmptyResultDataAccessException e) {
            HasStartedJSON hsj = new HasStartedJSON(HasStartedEnum.NO_SUCH_CAR);
            return ResponseEntity.badRequest().body(hsj);
        }

    }

}
