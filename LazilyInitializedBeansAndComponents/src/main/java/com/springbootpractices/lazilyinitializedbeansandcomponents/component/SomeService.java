package com.springbootpractices.lazilyinitializedbeansandcomponents.component;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SomeService {

    @Lazy
    @Autowired
    private SomeLazyService someLazyService;

    public SomeService() {
       log.info("some service initialized");
    }

    public void runSomeLazyServiceMethod() {
        someLazyService.runSomething();
    }
}
