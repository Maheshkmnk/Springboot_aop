package com.kmnk.aop.additionalServices;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ServicesLogics {

//    @Pointcut("execution(public void com.kmnk.aop.repository.Employee.save())")
//    public void p1(){}


    @Before("execution(* com.kmnk.aop.repository.*.*(..))")//Jointpoint
    public void beginTransaction(){
        log.info("transaction started....");
    }

    @After("execution(* com.kmnk.aop.repository.Employee.*(..))")//Jointpoint
    public void commitTransaction(){
        log.info("transaction committed");
    }

    @AfterReturning("execution(* com.kmnk.aop.repository.*.*(..))")
    public void returningAdvice(){
        log.info("successfully completed transaction..");
    }

    @AfterThrowing(throwing = "exception", pointcut = "execution(public void com.kmnk.aop.repository.Employee.save())")
    public void exceptionThrowed(Throwable exception){
        log.info("exception throwed.." + " " +exception.getMessage());
    }

    @Around("within(com.kmnk.aop.repository.*)")
    public void notification(ProceedingJoinPoint joinPoint) {
        log.info("notification initiated for starting transaction....");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        log.info("notification initiated for completing transaction..");
    }

}

