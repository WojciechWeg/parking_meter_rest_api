package com.wojtek.parkingmeter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="cars")
@Setter
@Getter
public class Car {

    public Car() {
    }

    public Car(String manufacture, String model, String nr_plate) {
        this.manufacture = manufacture;
        this.model = model;
        this.nr_plate = nr_plate;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name="manufacture")
    private String manufacture;

    @Column(name="model")
    private String model;

    @Column(name="nr_plate")
    private String nr_plate;



}
