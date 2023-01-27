package com.springbootpractices.cachewithredis.service;

import com.springbootpractices.cachewithredis.exception.UserNotFoundException;
import com.springbootpractices.cachewithredis.model.User;
import com.springbootpractices.cachewithredis.repository.UserRepository;
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

    public void delete(Long id) {
        userRepository.deleteById(id);
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
