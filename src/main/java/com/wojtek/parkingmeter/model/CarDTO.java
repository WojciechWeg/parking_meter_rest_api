package com.wojtek.parkingmeter.model;

public class CarDTO {

    private String nr_plate;

    public CarDTO() {
    }

    public CarDTO(String nr_plate) {
        this.nr_plate = nr_plate;
    }

    public String getNr_plate() {
        return nr_plate;
    }

    public void setNr_plate(String nr_plate) {
        this.nr_plate = nr_plate;
    }
}
