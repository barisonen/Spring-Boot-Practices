package com.springbootpractices.asyncthreadpooling.controller;

import com.springbootpractices.asyncthreadpooling.entity.User;
import com.springbootpractices.asyncthreadpooling.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping(value = "/users", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
    public ResponseEntity<Void> saveUsers(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
        List<CompletableFuture<List<User>>> futures = new ArrayList<>();
        for (MultipartFile file : files) {
            futures.add(service.saveUsers(file));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/users", produces = "application/json")
    public CompletableFuture<ResponseEntity<List<User>>> findAllUsers() {
        return service.findAllUsers().thenApply(ResponseEntity::ok);
    }


    @GetMapping(value = "/get-users-async", produces = "application/json")
    public ResponseEntity<Void> getUsers() {
        CompletableFuture<List<User>> users1 = service.findAllUsers();
        CompletableFuture<List<User>> users2 = service.findAllUsers();
        CompletableFuture<List<User>> users3 = service.findAllUsers();
        CompletableFuture.allOf(users1, users2, users3).join();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
