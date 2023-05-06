package com.springbootpractices.transactions.service;

import com.springbootpractices.transactions.entity.Car;
import com.springbootpractices.transactions.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Log4j2
@Service
@RequiredArgsConstructor
public class InternalService {

    private final CarRepository carRepository;

    // parameter not needed, its the default propagation
    @Transactional(propagation = Propagation.REQUIRED)
    public void scenario_3_1_internal() {
        log.info("Transaction name: " + TransactionSynchronizationManager.getCurrentTransactionName());

        Car newCar = new Car();
        newCar.setName("uniquename");
        carRepository.save(newCar);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void scenario_3_2_internal() {
        log.info("Transaction name: " + TransactionSynchronizationManager.getCurrentTransactionName());

        Car newCar = new Car();
        newCar.setName("uniquename");
        carRepository.save(newCar);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void scenario_3_3_internal() {
        log.info("Transaction name: " + TransactionSynchronizationManager.getCurrentTransactionName());

        Car newCar = new Car();
        newCar.setName("notuniquname");
        carRepository.save(newCar);

        Car newCar2 = new Car();
        newCar2.setName("uniquename");
        carRepository.save(newCar2);
    }
}
