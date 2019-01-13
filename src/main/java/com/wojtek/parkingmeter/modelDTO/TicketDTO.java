package com.wojtek.parkingmeter.modelDTO;

public class TicketDTO {


    private Long id;

    public TicketDTO() {
    }

    public TicketDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
