package com.springbootpractices.querydsl.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "employee")
    private Set<Car> cars;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
