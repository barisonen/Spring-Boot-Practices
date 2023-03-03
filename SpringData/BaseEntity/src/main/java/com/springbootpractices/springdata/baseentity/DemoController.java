package com.springbootpractices.springdata.baseentity;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @PostMapping("/create-plane")
    public ResponseEntity<Void> createPlane(@RequestBody CreatePlaneRequest request) {
        demoService.createPlane(request.getPlaneName(), request.getOwner());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create-car")
    public ResponseEntity<Void> createCar(@RequestBody CreateCarRequest request) {
        demoService.createCar(request.getCarName(), request.getOwner());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-vehicles")
    public ResponseEntity<List<Vehicle>> getVehicles() {
        return ResponseEntity.ok(demoService.getVehicles());
    }
}
