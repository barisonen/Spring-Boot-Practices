package com.springbootpractices.springdata.transaction.service;

import com.springbootpractices.springdata.transaction.entity.Employee;
import com.springbootpractices.springdata.transaction.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GlobalService {

    private final EmployeeRepository employeeRepository;

    /*
        scenario 1:
        Without any save operation, employee changes automatically reflected to the database
        after the transaction ends.
    */
    @Transactional
    public void scenario1() {
        Optional<Employee> optionalEmployee = employeeRepository.findById(1L);
        optionalEmployee.ifPresent(employee -> {
            employee.setName("osman");
            employee.setAge(9);
        });
    }
}
