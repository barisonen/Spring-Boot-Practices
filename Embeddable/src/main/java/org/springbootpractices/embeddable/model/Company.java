package org.springbootpractices.embeddable.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Embedded
    private Address address;
}
