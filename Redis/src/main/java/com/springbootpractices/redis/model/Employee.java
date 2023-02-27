package com.springbootpractices.redis.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Setter
@RedisHash
public class Employee {

    @Id
    private Long id;

    @Indexed
    private String name;
    private String surname;
}
