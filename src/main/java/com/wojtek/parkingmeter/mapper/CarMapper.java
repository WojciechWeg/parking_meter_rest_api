package com.wojtek.parkingmeter.mapper;

import com.wojtek.parkingmeter.model.Car;
import com.wojtek.parkingmeter.model.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDTO carToCarDTO(Car car);

    Car CarDTOToCar(CarDTO carDTO);

}
