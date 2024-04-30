package org.springbootpractices.service.impl;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springbootpractices.model.dto.CarDto;
import org.springbootpractices.model.entity.Car;
import org.springbootpractices.model.mapper.CarMapper;
import org.springbootpractices.model.repository.CarRepository;
import org.springbootpractices.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper = Mappers.getMapper(CarMapper.class);

    @Override
    @Transactional
    public void addCar(CarDto carDto) {
        Car car = carMapper.carDtoToEntity(carDto);
        carRepository.save(car);
    }

    @Override
    @Transactional
    public void updateCar(CarDto carDto) {
        Car car = carMapper.carDtoToEntity(carDto);
        carRepository.save(car);
    }

    @Override
    @Transactional
    public void deleteCar(long carId) {
        carRepository.deleteById(carId);
    }
}
