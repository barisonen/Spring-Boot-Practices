package com.springbootpractices.querydsl.config;

import com.springbootpractices.querydsl.entity.Employee;
import com.springbootpractices.querydsl.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) {
        Employee employee1 = new Employee();
        employee1.setName("baris");
        employee1.setAge(4);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName("asdbaasd");
        employee2.setAge(10);
        employeeRepository.save(employee2);
    }
}
