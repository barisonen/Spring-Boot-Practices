package com.example.jwt.service;

import com.example.jwt.config.JwtUtil;
import com.example.jwt.controller.param.AuthenticationResponse;
import com.example.jwt.controller.param.SignInRequest;
import com.example.jwt.controller.param.SignUpRequest;
import com.example.jwt.entity.Role;
import com.example.jwt.entity.RoleEnum;
import com.example.jwt.entity.User;
import com.example.jwt.exception.UnauthorizedException;
import com.example.jwt.exception.UserExistsException;
import com.example.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse signUp(SignUpRequest signUpRequest) throws UserExistsException {

        Optional<User> user = repository.findByEmail(signUpRequest.getEmail());

        if (user.isPresent()) {
            throw new UserExistsException("User exists");
        }

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName(RoleEnum.ROLE_USER);
        roles.add(role);

        var newUser = User.builder()
                .firstname(signUpRequest.getFirstName())
                .lastname(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .roles(roles)
                .build();

        repository.save(newUser);

        var jwtToken = jwtUtil.generateToken(newUser);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getEmail(),
                        signInRequest.getPassword()
                )
        );

        var user = repository.findByEmail(signInRequest.getEmail())
                .orElseThrow();

        var jwtToken = jwtUtil.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public void makeAdmin() throws UnauthorizedException {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = repository.findByEmail(email);
        if(user.isPresent()) {
            Set<Role> roles = user.get().getRoles();
            Role adminRole = new Role();
            adminRole.setName(RoleEnum.ROLE_ADMIN);
            roles.add(adminRole);
            user.get().setRoles(roles);
            repository.save(user.get());
        }
        else {
            throw new UnauthorizedException("you are not logged in!");
        }
    }
}
