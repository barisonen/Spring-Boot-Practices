package com.springbootpractices.converter.db.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class FullName implements Serializable {
    private String name;
    private String surname;
}
