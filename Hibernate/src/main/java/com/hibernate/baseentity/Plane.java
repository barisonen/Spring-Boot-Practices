package com.hibernate.baseentity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "plane")
public class Plane extends Vehicle {

    @Column(name = "plane_name")
    private String planeName;
}
