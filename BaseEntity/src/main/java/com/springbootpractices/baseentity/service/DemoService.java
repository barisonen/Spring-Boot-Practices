package com.springbootpractices.baseentity.service;

import com.springbootpractices.baseentity.entity.Car;
import com.springbootpractices.baseentity.entity.Plane;
import com.springbootpractices.baseentity.entity.Vehicle;
import com.springbootpractices.baseentity.repository.CarRepository;
import com.springbootpractices.baseentity.repository.PlaneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final PlaneRepository planeRepository;
    private final CarRepository carRepository;

    @Transactional
    public void createPlane(String planeName, String owner) {
        Plane newPlane = new Plane();
        newPlane.setPlaneName(planeName);
        newPlane.setOwner(owner);
        planeRepository.save(newPlane);
    }

    @Transactional
    public void createCar(String carName, String owner) {
        Car newCar = new Car();
        newCar.setCarName(carName);
        newCar.setOwner(owner);
        carRepository.save(newCar);
    }

    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(planeRepository.findAll());
        vehicles.addAll(carRepository.findAll());
        return vehicles;
    }
}
