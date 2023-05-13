package com.springbootpractices.querydsl.service;

import com.querydsl.jpa.impl.JPAQuery;
import com.springbootpractices.querydsl.entity.Employee;
import com.springbootpractices.querydsl.entity.QEmployee;
import com.springbootpractices.querydsl.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findSpecificEmployees1() {
        JPAQuery<Employee> query = new JPAQuery<>(entityManager);
        QEmployee employee = QEmployee.employee;

        return query.from(employee)
                .where(employee.name.eq("baris"))
                .fetch();
    }

    public List<Employee> findSpecificEmployees2() {
        JPAQuery<Employee> query = new JPAQuery<>(entityManager);
        QEmployee employee = QEmployee.employee;

        return query.from(employee)
                .where(employee.name.contains("ba"),
                        employee.age.gt(5))
                .fetch();
    }
}
