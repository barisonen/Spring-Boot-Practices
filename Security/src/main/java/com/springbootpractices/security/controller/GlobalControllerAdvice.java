package com.springbootpractices.security.controller;

import com.springbootpractices.security.exception.UnauthorizedException;
import com.springbootpractices.security.exception.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler({ UserExistsException.class })
    public ResponseEntity<String> handleException(UserExistsException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler({ UnauthorizedException.class })
    public ResponseEntity<String> handleException(UnauthorizedException e) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(e.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleException(BadCredentialsException e) {
        System.out.println(e.toString());

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Bad credentials");
    }
}
