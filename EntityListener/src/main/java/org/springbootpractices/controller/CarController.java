package org.springbootpractices.controller;

import lombok.RequiredArgsConstructor;
import org.springbootpractices.model.dto.CarDto;
import org.springbootpractices.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @PostMapping
    public void addCar(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
    }

    @PutMapping("/{carId}")
    public void updateCar(@PathVariable long carId, @RequestBody CarDto carDto) {
        carDto.setId(carId);
        carService.updateCar(carDto);
    }

    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable long carId) {
        carService.deleteCar(carId);
    }
}
