package com.wojtek.parkingmeter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cars")

public class Car {

    public Car() {
    }

    public Car(String nr_plate) {

        this.nr_plate = nr_plate;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name="nr_plate")
    private String nr_plate;

    @OneToMany(mappedBy = "car", cascade = {CascadeType.ALL})
    @JsonIgnoreProperties(value = {"car"})
    private List<Ticket> tickets;

    public void addTicket(Ticket ticket){
        if(tickets == null)
            tickets = new ArrayList<>();

        this.tickets.add(ticket);

        ticket.setCar(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNr_plate() {
        return nr_plate;
    }

    public void setNr_plate(String nr_plate) {
        this.nr_plate = nr_plate;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
