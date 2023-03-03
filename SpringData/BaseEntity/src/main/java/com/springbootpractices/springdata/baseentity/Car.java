package com.springbootpractices.springdata.baseentity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car extends Vehicle {

    @Column(name = "car_name")
    private String carName;
}
