package com.hibernate.baseentity;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    public void createEmployee(String name) {
        Employee newEmployee = new Employee();
        newEmployee.setName(name);

        employeeRepository.save(newEmployee);
    }
}
