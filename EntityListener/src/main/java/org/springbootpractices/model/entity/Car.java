package org.springbootpractices.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springbootpractices.model.listener.CarListener;

@Data
@Entity
@Table(name = "car")
@EntityListeners(CarListener.class)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "owner")
    private String owner;
}
