package com.example.jwt.controller;

import com.example.jwt.controller.param.AuthenticationResponse;
import com.example.jwt.controller.param.SignInRequest;
import com.example.jwt.controller.param.SignUpRequest;
import com.example.jwt.exception.UserExistsException;
import com.example.jwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<AuthenticationResponse> signUp(
            @RequestBody SignUpRequest signUpRequest
    ) throws UserExistsException {
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }
    @PostMapping("/signIn")
    public ResponseEntity<AuthenticationResponse> signIn(
            @RequestBody SignInRequest signInRequest
    ) {
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }
}
