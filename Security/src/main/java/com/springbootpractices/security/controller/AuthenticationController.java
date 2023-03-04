package com.springbootpractices.security.controller;

import com.springbootpractices.security.controller.param.AuthenticationResponse;
import com.springbootpractices.security.controller.param.SignInRequest;
import com.springbootpractices.security.controller.param.SignUpRequest;
import com.springbootpractices.security.exception.UserExistsException;
import com.springbootpractices.security.service.AuthenticationService;
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
