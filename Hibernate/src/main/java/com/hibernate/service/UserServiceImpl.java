package com.hibernate.service;

import com.hibernate.entity.User;
import com.hibernate.repository.EMRepository;
import com.hibernate.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final EMRepository emRepository;

    public UserServiceImpl(UserRepository userRepository, EMRepository emRepository) {
        this.userRepository = userRepository;
        this.emRepository = emRepository;
    }
    @Override
    @Transactional
    public List<User> exercise(int i) {
        //return userRepository.findByNameEndingWithAndSurnameEndingWith("an", "en");
        //return userRepository.exercise3(i);
        //return emRepository.exercise(i);
        //return emRepository.exercise2(i);
        return emRepository.exercise3();
    }
}
