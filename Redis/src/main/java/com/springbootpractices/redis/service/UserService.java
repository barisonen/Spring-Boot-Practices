package com.springbootpractices.redis.service;

import com.springbootpractices.redis.exception.UserNotFoundException;
import com.springbootpractices.redis.model.User;
import com.springbootpractices.redis.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("user not found");
        }
        else {
            return optionalUser.get();
        }
    }

    public void delete(Long id) throws UserNotFoundException {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new UserNotFoundException("user not found");
        }
    }

    public User update(User user) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("user not found");
        }
        else {
            User existingUser = optionalUser.get();
            existingUser.setName(user.getName());
            existingUser.setFollowers(user.getFollowers());
            return userRepository.save(existingUser);
        }
    }
}
