package com.springbootpractices.lazilyinitializedbeansandcomponents.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Log4j2
public class BeanConfig {

    @Bean
    public Ship getShip() {
        log.info("Ship initialized");
        return new Ship("ship");
    }

    @Bean
    @Lazy
    public LazyCar getCar() {
        log.info("Lazy Car initialized");
        return new LazyCar("lazy car");
    }
}
