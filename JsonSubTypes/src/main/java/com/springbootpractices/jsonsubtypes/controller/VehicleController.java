package com.springbootpractices.jsonsubtypes.controller;

import com.springbootpractices.jsonsubtypes.service.VehicleService;
import com.springbootpractices.jsonsubtypes.dto.VehicleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class VehicleController {
    private final VehicleService service;

    @GetMapping("/get-vehicles")
    public List<VehicleDto> getAllVehicles() {
        return service.getVehicles();
    }

    @PostMapping("/add-vehicle")
    public HttpStatus addVehicle(@RequestBody VehicleDto vehicleDto) {
        service.addVehicle(vehicleDto);
        return HttpStatus.OK;
    }
}