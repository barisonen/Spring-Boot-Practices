package com.springbootpractices.security.service;

import com.springbootpractices.security.config.JwtUtil;
import com.springbootpractices.security.controller.param.AuthenticationResponse;
import com.springbootpractices.security.controller.param.SignInRequest;
import com.springbootpractices.security.controller.param.SignUpRequest;
import com.springbootpractices.security.entity.Role;
import com.springbootpractices.security.entity.RoleEnum;
import com.springbootpractices.security.entity.User;
import com.springbootpractices.security.exception.UnauthorizedException;
import com.springbootpractices.security.exception.UserExistsException;
import com.springbootpractices.security.repository.RoleRepository;
import com.springbootpractices.security.repository.UserRepository;
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

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse signUp(SignUpRequest signUpRequest) throws UserExistsException {

        Optional<User> user = userRepository.findByEmail(signUpRequest.getEmail());

        if (user.isPresent()) {
            throw new UserExistsException("User exists");
        }

        Set<Role> roles = new HashSet<>();
        Role role = getRole(RoleEnum.ROLE_USER);
        roles.add(role);

        var newUser = User.builder()
                .firstname(signUpRequest.getFirstName())
                .lastname(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .roles(roles)
                .build();

        userRepository.save(newUser);

        var jwtToken = jwtUtil.generateToken(newUser);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private Role getRole(RoleEnum roleUser) {
        Optional<Role> userRole = roleRepository.findRoleByName(roleUser);
        if(userRole.isPresent()) {
            return userRole.get();
        } else {
            Role newRole = new Role();
            newRole.setName(roleUser);
            return newRole;
        }
    }

    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getEmail(),
                        signInRequest.getPassword()
                )
        );

        var user = userRepository.findByEmail(signInRequest.getEmail())
                .orElseThrow();

        var jwtToken = jwtUtil.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public void makeAdmin() throws UnauthorizedException {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            Set<Role> roles = user.get().getRoles();
            Role adminRole = getRole(RoleEnum.ROLE_ADMIN);
            roles.add(adminRole);
            user.get().setRoles(roles);
            userRepository.save(user.get());
        }
        else {
            throw new UnauthorizedException("you are not logged in!");
        }
    }
}
