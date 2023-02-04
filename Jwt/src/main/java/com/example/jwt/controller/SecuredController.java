package com.example.jwt.controller;

import com.example.jwt.exception.UnauthorizedException;
import com.example.jwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/secured-controller")
public class SecuredController {

    private final AuthenticationService authenticationService;

    @GetMapping("/access")
    public ResponseEntity<String> access() {
        return ResponseEntity.ok("you accessed secured content");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> adminAccess() {
        return ResponseEntity.ok("hello admin");
    }

    @GetMapping("/makeMeAdmin")
    public ResponseEntity<String> makeAdmin() throws UnauthorizedException {
        authenticationService.makeAdmin();
        return ResponseEntity.ok("you are now an admin");
    }
}

