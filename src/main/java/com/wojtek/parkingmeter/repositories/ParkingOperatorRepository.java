package com.wojtek.parkingmeter.repositories;

import com.wojtek.parkingmeter.modelDAO.ParkingOperatorDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingOperatorRepository extends JpaRepository<ParkingOperatorDAO,Long> {
}
