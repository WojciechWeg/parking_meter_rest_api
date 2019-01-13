package com.wojtek.parkingmeter.modelDAO;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="parking_operator")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingOperatorDAO {



    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;


}
