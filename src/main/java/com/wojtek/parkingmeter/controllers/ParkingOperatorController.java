package com.wojtek.parkingmeter.controllers;

import com.wojtek.parkingmeter.repositories.ParkingOperatorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingOperatorController {

    private final ParkingOperatorRepository parkingOperatorRepository;

    public ParkingOperatorController(ParkingOperatorRepository parkingOperatorRepository) {
        this.parkingOperatorRepository = parkingOperatorRepository;
    }

    @GetMapping("{id}/check/{id_ticket}")
    public void  checkIfStarted (@PathVariable Long id, @PathVariable Long id_ticket ){return;}

}
