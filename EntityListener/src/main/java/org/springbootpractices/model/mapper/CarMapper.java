package org.springbootpractices.model.mapper;

import org.mapstruct.Mapper;
import org.springbootpractices.model.dto.CarDto;
import org.springbootpractices.model.entity.Car;

@Mapper
public interface CarMapper {

    Car carDtoToEntity(CarDto carDto);
}
