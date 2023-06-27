package com.springbootpractices.lazilyinitializedbeansandcomponents.component;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@Log4j2
public class SomeLazyService {

    public SomeLazyService() {
        log.info("Some lazy service initialized");
    }

    public void runSomething() {
        log.info("running in some lazy service");
    }
}
