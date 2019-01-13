package com.wojtek.parkingmeter.modelDTO;

public class ParkingOperatorDTO {

    private Long id;

    public ParkingOperatorDTO() {
    }

    public ParkingOperatorDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
