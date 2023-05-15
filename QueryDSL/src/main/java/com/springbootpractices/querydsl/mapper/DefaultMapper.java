package com.springbootpractices.querydsl.mapper;

import com.springbootpractices.querydsl.dto.CarDto;
import com.springbootpractices.querydsl.dto.EmployeeDto;
import com.springbootpractices.querydsl.entity.Car;
import com.springbootpractices.querydsl.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface DefaultMapper {

    @Mapping(expression = "java(employee.getCars().stream().map(Car::getName).collect(Collectors.toList()))", target = "cars")
    EmployeeDto employeeToEmployeeDto(Employee employee);

    List<EmployeeDto> employeeListToEmployeeDtoList(List<Employee> employees);

    @Mapping(expression = "java(car.getEmployee().getName())", target = "employee")
    CarDto carToCarDto(Car car);

    List<CarDto> carListToCarDtoList(List<Car> cars);
}
