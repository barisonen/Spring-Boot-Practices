package com.springbootpractices.springdata.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployees(SearchCriteria searchCriteria) {
        EmployeeSpecification employeeSpecification = new EmployeeSpecification();
        employeeSpecification.add(searchCriteria);
        return employeeRepository.findAll(employeeSpecification);
    }
}
