package com.springbootpractices.springdata.n1query.controller;

import com.springbootpractices.springdata.n1query.service.GlobalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GlobalController {

    private final GlobalService service;

    @GetMapping("/find-all")
    public void findAll() {
        service.findAll();
    }

    @GetMapping("/find-all-with-one-query")
    public void findAllWithOneQuery() {
        service.findAllWithOneQuery();
    }
}
