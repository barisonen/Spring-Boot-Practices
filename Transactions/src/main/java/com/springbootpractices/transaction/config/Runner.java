package com.springbootpractices.transaction.config;

import com.springbootpractices.transaction.entity.Employee;
import com.springbootpractices.transaction.repository.EmployeeRepository;
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
        employee1.setAge(26);
        employeeRepository.save(employee1);
    }
}
