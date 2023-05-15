package com.springbootpractices.querydsl.config;

import com.springbootpractices.querydsl.entity.Car;
import com.springbootpractices.querydsl.entity.Employee;
import com.springbootpractices.querydsl.repository.CarRepository;
import com.springbootpractices.querydsl.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final CarRepository carRepository;

    @Override
    public void run(String... args) {
        Employee employee1 = Employee.builder()
                .name("baris")
                .age(4)
                .build();

        Employee employee2 = Employee.builder()
                .name("salih")
                .age(10)
                .build();

        Employee employee3 = Employee.builder()
                .name("john")
                .age(2)
                .build();

        Employee employee4 = Employee.builder()
                .name("emily")
                .age(26)
                .build();

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4);
        employeeRepository.saveAll(employees);

        Car car1 = Car.builder()
                .name("baris' car 1")
                .brand("ferrari")
                .employee(employee1)
                .build();

        Car car2 = Car.builder()
                .name("baris' car 2")
                .brand("bmw")
                .employee(employee1)
                .build();

        Car car3 = Car.builder()
                .name("john's car")
                .brand("tesla")
                .employee(employee3)
                .build();

        List<Car> cars = List.of(car1, car2, car3);
        carRepository.saveAll(cars);
    }
}