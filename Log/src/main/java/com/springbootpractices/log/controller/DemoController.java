package com.springbootpractices.log.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class DemoController {

    @GetMapping("/log-something")
    public void logSomething() {
        log.error("some error");
        log.info("some info");
        log.debug("some debug");
        log.fatal("some fatal");
    }
}
