package com.springbootpractices.security.repository;

import com.springbootpractices.security.entity.Role;
import com.springbootpractices.security.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findRoleByName(RoleEnum name);
}
