package com.springbootpractices.springdata.baseentity;

import lombok.Data;

@Data
public class CreateCarRequest {
    private String carName;
    private String owner;
}
