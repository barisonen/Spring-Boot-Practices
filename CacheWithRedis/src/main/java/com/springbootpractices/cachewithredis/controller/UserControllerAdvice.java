package com.springbootpractices.cachewithredis.controller;

import com.springbootpractices.cachewithredis.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler({UserNotFoundException.class})
    public final ResponseEntity<String> handleUserNotFoundException(Exception e, WebRequest webRequest) {
        return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
    }
}
