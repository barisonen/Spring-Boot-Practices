package com.springbootpractices.querydsl.repository;

import com.springbootpractices.querydsl.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>, QuerydslPredicateExecutor<Car> {
}
