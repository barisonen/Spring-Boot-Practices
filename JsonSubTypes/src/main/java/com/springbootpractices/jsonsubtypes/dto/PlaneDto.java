package com.springbootpractices.jsonsubtypes.dto;

import lombok.Data;

@Data
public class PlaneDto extends VehicleDto {
    private int numberOfWings;
}
