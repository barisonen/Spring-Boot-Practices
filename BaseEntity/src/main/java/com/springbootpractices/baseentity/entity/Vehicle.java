package com.springbootpractices.baseentity.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated")
    private Date dateUpdated;

    @Column(name = "owner")
    private String owner;
    
}
