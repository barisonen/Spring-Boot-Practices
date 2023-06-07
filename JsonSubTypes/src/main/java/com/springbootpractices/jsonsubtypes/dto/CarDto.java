package com.springbootpractices.jsonsubtypes.dto;

import lombok.Data;

@Data
public class CarDto extends VehicleDto {
    private int numberOfDoors;
}
