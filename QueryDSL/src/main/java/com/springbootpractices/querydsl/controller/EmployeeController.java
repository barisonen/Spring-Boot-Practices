package com.springbootpractices.querydsl.controller;

import com.springbootpractices.querydsl.dto.CarDto;
import com.springbootpractices.querydsl.dto.EmployeeDto;
import com.springbootpractices.querydsl.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/find-all")
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/find-specific-employees-1")
    public List<EmployeeDto> findSpecificEmployees1() {
        return employeeService.findSpecificEmployees1();
    }

    @GetMapping("/find-specific-employees-2")
    public List<EmployeeDto> findSpecificEmployees2() {
        return employeeService.findSpecificEmployees2();
    }

    @GetMapping("/find-specific-cars-1")
    public List<CarDto> findSpecificEmployees3() {
        return employeeService.findSpecificCars1();
    }
}
