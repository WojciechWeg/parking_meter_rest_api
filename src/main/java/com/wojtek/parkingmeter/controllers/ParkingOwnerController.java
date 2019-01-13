package com.wojtek.parkingmeter.controllers;

import com.wojtek.parkingmeter.repositories.ParkingOwnerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingOwnerController {

    private final ParkingOwnerRepository parkingOwnerRepository;

    public ParkingOwnerController(ParkingOwnerRepository parkingOwnerRepository) {
        this.parkingOwnerRepository = parkingOwnerRepository;
    }

    @GetMapping("{id}/sum")
    public double checkSum(@PathVariable Long id){return 0.0;}


}
