package com.springbootpractices.transactions.config;

import com.springbootpractices.transactions.entity.Car;
import com.springbootpractices.transactions.entity.Employee;
import com.springbootpractices.transactions.repository.CarRepository;
import com.springbootpractices.transactions.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final CarRepository carRepository;

    @Override
    public void run(String... args) {

        Employee employee1 = new Employee();
        employee1.setName("baris");
        employee1.setAge(26);
        employeeRepository.save(employee1);

        Car car1 = new Car();
        car1.setName("uniquename");
        carRepository.save(car1);
    }
}
