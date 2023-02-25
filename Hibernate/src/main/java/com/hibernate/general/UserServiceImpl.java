package com.hibernate.general;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final EMRepository emRepository;

    @Override
    @Transactional
    public List<User> exercise(int i) {
        //return userRepository.findByNameEndingWithAndSurnameEndingWith("an", "en");
        //return userRepository.exercise3(i);
        //return emRepository.exercise(i);
        //return emRepository.exercise2(i);
        //return emRepository.exercise3();
        List<User> users = userRepository.exercise3(i);
        users.forEach(o -> System.out.println(o.getName() + "-" + o.getSurname()));
        return new ArrayList<>();
    }
}
