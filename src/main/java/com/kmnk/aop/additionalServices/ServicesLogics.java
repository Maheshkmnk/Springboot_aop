package com.kmnk.aop.additionalServices;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
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
    public void beginTransaction(JoinPoint joinPoint) {
        log.info("transaction started....");
        log.info("the signature of target method {} and args {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @After("within(com.kmnk.aop.repository.*)")//Jointpoint
    public void commitTransaction(JoinPoint joinPoint) {
        log.info("transaction committed");
        log.info("signature >> {}", joinPoint.getSignature());
        log.info("getArgs {}", joinPoint.getArgs());
        log.info("getThis() >> {}", joinPoint.getThis());
        log.info("getStaticPart >> {}", joinPoint.getStaticPart());
        log.info("getTarget >> {}", joinPoint.getTarget());
        log.info("getKind >> {}", joinPoint.getKind());
        log.info("getSourceLocation >> {}", joinPoint.getSourceLocation());
        log.info("toLongString >> {}", joinPoint.toLongString());
        log.info("toShortString >> {}", joinPoint.toShortString());
    }

    @AfterReturning(value = "execution(* com.kmnk.aop.repository.*.*(..))", returning = "data")
    public void returningAdvice(Object data) {
        log.info("successfully completed transaction..");
        log.info("Data is {}", data);
    }

    @AfterThrowing(throwing = "exception", pointcut = "execution(public void com.kmnk.aop.repository.Employee.save())")
    public void exceptionThrowed(Throwable exception) {
        log.info("exception throwed.." + " " + exception.getMessage());
    }

    @Around("within(com.kmnk.aop.repository.*)")
    public Object notification(ProceedingJoinPoint joinPoint) {
        log.info("notification initiated for starting transaction....");
        try {
            Object proceed = joinPoint.proceed();
            log.info("calling method {} and its arguments {} and its returning value {}", joinPoint.getSignature(), joinPoint.getArgs(), proceed);
            return proceed;
        } catch (Throwable e) {
            log.info(e.getMessage());
        }
        log.info("notification initiated for completing transaction..");
        return null;
    }

    @After("@annotation(org.springframework.validation.annotation.Validated)")
    public void annotationPointcutExpression(JoinPoint joinPoint){
        log.info("annotationPointcutExpression executed");
    }

    @Before("bean(Employee)")
    public void beanPointcutExpression(JoinPoint joinPoint){
        log.info("beanPointcutExpression executed");
    }

}

