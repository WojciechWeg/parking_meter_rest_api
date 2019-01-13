package com.wojtek.parkingmeter.modelDAO;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="parking_owner")
@Setter
@Getter
@AllArgsConstructor
public class ParkingOwnerDAO {

    public ParkingOwnerDAO(String parkingName, double earnedMoney){
        this.parkingName = parkingName;
        this.earnedMoney = earnedMoney;
    }


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name="parking_name")
    private String parkingName;

    @Column(name="earned_money")
    private double earnedMoney;

}
