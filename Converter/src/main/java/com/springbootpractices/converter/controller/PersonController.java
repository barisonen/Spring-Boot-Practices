package com.springbootpractices.converter.controller;

import com.springbootpractices.converter.db.entity.Person;
import com.springbootpractices.converter.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/get-people")
    public List<Person> findAll() {
        return personService.findAll();
    }
}
