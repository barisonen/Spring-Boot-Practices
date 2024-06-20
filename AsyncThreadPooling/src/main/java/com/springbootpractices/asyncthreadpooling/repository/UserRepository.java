package com.springbootpractices.asyncthreadpooling.repository;

import com.springbootpractices.asyncthreadpooling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
