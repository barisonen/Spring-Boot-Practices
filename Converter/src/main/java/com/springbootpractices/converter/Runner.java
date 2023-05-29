package com.springbootpractices.converter;

import com.springbootpractices.converter.db.entity.FullName;
import com.springbootpractices.converter.db.entity.Person;
import com.springbootpractices.converter.db.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Override
    public void run(String... args) {

        Person person1 = new Person();
        FullName fullName1 = new FullName();
        fullName1.setName("baris");
        fullName1.setSurname("onen");
        person1.setFullName(fullName1);

        Person person2 = new Person();
        FullName fullName2 = new FullName();
        fullName2.setName("osman");
        fullName2.setSurname("onen");
        person2.setFullName(fullName2);

        personRepository.saveAll(List.of(person1, person2));
    }
}