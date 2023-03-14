package com.springbootpractices.baseentity.controller.param;

import lombok.Data;

@Data
public class CreateCarRequest {
    private String carName;
    private String owner;
}
