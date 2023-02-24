package com.hibernate;

import com.hibernate.general.User;
import com.hibernate.general.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-controller")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/exercise/{i}")
    public List<User> exercise(@PathVariable int i) {
        return userService.exercise(i);
    }
}
