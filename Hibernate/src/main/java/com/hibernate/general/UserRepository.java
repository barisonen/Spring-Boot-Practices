package com.hibernate.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameEndingWithAndSurnameEndingWith(String s1, String s2);

    @Query("SELECT u FROM User u WHERE u.age > ?1")
    List<User> exercise3(int age);

    @Query(value = "SELECT * FROM User u WHERE age > ?1", nativeQuery = true)
    List<User> exercise4(int age);

    @Query(value = "SELECT name, surname FROM User", nativeQuery = true)
    List<MyDto> exercise5();
}
