package com.springbootpractices.aop;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Log4j2
public class CarService {

    // join point
    @MyProcess
    public void repairCar(Double money) {
        Random random = new Random();
        if (random.nextBoolean()) {
            log.info("Car Service: Your car has been repaired. Thanks for $" + money);
        }
        else {
            throw new RuntimeException("An error occured");
        }
    }
}
