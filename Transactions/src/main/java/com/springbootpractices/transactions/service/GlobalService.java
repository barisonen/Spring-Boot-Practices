package com.springbootpractices.transactions.service;

import com.springbootpractices.transactions.entity.Car;
import com.springbootpractices.transactions.entity.Employee;
import com.springbootpractices.transactions.repository.CarRepository;
import com.springbootpractices.transactions.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GlobalService {

    private final EmployeeRepository employeeRepository;
    private final CarRepository carRepository;

    /*
        scenario 1:
        Without any save operation, employee changes automatically reflected to the database
        after the transaction ends.
    */
    @Transactional
    public void scenario_1() {
        Optional<Employee> optionalEmployee = employeeRepository.findById(1L);
        optionalEmployee.ifPresent(employee -> {
            employee.setName("osman");
            employee.setAge(9);
        });
    }

    /*
        scenario 2-1:
        After successful first save, second save will throw DataIntegrityException because
        we are violating the unique constraint of name field in car table. However, first save
        will remain.
    */
    public void scenario_2_1() {
        Employee newEmployee = new Employee();
        newEmployee.setName("Joe");
        newEmployee.setAge(44);
        employeeRepository.save(newEmployee);

        Car car1 = new Car();
        car1.setName("uniquename");
        carRepository.save(car1);
    }

    /*
       scenario 2-2:
        With transaction, first save will be rolled back when exception occurs
        in the second one.
   */
    @Transactional
    public void scenario_2_2() {
        Employee newEmployee = new Employee();
        newEmployee.setName("Joe");
        newEmployee.setAge(44);
        employeeRepository.save(newEmployee);

        Car car1 = new Car();
        car1.setName("uniquename");
        carRepository.save(car1);
    }
}
