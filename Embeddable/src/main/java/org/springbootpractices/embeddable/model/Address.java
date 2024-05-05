package org.springbootpractices.embeddable.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

    private String country;
    private String city;
    private String street;
}
