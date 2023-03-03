package com.springbootpractices.springdata.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;


    @Override
    public void run(String... args) throws Exception {
        Employee employee1 = new Employee("baris", "onen", "barisonen1996@icloud.com", 26);
        Employee employee2 = new Employee("osman", "onen", "osmanonen2014@icloud.com", 9);
        Employee employee3 = new Employee("baris2", "onen", "barisonen1996@icloud.com", 13);
        Employee employee4 = new Employee("baris22", "onen", "asdasd@icloud.com", 5);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
    }
}
