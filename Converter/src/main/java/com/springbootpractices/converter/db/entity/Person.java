package com.springbootpractices.converter.db.entity;

import com.springbootpractices.converter.db.converter.FullNameConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Convert(converter = FullNameConverter.class)
    private FullName fullName;
}
