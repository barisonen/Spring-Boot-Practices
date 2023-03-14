package com.springbootpractices.baseentity.controller.param;

import lombok.Data;

@Data
public class CreatePlaneRequest {
    private String planeName;
    private String owner;
}
