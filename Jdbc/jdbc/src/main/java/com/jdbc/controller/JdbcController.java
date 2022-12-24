package com.jdbc.controller;

import com.jdbc.entity.User;
import com.jdbc.service.JdbcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JdbcController {

    private final JdbcService service;

    public JdbcController(JdbcService service) {
        this.service = service;
    }

    @GetMapping("/process")
    public List<User> process() {
        return service.process();
    }
}
