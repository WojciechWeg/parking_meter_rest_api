package com.wojtek.parkingmeter.repositories;

import com.wojtek.parkingmeter.modelDAO.ParkingOwnerDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingOwnerRepository extends JpaRepository<ParkingOwnerDAO,Long> {
}
