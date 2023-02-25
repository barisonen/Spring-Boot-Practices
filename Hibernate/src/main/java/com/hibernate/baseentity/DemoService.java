package com.hibernate.baseentity;

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
