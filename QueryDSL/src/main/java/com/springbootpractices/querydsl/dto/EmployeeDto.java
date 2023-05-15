package com.springbootpractices.querydsl.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String name;
    private Integer age;
    private List<String> cars;
}
