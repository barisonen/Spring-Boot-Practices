package org.springbootpractices.model.listener;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.extern.log4j.Log4j2;
import org.springbootpractices.model.entity.Car;

@Log4j2
public class CarListener {

    @PostPersist
    private void afterCreate(Car car) {
        log.info("Car created: " + car);
    }

    @PostUpdate
    private void afterUpdate(Car car) {
        log.info("Car updated: " + car);
    }

    @PostRemove
    private void afterRemove(Car car) {
        log.info("Car removed: " + car);
    }
}
