package com.springbootpractices.transactions.controller;

import com.springbootpractices.transactions.service.GlobalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/execute")
public class GlobalController {

    private final GlobalService service;

    @PostMapping("/scenario-1")
    public void scenario_1() {
        service.scenario_1();
    }

    @PostMapping("/scenario-2-1")
    public void scenario_2_1() {
        service.scenario_2_1();
    }

    @PostMapping("/scenario-2-2")
    public void scenario_2_2() {
        service.scenario_2_2();
    }
}
