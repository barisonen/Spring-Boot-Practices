package com.springbootpractices.redis.service;

import com.springbootpractices.redis.model.Employee;
import com.springbootpractices.redis.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisRepository redisRepository;

    public void createEmployee(String name, String surname) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        redisRepository.save(employee);
    }

    public Employee getEmployee(String name) {
        return redisRepository.findByName(name);
    }

    public List<Employee> getEmployees() {
        Iterable<Employee> redisEmployeeIterable = redisRepository.findAll();
        Iterator<Employee> iterator = redisEmployeeIterable.iterator();
        List<Employee> resultList = new ArrayList<>();
        while(iterator.hasNext()) {
            resultList.add(iterator.next());
        }

        return resultList;
    }
}
