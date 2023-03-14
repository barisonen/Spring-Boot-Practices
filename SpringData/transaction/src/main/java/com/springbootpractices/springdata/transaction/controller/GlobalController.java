package com.springbootpractices.springdata.transaction.controller;

import com.springbootpractices.springdata.transaction.service.GlobalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/execute")
public class GlobalController {

    private final GlobalService service;

    @GetMapping("/scenario1")
    public void scenario1() {
        service.scenario1();
    }
}
