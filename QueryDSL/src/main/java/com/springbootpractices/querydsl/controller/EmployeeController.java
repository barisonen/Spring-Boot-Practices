package com.springbootpractices.querydsl.controller;

import com.springbootpractices.querydsl.entity.Employee;
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
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/find-specific-employees-1")
    public List<Employee> findSpecificEmployees1() {
        return employeeService.findSpecificEmployees1();
    }

    @GetMapping("/find-specific-employees-2")
    public List<Employee> findSpecificEmployees2() {
        return employeeService.findSpecificEmployees2();
    }
}
