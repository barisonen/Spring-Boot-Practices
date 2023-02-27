package com.springbootpractices.redis.repository;

import com.springbootpractices.redis.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<Employee, Long> {

    Employee findByName(String name);
}
