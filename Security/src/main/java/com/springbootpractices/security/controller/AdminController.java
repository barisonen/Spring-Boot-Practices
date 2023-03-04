package com.springbootpractices.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/get-admin-data")
    public ResponseEntity<String> getAdminData() {
        return ResponseEntity.ok("data from admin controller");
    }
}
