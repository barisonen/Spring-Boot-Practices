package com.springbootpractices.springdata.specification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/get-employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/get-employees-with-criteria")
    public List<Employee> getEmployeesWithCriteria(@RequestBody SearchCriteria searchCriteria) {
        return employeeService.getEmployees(searchCriteria);
    }
}
