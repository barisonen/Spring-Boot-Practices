package org.springbootpractices.service;

import org.springbootpractices.model.dto.CarDto;

public interface CarService {

    void addCar(CarDto carDto);

    void updateCar(CarDto carDto);

    void deleteCar(long carId);
}
