package com.springbootpractices.transactions.service;

import com.springbootpractices.transactions.entity.Car;
import com.springbootpractices.transactions.entity.Employee;
import com.springbootpractices.transactions.repository.CarRepository;
import com.springbootpractices.transactions.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class GlobalService {

    private final InternalService internalService;
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
        will persist.
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

    /*
        Scenario 3-1:
        See a transactional method calls another transactional method
        with the propagation of REQUIRED.
        Check the logs that in both methods the transaction is the same
        and exception in the second method rollbacks the first change.
    */
    @Transactional
    public void scenario_3_1() {
        log.info("Transaction name: " + TransactionSynchronizationManager.getCurrentTransactionName());

        Employee newEmployee = new Employee();
        newEmployee.setName("Mike");
        newEmployee.setAge(22);
        employeeRepository.save(newEmployee);

        internalService.scenario_3_1_internal();
    }

    /*
        Scenario 3-2:
        See a transactional method calls another transactional method
        with the propagation of REQUIRES_NEW.
        Check the logs that both methods have different transactions.
        However, exception in the second method also rollbacks the first change.
    */
    @Transactional
    public void scenario_3_2() {
        log.info("Transaction name: " + TransactionSynchronizationManager.getCurrentTransactionName());

        Employee newEmployee = new Employee();
        newEmployee.setName("Mike");
        newEmployee.setAge(22);
        employeeRepository.save(newEmployee);

        internalService.scenario_3_2_internal();
    }

    /*
        Scenario 3-3:
        A non-transactional method calls a transactional method with
        the propagation of REQUIRES_NEW.
        In the transaction there are 2 save operations,
        which the second save throws an exception and the first save,
        which is inside the second method's transaction scope, is rollbacked.
        However, the save operation in first method persists.
    */
    public void scenario_3_3() {
        log.info("Transaction name: " + TransactionSynchronizationManager.getCurrentTransactionName());

        Employee newEmployee = new Employee();
        newEmployee.setName("Mike");
        newEmployee.setAge(22);
        employeeRepository.save(newEmployee);

        internalService.scenario_3_3_internal();
    }
}
