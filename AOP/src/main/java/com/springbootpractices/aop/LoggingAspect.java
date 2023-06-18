package com.springbootpractices.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

    // Pointcut
    // Pointcuts have empty body
    @Pointcut("@annotation(com.springbootpractices.aop.MyProcess)")
    public void logPointcut() {
    }

    // Advice
    @Before("logPointcut()")
    public void logBeforeAllCallsToMethodsWithProcessAnnotationAdvice() {
        log.info("");
        log.info("In Aspect");
        log.info("Before Advice 1: A method with @MyProcess annotation will be called");
        log.info("");
    }

    @Pointcut("execution(public void com.springbootpractices.aop.CarService.repairCar(Double))")
    public void logAllRepairCarMethodCalls() {
    }

    @Before("logAllRepairCarMethodCalls()")
    public void logBeforeMethodCallsAdvice(JoinPoint joinPoint) {
        log.info("In Aspect");
        log.info("Before Advice 2: " + joinPoint.getSignature().getName() + " will be called with arguments: " + Arrays.toString(joinPoint.getArgs()));
        log.info("");
    }

    @After("logAllRepairCarMethodCalls()")
    public void logAfterRepairCarMethodCallsAdvice(JoinPoint joinPoint) {
        log.info("");
        log.info("In Aspect");
        log.info("After Advice: " + joinPoint.getSignature().getName() + " has been executed.");
    }

    @AfterThrowing(pointcut = "logAllRepairCarMethodCalls()", throwing = "ex")
    public void logAfterException(RuntimeException ex) {
        log.info("");
        log.info("In Aspect");
        log.info("After Advice (Exception): error occured (" + ex.getClass() + ") this time. Try again");
    }
}
