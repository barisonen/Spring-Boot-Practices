package com.springbootpractices.springdata.baseentity;

import lombok.Data;

@Data
public class CreatePlaneRequest {
    private String planeName;
    private String owner;
}
