package com.springbootpractices.jsonsubtypes.service;

import com.springbootpractices.jsonsubtypes.dto.CarDto;
import com.springbootpractices.jsonsubtypes.dto.PlaneDto;
import com.springbootpractices.jsonsubtypes.dto.VehicleDto;
import com.springbootpractices.jsonsubtypes.dto.VehicleType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    private final List<VehicleDto> vehicles;

    public VehicleService() {
        vehicles = new ArrayList<>();

        CarDto car1 = new CarDto();
        car1.setVehicleType(VehicleType.CAR);
        car1.setBrand("BMW");
        car1.setNumberOfDoors(2);

        CarDto car2 = new CarDto();
        car2.setVehicleType(VehicleType.CAR);
        car2.setBrand("Honda");
        car2.setNumberOfDoors(4);

        PlaneDto plane1 = new PlaneDto();
        plane1.setVehicleType(VehicleType.PLANE);
        plane1.setBrand("Lockheed Martin");
        plane1.setNumberOfWings(2);

        PlaneDto plane2 = new PlaneDto();
        plane2.setVehicleType(VehicleType.PLANE);
        plane2.setBrand("Boeing");
        plane2.setNumberOfWings(2);

        vehicles.addAll(List.of(car1, car2, plane1, plane2));
    }

    public List<VehicleDto> getVehicles() {
        return vehicles;
    }

    public void addVehicle(VehicleDto vehicleDto) {
        vehicles.add(vehicleDto);
    }
}
