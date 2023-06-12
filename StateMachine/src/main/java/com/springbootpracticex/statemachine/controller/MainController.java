package com.springbootpracticex.statemachine.controller;

import com.springbootpracticex.statemachine.service.MainService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainController {

    private final MainService mainService;

    @GetMapping("/process")
    public HttpStatus process() {
        mainService.process();
        return HttpStatus.OK;
    }

    @GetMapping("/reset")
    public HttpStatus reset() {
        mainService.reset();
        return HttpStatus.OK;
    }
}
