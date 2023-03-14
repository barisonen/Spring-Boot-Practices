package com.springbootpractices.n1query.service;

import com.springbootpractices.n1query.entity.Owner;
import com.springbootpractices.n1query.entity.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GlobalService {

    private final OwnerRepository ownerRepository;

    public void findAll() {
        System.out.println("Before findAll");
        List<Owner> owners = ownerRepository.findAll();
        System.out.println("After findAll");
        System.out.println("Before iteration");
        owners.forEach(owner -> System.out.println(owner.getCars().toString()));
        System.out.println("After iteration");
    }

    public void findAllWithOneQuery() {
        System.out.println("Before findAll");
        List<Owner> owners = ownerRepository.findAllWithOneQuery();
        System.out.println("After findAll");
        System.out.println("Before iteration");
        owners.forEach(owner -> System.out.println(owner.getCars().toString()));
        System.out.println("After iteration");
    }
}
