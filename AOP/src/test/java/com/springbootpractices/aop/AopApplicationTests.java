package com.springbootpractices.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopApplicationTests {

    @Autowired
    CarService shipmentService;

    @Test
    void testBeforeLog() {
        shipmentService.repairCar(500.50);
    }
}
