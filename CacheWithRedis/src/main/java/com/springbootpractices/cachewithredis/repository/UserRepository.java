package com.springbootpractices.cachewithredis.repository;

import com.springbootpractices.cachewithredis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
