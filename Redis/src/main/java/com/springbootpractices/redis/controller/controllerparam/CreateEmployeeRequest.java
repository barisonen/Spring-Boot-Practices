package com.springbootpractices.redis.controller.controllerparam;

import lombok.Data;

@Data
public class CreateEmployeeRequest {
    private String name;
    private String surname;
}
