package com.springbootpractices.redis;

import com.springbootpractices.redis.model.User;
import com.springbootpractices.redis.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheWithRedisApplication implements CommandLineRunner {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final UserRepository userRepository;

    public CacheWithRedisApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CacheWithRedisApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        LOG.info("Saving users. Current user count is {}.", userRepository.count());
        User baris = new User("Baris", 1500);
        User osman = new User("Osman", 25000);

        userRepository.save(baris);
        userRepository.save(osman);
        LOG.info("Done saving users. User list: {}.", userRepository.findAll());
    }
}
