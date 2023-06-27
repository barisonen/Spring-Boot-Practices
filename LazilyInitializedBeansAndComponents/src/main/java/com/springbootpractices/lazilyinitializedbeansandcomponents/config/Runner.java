package com.springbootpractices.lazilyinitializedbeansandcomponents.config;

import com.springbootpractices.lazilyinitializedbeansandcomponents.bean.LazyCar;
import com.springbootpractices.lazilyinitializedbeansandcomponents.bean.Ship;
import com.springbootpractices.lazilyinitializedbeansandcomponents.bean.BeanConfig;
import com.springbootpractices.lazilyinitializedbeansandcomponents.component.SomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class Runner implements CommandLineRunner {

    private final SomeService someService;

    @Override
    public void run(String... args) {
        lazyBeanScenario();
        lazyComponentScenario();
    }

    private void lazyBeanScenario() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanConfig.class);
        ctx.refresh();
        ctx.getBean(Ship.class);
        ctx.getBean(LazyCar.class);
    }

    private void lazyComponentScenario() {
        someService.runSomeLazyServiceMethod();
    }
}
