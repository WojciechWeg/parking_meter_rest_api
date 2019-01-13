package com.wojtek.parkingmeter.modelDTO;

public class ParkingOwnerDTO {

    private Long id;

    public ParkingOwnerDTO() {
    }

    public ParkingOwnerDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
