package com.springbootpractices.redis.controller;

import com.springbootpractices.redis.controller.controllerparam.CreateEmployeeRequest;
import com.springbootpractices.redis.model.Employee;
import com.springbootpractices.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis-repository-example")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/create-employee")
    public ResponseEntity<Void> createEmployee(@RequestBody CreateEmployeeRequest request) {
        redisService.createEmployee(request.getName(), request.getSurname());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-employee")
    public ResponseEntity<Employee> getEmployee(@RequestParam String name) {
        return ResponseEntity.ok(redisService.getEmployee(name));
    }

    @GetMapping("/get-employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(redisService.getEmployees());
    }
}
