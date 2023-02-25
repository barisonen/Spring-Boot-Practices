package com.hibernate.baseentity;

import lombok.Data;

@Data
public class CreateCarRequest {
    private String carName;
    private String owner;
}
