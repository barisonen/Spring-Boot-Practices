package com.springbootpractices.converter.service;

import com.springbootpractices.converter.db.entity.Person;
import com.springbootpractices.converter.db.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
