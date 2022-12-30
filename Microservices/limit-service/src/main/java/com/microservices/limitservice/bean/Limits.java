package com.microservices.limitservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Limits {

    private int minimum;
    private int maximum;
}
