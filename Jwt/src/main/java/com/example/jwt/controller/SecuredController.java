package com.example.jwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/secured-controller")
public class SecuredController {

    @GetMapping("/access")
    public ResponseEntity<String> access() {
        return ResponseEntity.ok("you accessed secured content");
    }
}

