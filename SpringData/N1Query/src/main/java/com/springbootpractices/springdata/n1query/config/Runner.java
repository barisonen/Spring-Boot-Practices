package com.springbootpractices.springdata.n1query.config;

import com.springbootpractices.springdata.n1query.entity.Car;
import com.springbootpractices.springdata.n1query.entity.CarRepository;
import com.springbootpractices.springdata.n1query.entity.Owner;
import com.springbootpractices.springdata.n1query.entity.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final OwnerRepository ownerRepository;
    private final CarRepository carRepository;


    @Override
    public void run(String... args) {

        Owner owner1 = new Owner();
        owner1.setName("baris");
        owner1.setSurname("onen");
        owner1.setAge(26);

        Owner owner2 = new Owner();
        owner2.setName("osman");
        owner2.setSurname("onen");
        owner2.setAge(9);

        ownerRepository.saveAll(List.of(owner1, owner2));

        Car car1 = new Car();
        car1.setOwner(owner1);
        car1.setBrand("Audi");
        car1.setModel("A3");

        Car car2 = new Car();
        car2.setOwner(owner1);
        car2.setBrand("Audi");
        car2.setModel("A4");

        Car car3 = new Car();
        car3.setOwner(owner2);
        car3.setBrand("BMW");
        car3.setModel("XM");

        Car car4 = new Car();
        car4.setOwner(owner2);
        car4.setBrand("BMW");
        car4.setModel("X7");

        carRepository.saveAll(List.of(car1, car2, car3, car4));
    }
}