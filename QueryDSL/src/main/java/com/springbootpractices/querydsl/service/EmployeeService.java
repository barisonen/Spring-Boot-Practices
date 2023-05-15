package com.springbootpractices.querydsl.service;

import com.querydsl.jpa.impl.JPAQuery;
import com.springbootpractices.querydsl.dto.CarDto;
import com.springbootpractices.querydsl.dto.EmployeeDto;
import com.springbootpractices.querydsl.entity.Car;
import com.springbootpractices.querydsl.entity.Employee;
import com.springbootpractices.querydsl.entity.QCar;
import com.springbootpractices.querydsl.entity.QEmployee;
import com.springbootpractices.querydsl.mapper.DefaultMapper;
import com.springbootpractices.querydsl.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    private final EmployeeRepository employeeRepository;
    private final DefaultMapper defaultMapper = Mappers.getMapper(DefaultMapper.class);

    public List<EmployeeDto> findAll() {
        return defaultMapper.employeeListToEmployeeDtoList(employeeRepository.findAll());
    }

    public List<EmployeeDto> findSpecificEmployees1() {
        JPAQuery<Employee> query = new JPAQuery<>(entityManager);
        QEmployee employee = QEmployee.employee;

        List<Employee> employees = query.from(employee)
                .where(employee.name.eq("baris"))
                .fetch();

        return defaultMapper.employeeListToEmployeeDtoList(employees);
    }

    public List<EmployeeDto> findSpecificEmployees2() {
        JPAQuery<Employee> query = new JPAQuery<>(entityManager);
        QEmployee employee = QEmployee.employee;

        List<Employee> employees = query.from(employee)
                .where(employee.name.contains("s"),
                        employee.age.gt(5))
                .fetch();

        return defaultMapper.employeeListToEmployeeDtoList(employees);
    }

    public List<CarDto> findSpecificCars1() {
        JPAQuery<Car> query = new JPAQuery<>(entityManager);
        QCar car = QCar.car;
        QEmployee employee = QEmployee.employee;
        List<Car> cars = query.from(car)
                .innerJoin(car.employee, employee)
                .where(employee.name.contains("i")
                        .or(employee.name.contains("o"))
                        .and(car.name.contains("baris' car")))
                .fetch();

        return defaultMapper.carListToCarDtoList(cars);
    }
}
