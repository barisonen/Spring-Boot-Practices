package com.springbootpractices.jsonsubtypes.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "vehicleType",
        use =   JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarDto.class, name = "CAR"),
        @JsonSubTypes.Type(value = PlaneDto.class, name = "PLANE")
})
public abstract class VehicleDto {
    private VehicleType vehicleType;
    private String brand;
}
