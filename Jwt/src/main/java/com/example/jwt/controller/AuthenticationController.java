package com.example.jwt.controller;

import com.example.jwt.controller.param.AuthenticationResponse;
import com.example.jwt.controller.param.SignInRequest;
import com.example.jwt.controller.param.SignUpRequest;
import com.example.jwt.exception.UserExistsException;
import com.example.jwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
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

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleException(BadCredentialsException e) {
        System.out.println(e.toString());

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Bad credentials");
    }
}
