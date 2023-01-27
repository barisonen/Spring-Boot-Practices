package com.springbootpractices.cachewithredis.controller;

import com.springbootpractices.cachewithredis.exception.UserNotFoundException;
import com.springbootpractices.cachewithredis.model.User;
import com.springbootpractices.cachewithredis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Cacheable(value = "users", key = "#userId", unless = "#result.followers < 10000")
    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable String userId) throws UserNotFoundException {
        LOG.info("Getting user with ID {}", userId);
        return userService.findById(Long.valueOf(userId));
    }

    @CachePut(value = "users", key = "#user.id")
    @PutMapping("/update")
    public User updatePersonById(@RequestBody User user) throws UserNotFoundException {
        return userService.update(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        LOG.info("deleting person with id {}", id);
        userService.delete(id);
    }
}