package com.wojtek.parkingmeter.repositories;

import com.wojtek.parkingmeter.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
