package com.jdbc.service;

import com.jdbc.entity.User;
import com.jdbc.repository.JdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdbcService {

    private final JdbcRepository repository;

    public JdbcService(JdbcRepository repository) {
        this.repository = repository;
    }

    public List<User> process() {
        return repository.process();
    }
}
